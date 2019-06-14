/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.compiler.builder.processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.internal.utils.FileUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.yakindu.base.types.Package;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yakindu.solidity.compiler.result.CompileError;
import com.yakindu.solidity.compiler.result.CompiledContract;
import com.yakindu.solidity.compiler.result.CompilerOutput;
import com.yakindu.solidity.compiler.result.GasEstimates;
import java.util.HashSet;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * @author Andreas Muelder
 */
@Singleton
@SuppressWarnings("restriction")
public class SolidityMarkerCreator extends MarkerCreator {

	final Pattern issueLength = Pattern.compile("\\^-*\\^");
	final Pattern issueContractNameLine = Pattern.compile("contract \\w*");

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	// NORMAL_VALIDATION
	public final static String NORMAL_VALIDATION = "org.eclipse.xtext.ui.check.normal"; //$NON-NLS-1$

	public void createMarkers(final CompilerOutput compilerOutput, final Set<IResource> filesToCompile) {
		createErrorMarkers(compilerOutput.getErrors(), filesToCompile);
		createInfoMarkers(compilerOutput.getContracts(), filesToCompile);
	}

	protected void createInfoMarkers(Map<String, Map<String, CompiledContract>> contracts,
			Set<IResource> filesToCompile) {
		for (Entry<String, Map<String, CompiledContract>> contractEntry : contracts.entrySet()) {
			IFile file = findFileForName(filesToCompile, contractEntry.getKey());
			for (Entry<String, CompiledContract> contract : contractEntry.getValue().entrySet()) {
				createInfoMarkers(contract.getValue(), file);
			}
		}
	}

	protected void createInfoMarkers(CompiledContract contract, IFile file) {
		if (contract.getEvm() == null || contract.getEvm().getGasEstimates() == null) {
			return;
		}
		GasEstimates gasEstimates = contract.getEvm().getGasEstimates();

		SolcIssue solcIssue = new SolcIssue();
		solcIssue.setIFile(file);
		solcIssue.setLineNumber(1);
		solcIssue.setSeverity(Severity.INFO);
		String message = prettyPrint(gasEstimates);
		solcIssue.setMessage(message);
		solcIssue.setErrorCode(createErrorCodeFromMessage(Severity.INFO, message));
		EObject element = getEObject(file, 0);
		solcIssue.setUriToProblem(EcoreUtil.getURI(element));

		try {
			super.createMarker(solcIssue, file, NORMAL_VALIDATION);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	protected String prettyPrint(GasEstimates gasEstimates) {
		if (gasEstimates == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("Gas estimations:\n");
		builder.append("\tCreation:\n");
		printMethodEstimations(gasEstimates.getCreation(), builder);
		builder.append("\tInternal:\n");
		printMethodEstimations(gasEstimates.getInternal(), builder);
		builder.append("\tExternal:\n");
		printMethodEstimations(gasEstimates.getExternal(), builder);
		return builder.toString();
	}

	protected void printMethodEstimations(Map<String, String> map, StringBuilder builder) {
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				builder.append("\t\t" + entry.getKey() + ": " + entry.getValue() + "\n");
			}
		}
	}

	protected void createErrorMarkers(final List<CompileError> errors, final Set<IResource> filesToCompile) {
		if (errors == null) {
			return;
		}
		for (CompileError error : errors) {
			SolcIssue issue = createSolcIssue(error, filesToCompile);
			try {
				super.createMarker(issue, issue.getIFile(), NORMAL_VALIDATION);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	protected SolcIssue createSolcIssue(CompileError error, Set<IResource> filesToCompile) {
		String[] parts = error.getFormattedMessage().split(":");
		String fileName = error.getSourceLocation().getFile();
		IFile errorFile = findFileForName(filesToCompile, fileName);
		int lineNumber = extractNumber(partAtIndex(parts, 1));
		int columnNumber = extractNumber(partAtIndex(parts, 2));
		Map<Integer, String> fileContent = getFileContent(errorFile);
		int offset = error.getSourceLocation().getStart();
		int length = calculateIssueLength(fileContent.get(lineNumber), partAtIndex(parts, 4));

		Severity severity = calculateSeverity(error.getSeverity());
		String message = error.getMessage();
		SolcIssue solcIssue = new SolcIssue();
		solcIssue.setIFile(errorFile);
		solcIssue.setLineNumber(lineNumber);
		solcIssue.setColumnNumber(columnNumber);
		solcIssue.setSeverity(severity);
		solcIssue.setMessage(message);
		solcIssue.setOffset(offset);
		solcIssue.setLength(length);
		solcIssue.setErrorCode(createErrorCodeFromMessage(severity, message));
		EObject element = getEObject(errorFile, offset);
		if (element != null) {
			solcIssue.setUriToProblem(EcoreUtil.getURI(element));
		}
		return solcIssue;
	}

	protected String partAtIndex(String[] parts, int i) {
		try {
			return parts[i];
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return "";
		}
	}

	protected int extractNumber(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	protected IFile findFileForName(Set<IResource> filesToCompile, String fileName) {
		IFile errorFile = filesToCompile.stream().filter(file -> file.getName().equals(fileName))
				.map(file -> (IFile) file).findFirst().orElse((IFile) filesToCompile.stream().findFirst().orElse(null));
		return errorFile;
	}

	protected EObject getEObject(IFile errorFile, int offset) {
		Resource resource = new ResourceSetImpl()
				.getResource(URI.createPlatformResourceURI(errorFile.getFullPath().toString(), true), true);
		if (offset == 0) {
			EList<EObject> resourceContent = resource.getContents();
			if (!resourceContent.isEmpty()) {
				EObject object = resourceContent.get(0);
				List<Package> packages = EcoreUtil2.getAllContentsOfType(object, Package.class);
				if (!packages.isEmpty()) {
					return packages.get(0);
				}
			}
		}
		return offsetHelper.resolveContainedElementAt((XtextResource) resource, offset);
	}

	protected String createErrorCodeFromMessage(Severity severity, String message) {
		switch (severity) {
		case ERROR:
			return SolidityError.getCodeForMessage(message);
		case WARNING:
			return SolidityWarning.getCodeForMessage(message);
		default:
			return "info";
		}
	}

	protected Map<Integer, String> getFileContent(IFile file) {
		String fileEnding = FileUtil.getLineSeparator(file);
		Map<Integer, String> content = Maps.newHashMap();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(file.getContents(true), file.getCharset()));) {
			String line = reader.readLine();
			int lastLineNumber = 1;
			while (line != null) {
				content.put(lastLineNumber, line + fileEnding);
				line = reader.readLine();
				lastLineNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	protected int calculateIssueLength(String errorLine, String issueDetails) {
		if (spansOverMultipleLines(issueDetails)) {
			if (errorLine.contains("function")) {
				return errorLine.substring(errorLine.indexOf("function"), errorLine.indexOf(")") + 1).length();
			}
			if (errorLine.contains("constructor")) {
				return errorLine.substring(errorLine.indexOf("constructor"), errorLine.indexOf(")") + 1).length();
			}
			if (errorLine.contains("contract")) {
				return calculateIssueLength(issueDetails, this.issueContractNameLine);
			}
		} else {
			return calculateIssueLength(issueDetails, this.issueLength);
		}
		return 0;
	}

	protected boolean spansOverMultipleLines(String issueDetails) {
		return issueDetails.contains("Spanning multiple lines.")
				|| issueDetails.contains("spans across multiple lines");
	}

	protected int calculateIssueLength(String errorMessage, Pattern pattern) {
		Matcher matcher = pattern.matcher(errorMessage);
		if (matcher.find()) {
			return matcher.group(0).length();

		}
		return 0;
	}

	protected Severity calculateSeverity(String severety) {
		switch (severety) {
		case "warning":
			return Severity.WARNING;
		case "error":
			return Severity.ERROR;
		default:
			return Severity.INFO;
		}
	}
}

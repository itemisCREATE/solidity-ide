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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yakindu.solidity.compiler.result.CompileError;
import com.yakindu.solidity.compiler.result.CompiledContract;
import com.yakindu.solidity.compiler.result.CompilerOutput;
import com.yakindu.solidity.compiler.result.GasEstimates;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * @author Andreas Muelder
 */
@Singleton
@SuppressWarnings("restriction")
public class SolidityMarkerCreator extends MarkerCreator {

	final Pattern pattern = Pattern.compile("\\^-*\\^");

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	// NORMAL_VALIDATION
	public final static String NORMAL_VALIDATION = "org.eclipse.xtext.ui.check.normal"; //$NON-NLS-1$

	void createMarkers(final CompilerOutput compilerOutput, final Set<IResource> filesToCompile) {
		if (compilerOutput == null) {
			return;
		}
		createErrorMarkers(compilerOutput.getErrors(), filesToCompile);
		createInfoMarkers(compilerOutput.getContracts(), filesToCompile);
	}

	private void createInfoMarkers(Map<String, CompiledContract> contracts, Set<IResource> filesToCompile) {
		for (Entry<String, CompiledContract> contract : contracts.entrySet()) {
			IFile file = findFileForName(filesToCompile, contract.getKey());
			createInfoMarkers(contract.getValue(), file);
		}
	}

	private void createInfoMarkers(CompiledContract contract, IFile file) {

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

	private String prettyPrint(GasEstimates gasEstimates) {
		if(gasEstimates == null) {
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

	private void printMethodEstimations(Map<String, String> map, StringBuilder builder) {
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				builder.append("\t\t" + entry.getKey() + ": " + entry.getValue() + "\n");
			}
		}
	}

	private void createErrorMarkers(final List<CompileError> errors, final Set<IResource> filesToCompile) {
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

	private SolcIssue createSolcIssue(CompileError error, Set<IResource> filesToCompile) {
		String[] parts = error.getFormattedMessage().split(":");
		String fileName = partAtIndex(parts, 0);
		IFile errorFile = findFileForName(filesToCompile, fileName);
		int lineNumber = extractNumber(partAtIndex(parts, 1));
		int columnNumber = extractNumber(partAtIndex(parts, 2));
		Map<Integer, String> fileContent = getFileContent(errorFile);
		int offset = calculateOffset(fileContent, columnNumber, lineNumber);
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
		solcIssue.setUriToProblem(EcoreUtil.getURI(element));
		return solcIssue;
	}

	private String partAtIndex(String[] parts, int i) {
		try {
			return parts[i];
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return "";
		}
	}

	private int extractNumber(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private IFile findFileForName(Set<IResource> filesToCompile, String fileName) {
		IFile errorFile = filesToCompile.stream().filter(file -> file.getName().equals(fileName))
				.map(file -> (IFile) file).findFirst().orElse((IFile)filesToCompile.stream().findFirst().orElse(null));
		return errorFile;
	}

	private EObject getEObject(IFile errorFile, int offset) {
		Resource resource = new ResourceSetImpl()
				.getResource(URI.createPlatformResourceURI(errorFile.getFullPath().toString(), true), true);
		return offsetHelper.resolveContainedElementAt((XtextResource) resource, offset);
	}

	private String createErrorCodeFromMessage(Severity severity, String message) {
		switch (severity) {
			case ERROR :
				return "error";
			case WARNING :
				return SolidityWarning.getCodeForMessage(message);
			default :
				return "info";
		}
	}

	private Map<Integer, String> getFileContent(IFile file) {
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

	private int calculateOffset(Map<Integer, String> fileContent, int columnNumber, int lineNumber) {
		int start = columnNumber - 1;
		for (int i = 1; i < lineNumber; i++) {
			String line = fileContent.get(i);
			start += line.length();
		}
		return (start > 0)? start : 0;
	}

	private int calculateIssueLength(String errorLine, String issueDetails) {
		if (issueDetails.contains("Spanning multiple lines.")) {
			if (errorLine.contains("function")) {
				return errorLine.substring(errorLine.indexOf("function"), errorLine.indexOf(")") + 1).length();
			}
			if (errorLine.contains("contract")) {
				return errorLine.substring(errorLine.indexOf("contract"), errorLine.indexOf("{")).length();
			}
		} else {
			return calculateIssueLength(issueDetails);
		}
		return 0;
	}

	private int calculateIssueLength(String errorMessage) {
		Matcher matcher = pattern.matcher(errorMessage);
		if (matcher.find()) {
			return matcher.group(0).length();

		}
		return 0;
	}

	private Severity calculateSeverity(String severety) {
		switch (severety) {
			case "warning" :
				return Severity.WARNING;
			case "error" :
				return Severity.ERROR;
			default :
				return Severity.INFO;
		}
	}
}

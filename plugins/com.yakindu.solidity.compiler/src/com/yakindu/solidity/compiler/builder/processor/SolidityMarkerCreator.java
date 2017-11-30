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

import org.eclipse.core.internal.utils.FileUtil;
import org.eclipse.core.resources.IFile;
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

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * @author Andreas Muelder
 */
@Singleton
@SuppressWarnings("restriction")
public class SolidityMarkerCreator extends MarkerCreator {

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	// NORMAL_VALIDATION
	public final static String NORMAL_VALIDATION = "org.eclipse.xtext.ui.check.normal"; //$NON-NLS-1$

	private Map<Integer, String> fileContent;

	private int lineEndingLength;

	void createMarkers(List<String> issues, IFile file) {
		fileContent = getFileContent(file);

		for (String issue : issues) {
			Resource resource = new ResourceSetImpl()
					.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
			SolcIssue solcIssue = createSolcIssue(issue, resource);
			try {
				super.createMarker(solcIssue, file, NORMAL_VALIDATION);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

	}

	private SolcIssue createSolcIssue(String issue, Resource resource) {
		String[] parts = issue.split(":");
		int lineNumber = Integer.parseInt(parts[2]);
		int columnNumber = Integer.parseInt(parts[3]);
		Severity severity = calculateSeverity(parts[4].trim());
		String message;
		if (severity == Severity.INFO) {
			message = parts[4].trim();
		} else {
			message = parts[5].substring(0, parts[5].indexOf(System.getProperty("line.separator"))).trim();
		}
		String issueDetails = parts[5].substring(parts[5].indexOf(System.getProperty("line.separator")),
				parts[5].length());
		boolean isMultiline = issueDetails.contains("Spanning multiple lines.");
		int offset = calculateOffset(columnNumber, lineNumber);
		int length = calculateIssueLength(lineNumber, issueDetails, isMultiline);
		SolcIssue solcIssue = new SolcIssue();
		solcIssue.setLineNumber(lineNumber);
		solcIssue.setColumnNumber(columnNumber);
		solcIssue.setSeverity(severity);
		solcIssue.setMessage(message);
		solcIssue.setOffset(offset);
		solcIssue.setLength(length);
		solcIssue.setErrorCode(createErrorCodeFromMessage(severity, message));
		EObject element = offsetHelper.resolveContainedElementAt((XtextResource) resource, offset);
		solcIssue.setUriToProblem(EcoreUtil.getURI(element));
		return solcIssue;
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
		lineEndingLength = FileUtil.getLineSeparator(file).length();
		Map<Integer, String> content = Maps.newHashMap();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(file.getContents(true), file.getCharset()));) {
			String line = reader.readLine();
			int lastLineNumber = 1;
			while (line != null) {
				content.put(lastLineNumber, line);
				line = reader.readLine();
				lastLineNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	private int calculateOffset(int columnNumber, int lineNumber) {
		int start = columnNumber - 1;
		for (int i = 1; i < lineNumber; i++) {
			String line = fileContent.get(i);
			// +1 for \n at the end of each line
			start += line.length() + lineEndingLength;
		}
		return start;
	}

	private int calculateIssueLength(int lineNumber, String issueDetails, boolean isMultiline) {
		String line = fileContent.get(lineNumber);
		if (isMultiline) {
			if (line.contains("function")) {
				return line.substring(line.indexOf("function"), line.indexOf(")") + 1).length();
			}
			if (line.contains("contract")) {
				return line.substring(line.indexOf("contract"), line.indexOf("{")).length();
			}
		} else {
			int first = issueDetails.indexOf("^");
			int last = issueDetails.lastIndexOf("^");
			return (last - first);
		}
		return 0;
	}

	private Severity calculateSeverity(String severety) {
		switch (severety) {
			case "Warning" :
				return Severity.WARNING;
			case "Error" :
				return Severity.ERROR;
			default :
				return Severity.INFO;
		}
	}
}

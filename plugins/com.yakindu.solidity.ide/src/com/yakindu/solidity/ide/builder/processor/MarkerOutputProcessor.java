package com.yakindu.solidity.ide.builder.processor;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
/**
 * @author Florian Antony - Initial contribution and API
 */
public class MarkerOutputProcessor implements SolcOutputProcessor {

	private static final String LINE_BREAK = System.getProperty("line.separator");

	private final IFile file;

	private String issue;

	private ArrayList<SolcIssue> issues;

	public MarkerOutputProcessor(IFile file) {
		this.issues = Lists.newArrayList();
		this.file = file;
		this.issue = "";
	}

	@Override
	public void processLine(String line) {
		if (line.startsWith(fileLocation())) {
			if (!issue.isEmpty()) {
				String[] parts = issue.split(":");
				if (parts.length < 6) {
					return;
				}
				issues.add(new SolcIssue(file, issue));
				issue = "";
			}
			issue += line;
		} else {
			issue += (LINE_BREAK + line);
		}
	}

	protected void createMarker(SolcIssue issue) {
		try {
			IMarker marker = file.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.LOCATION, issue.getLocation());
			marker.setAttribute(IMarker.SEVERITY, issue.getSeverity());
			marker.setAttribute(IMarker.CHAR_START, issue.getStart());
			marker.setAttribute(IMarker.CHAR_END, issue.getEnd());
			marker.setAttribute(IMarker.LINE_NUMBER, issue.getLineNumber());
			marker.setAttribute(Issue.COLUMN_KEY, issue.getColumnKey());
			marker.setAttribute(IMarker.MESSAGE, issue.getMessage());
		} catch (CoreException e) {
			// TODO logging
		}
	}

	private String fileLocation() {
		return file.getLocation().toOSString();
	}

	@Override
	public void complete() {
		for (SolcIssue issue : issues) {
			createMarker(issue);
		}
	}

}

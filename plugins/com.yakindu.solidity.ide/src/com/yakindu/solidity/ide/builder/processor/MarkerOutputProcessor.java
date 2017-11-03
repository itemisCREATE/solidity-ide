package com.yakindu.solidity.ide.builder.processor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
/**
 * @author Florian Antony - Initial contribution and API
 */
public class MarkerOutputProcessor implements SolcOutputProcessor {

	private static final String LINE_BREAK = System.getProperty("line.separator");

	private final IFile file;

	private String issue;

	public MarkerOutputProcessor(IFile file) {
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
				createMarker(parts);
				issue = "";
			}
			issue += line;
		} else {
			issue += (LINE_BREAK + line);
		}
	}

	protected void createMarker(String[] parts) {
		try {
			IMarker marker = file.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.LINE_NUMBER, Integer.parseInt(parts[2].trim()));
			marker.setAttribute(IMarker.MESSAGE, format(parts[5]));
			marker.setAttribute(IMarker.SEVERITY, getSeverity(parts[4].trim()));
		} catch (CoreException e) {
			// TODO logging
		}
	}

	protected String format(String message) {
		return message.trim();
	}

	private int getSeverity(String type) {
		switch (type) {
			case "Warning" :
				return IMarker.SEVERITY_WARNING;
			case "Error" :
				return IMarker.SEVERITY_ERROR;
			default :
				return IMarker.SEVERITY_INFO;
		}
	}

	private String fileLocation() {
		return file.getLocation().toOSString();
	}

	@Override
	public void complete() {
		// Nothing to do here
	}

}

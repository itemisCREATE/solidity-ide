package com.yakindu.solidity.ide.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

public class MarkerBuilder {

	public void getMarker(IFile file, String line) {
		String[] parts = line.split(":");
		if(parts.length < 6) {
			return;
		}
		IMarker marker;
		try {
			marker = file.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.LINE_NUMBER, Integer.parseInt(parts[2].trim()));
			marker.setAttribute(IMarker.MESSAGE, parts[5].trim());
			marker.setAttribute(IMarker.SEVERITY, getSeverity(parts[4].trim()));
		} catch (CoreException e) {
			// TODO logging
		}
	}

	private int getSeverity(String type) {
		switch (type) {
			case "Warning" :
				return IMarker.SEVERITY_WARNING;
			default :
				return IMarker.SEVERITY_INFO;
		}
	}

}

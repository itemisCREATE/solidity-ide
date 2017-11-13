package com.yakindu.solidity.compiler.builder.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
/**
 * @author Florian Antony - Initial contribution and API
 */
@Singleton
public class MarkerOutputProcessor implements ISolcOutputProcessor {

	private static final String LINE_BREAK = System.getProperty("line.separator");

	@Inject
	private SolidityMarkerCreator creator;

	@Override
	public void processLineForFile(BufferedReader output, IFile file) throws IOException {
		String line;
		String issue = "";
		line = output.readLine();
		final List<String> issues = Lists.newArrayList();
		while (line != null && !Thread.currentThread().isInterrupted()) {
			if (!line.isEmpty()) {
				issue = processLine(line, issue, issues, file);
			}
			line = output.readLine();
		}
		creator.createMarkers(issues, file);
	}

	private String processLine(String line, String issue, List<String> issues, IFile file) {
		if (line.startsWith(file.getLocation().toOSString())) {
			if (!issue.isEmpty()) {
				String[] parts = issue.split(":");
				if (parts.length < 6) {
					return issue;
				}
				issues.add(issue);
				issue = "";
			}
			issue += line;
		} else {
			issue += (LINE_BREAK + line);
		}
		return issue;
	}
}

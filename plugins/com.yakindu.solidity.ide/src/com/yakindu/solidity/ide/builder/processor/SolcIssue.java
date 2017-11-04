package com.yakindu.solidity.ide.builder.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;

import com.google.common.collect.Maps;

public class SolcIssue {

	private class IssueDescription {

		private final String[] parts;

		IssueDescription(String issue) {
			parts = issue.split(":");
		}

		int getLineNumber() {
			return Integer.parseInt(parts[2]);
		}

		int getColumnNumber() {
			return Integer.parseInt(parts[3]);
		}

		public int getSeverity() {
			String string = parts[4].trim();
			switch (string) {
				case "Warning" :
					return IMarker.SEVERITY_WARNING;
				case "Error" :
					return IMarker.SEVERITY_ERROR;
				default :
					return IMarker.SEVERITY_INFO;
			}
		}

		public String getMessage() {
			return parts[5].substring(0, parts[5].indexOf(System.getProperty("line.separator")));
		}

		public String getIssueDetails() {
			return parts[5].substring(parts[5].indexOf(System.getProperty("line.separator")), parts[5].length());
		}

		public boolean isMultiline() {
			return getIssueDetails().contains("Spanning multiple lines.");
		}

		public String getFile() {
			return parts[0] + parts[1];
		}

	}

	private final Map<Integer, String> fileContent;
	private final IssueDescription issueDescription;
	private int lastLineNumber;

	public SolcIssue(IFile file, String issue) {
		this.issueDescription = new IssueDescription(issue);
		this.fileContent = Maps.newHashMap();
		try (BufferedReader reader = new BufferedReader(new FileReader(file.getLocation().toOSString()))) {
			String line = reader.readLine();
			this.lastLineNumber = 1;
			while (line != null) {
				fileContent.put(lastLineNumber, line);
				line = reader.readLine();
				lastLineNumber++;
			}
		} catch (Exception e) {
		}
	}

	public String getLocation() {
		return issueDescription.getFile() + "line: " + issueDescription.getLineNumber();
	}

	public int getLineNumber() {
		return issueDescription.getLineNumber();
	}

	public int getStart() {
		int start = issueDescription.getColumnNumber() - 1;
		int lineNumber = issueDescription.getLineNumber();
		for (int i = 1; i < lineNumber; i++) {
			start += fileContent.get(i).length();
			start++;
		}
		return start;
	}

	public String getColumnKey() {
		return issueDescription.getColumnNumber() + "";
	}

	public int getEnd() {
		int end = getStart();
		if (issueDescription.isMultiline()) {
			end += calculateIssueLength();
		} else {
			String details = issueDescription.getIssueDetails();
			int first = details.indexOf("^");
			int last = details.lastIndexOf("^");
			end += (last - first);
		}
		return end;
	}

	private int calculateIssueLength() {
		int length = 0;
		int opening = 0;
		int closing = 0;
		for (int i = issueDescription.getLineNumber(); i < lastLineNumber; i++) {
			char[] chars = fileContent.get(i).toCharArray();
			for (char c : chars) {
				length++;
				if (c == '{') {
					opening++;
				}
				if (c == '}') {
					closing++;
				}
				if (opening != 0 && opening == closing) {
					return length;
				}
			}
		}
		return length;
	}

	public String getMessage() {
		return issueDescription.getMessage();
	}

	public int getSeverity() {
		return issueDescription.getSeverity();
	}

	// private int issueStart(int lineNumber, int column) {
	// int result = column - 1;
	// try (BufferedReader reader = new BufferedReader(new
	// FileReader(fileLocation()))) {
	// for (int i = 1; i < lineNumber; i++) {
	// String line = reader.readLine();
	// result += line.length();
	// result++;
	// }
	// } catch (Exception e) {
	// // TODO
	// }
	// return result;
	// }
	//
	// protected String format(String message) {
	// return message.trim();
	// }
	//
	// private int getSeverity(String type) {
	// switch (type) {
	// case "Warning" :
	// return IMarker.SEVERITY_WARNING;
	// case "Error" :
	// return IMarker.SEVERITY_ERROR;
	// default :
	// return IMarker.SEVERITY_INFO;
	// }
	// }

}

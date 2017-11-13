package com.yakindu.solidity.compiler.builder.processor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

public class SolcIssue implements Issue {

	private URI uriToProblem;
	private int lineNumber;
	private int columnNumber;
	private String message;
	private Integer offset;
	private Integer issueLength;
	private Severity severity;

	@Override
	public URI getUriToProblem() {
		return uriToProblem;
	}

	public Integer getLineNumber() {
		return this.lineNumber;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public Integer getColumn() {
		return this.columnNumber;
	}

	public String getMessage() {
		return this.message;
	}

	public Severity getSeverity() {
		return this.severity;
	}

	@Override
	public String getCode() {
		return "TODO";
	}

	@Override
	public CheckType getType() {
		return CheckType.NORMAL;
	}

	@Override
	public boolean isSyntaxError() {
		return false;
	}

	@Override
	public String[] getData() {
		return new String[]{};
	}

	@Override
	public Integer getLength() {
		return this.issueLength;
	}

	void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;

	}

	void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;

	}

	void setMessage(String message) {
		this.message = message;

	}

	void setOffset(int offset) {
		this.offset = offset;
	}

	void setSeverity(Severity severity) {
		this.severity = severity;
	}

	void setUriToProblem(URI uri) {
		uriToProblem = uri;
	}

	void setLength(int length) {
		this.issueLength = length;
	}
}

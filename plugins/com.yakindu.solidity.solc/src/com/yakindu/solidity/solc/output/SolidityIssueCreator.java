package com.yakindu.solidity.solc.output;

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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.base.types.Package;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.yakindu.solidity.solc.result.CompileError;
import com.yakindu.solidity.solc.result.CompiledContract;
import com.yakindu.solidity.solc.result.GasEstimates;

@SuppressWarnings("restriction")
public class SolidityIssueCreator {

	private static final String INFO = "info";
	private static final String WARNING = "warning";
	private static final String ERROR = "error";
	final Pattern issueLength = Pattern.compile("\\^-*\\^");
	final Pattern issueContractNameLine = Pattern.compile("contract \\w*");

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	public void createErrors(final List<CompileError> errors, final Set<IResource> filesToCompile,
			EObject currentObject, ValidationMessageAcceptor acceptor) {
		if (errors == null) {
			return;
		}
		for (CompileError error : errors) {
			createSolcIssue(error, filesToCompile, currentObject, acceptor);
		}
	}

	public void createInfos(Map<String, Map<String, CompiledContract>> contracts, Set<IResource> filesToCompile,
			EObject currentObject, ValidationMessageAcceptor acceptor) {
		if (contracts == null) {
			return;
		}
		contracts.entrySet().stream().forEach(
				entry -> entry.getValue().entrySet().stream().forEach(contract -> createInfoIssue(contract.getValue(),
						findFileForName(filesToCompile, entry.getKey()), currentObject, acceptor)));
	}

	protected void createSolcIssue(CompileError error, Set<IResource> filesToCompile, EObject currentObject,
			ValidationMessageAcceptor acceptor) {
		String fileName = error.getSourceLocation().getFile();
		IFile errorFile = findFileForName(filesToCompile, fileName);
		int offset = error.getSourceLocation().getStart();
		String message = error.getMessage();
		EObject element = getEObject(errorFile, offset, currentObject);
		String severity = error.getSeverity();
		if (severity.equals(ERROR)) {
			acceptor.acceptError(message, element, null, offset, createErrorCodeFromMessage(severity, message));
		} else if (severity.equals(WARNING)) {
			acceptor.acceptWarning(message, element, null, offset, createErrorCodeFromMessage(severity, message));
		}
	}

	protected void createInfoIssue(CompiledContract contract, IFile file, EObject currentObject,
			ValidationMessageAcceptor acceptor) {
		if (contract.getEvm() == null || contract.getEvm().getGasEstimates() == null) {
			return;
		}
		GasEstimates gasEstimates = contract.getEvm().getGasEstimates();
		String message = prettyPrint(gasEstimates);
		EObject element = getEObject(file, 0, currentObject);
		acceptor.acceptInfo(message, element.eContainer(), 0, 0, createErrorCodeFromMessage(INFO, message));
	}

	protected IFile findFileForName(Set<IResource> filesToCompile, String fileName) {
		IFile errorFile = filesToCompile.stream().filter(file -> file.getName().equals(fileName))
				.map(file -> (IFile) file).findFirst().orElse((IFile) filesToCompile.stream().findFirst().orElse(null));
		return errorFile;
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

	protected boolean spansOverMultipleLines(String issueDetails) {
		return issueDetails.contains("Spanning multiple lines.")
				|| issueDetails.contains("spans across multiple lines");
	}

	protected int calculateIssueLength(String errorLine, String issueDetails) {
		if (spansOverMultipleLines(issueDetails)) {
			try {

				if (errorLine.contains("function")) {
					return errorLine.substring(errorLine.indexOf("function"), errorLine.indexOf(")") + 1).length();
				}
				if (errorLine.contains("constructor")) {
					return errorLine.substring(errorLine.indexOf("constructor"), errorLine.indexOf(")") + 1).length();
				}
				if (errorLine.contains("contract")) {
					return calculateIssueLength(issueDetails, this.issueContractNameLine);
				}
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			return calculateIssueLength(issueDetails, this.issueLength);
		}
		return 0;
	}

	protected int calculateIssueLength(String errorMessage, Pattern pattern) {
		Matcher matcher = pattern.matcher(errorMessage);
		if (matcher.find()) {
			return matcher.group(0).length();

		}
		return 0;
	}

	protected EObject getEObject(IFile errorFile, int offset, EObject currentObject) {
		Resource resource = currentObject.eResource();
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

	protected void printMethodEstimations(Map<String, String> map, StringBuilder builder) {
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				builder.append("\t\t" + entry.getKey() + ": " + entry.getValue() + "\n");
			}
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

	protected String createErrorCodeFromMessage(String severity, String message) {
		switch (severity) {
		case ERROR:
			return SolidityError.getCodeForMessage(message);
		case WARNING:
			return SolidityWarning.getCodeForMessage(message);
		default:
			return INFO;
		}
	}

}

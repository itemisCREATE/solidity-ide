package com.yakindu.solidity.ide.builder.processor;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
/**
 * @author Florian Antony - Initial contribution and API
 */
public class MarkerOutputProcessor implements SolcOutputProcessor {

	public final static String NORMAL_VALIDATION = "org.eclipse.xtext.ui.check.normal"; //$NON-NLS-1$
	private static final String LINE_BREAK = System.getProperty("line.separator");

	private final IFile file;

	private String issue;

	private ArrayList<SolcIssue> issues;

	private Resource resource;

	@Inject
	private MarkerCreator creator;
	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	public MarkerOutputProcessor(IFile file) {
		// FIXME !!!!!!
		Guice.createInjector().injectMembers(this);
		this.issues = Lists.newArrayList();
		this.file = file;
		this.issue = "";
		resource = new ResourceSetImpl().getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true),
				true);
	}

	@Override
	public void processLine(String line) {
		if (line.startsWith(fileLocation())) {
			if (!issue.isEmpty()) {
				String[] parts = issue.split(":");
				if (parts.length < 6) {
					return;
				}
				SolcIssue solcIssue = new SolcIssue(file, issue);
				EObject element = offsetHelper.resolveElementAt((XtextResource) resource, solcIssue.getOffset());
				solcIssue.setUriToProblem(EcoreUtil.getURI(element));
				issues.add(solcIssue);
				issue = "";
			}
			issue += line;
		} else {
			issue += (LINE_BREAK + line);
		}
	}
	// TODO Implement xtext Issue and use MarkerCreator
	protected void createMarker(SolcIssue issue) throws CoreException {
		creator.createMarker(issue, file, NORMAL_VALIDATION);
	}

	private String fileLocation() {
		return file.getLocation().toOSString();
	}

	@Override
	public void complete() {
		for (SolcIssue issue : issues) {
			try {
				createMarker(issue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

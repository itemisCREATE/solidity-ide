package com.yakindu.solidity.remix.plugin;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class RemixFileManager {

	// Get a list of names from a path.
	// Folder:
	// export interface Folder {
	// [path: string]: {
	// isDirectory: boolean
	// }
	// }
	public Map<String, Map<String, Object>> getFolder(String path) {
		System.out.println("getFolder('" + path + ")");
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource member = workspace.getRoot().findMember(path);
		if (member instanceof IFolder) {
			Map<String, Map<String, Object>> result = new HashMap<String, Map<String, Object>>();
			Map<String, Object> options = new HashMap<String, Object>();
			options.put("isDirectory", true);
			result.put(path, options);
			return result;
		}
		return null;
	}

	// Get the path of the current file selected.
	public String getCurrentFile() {
		System.out.println("getCurrentFile");
		// TODO: This works but relies heavily on the assumption that only one Workbench Window is available.
		IWorkbenchPart workbenchPart = PlatformUI.getWorkbench().getWorkbenchWindows()[0].getActivePage().getActivePart(); 
		IFile file = (IFile) workbenchPart.getSite().getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		IPath path = file.getFullPath();
		return path.toString();
	}

	// Get the content of a file.
	public String getFile(String filePath) {
		System.out.println("getFile('" + filePath + ")");
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource member = workspace.getRoot().findMember(filePath);
		String content = "";
		if (member instanceof IFile) {
			IFile file = (IFile) member;
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents(), file.getCharset()))) {
				String line = reader.readLine();
				while (line != null) {
					content += line;
					content += System.lineSeparator();
					line = reader.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	// Set the content of a file.
	public void setFile(String filePath, String content) {
		System.out.println("setFile('" + filePath + "', '..')");
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource member = workspace.getRoot().findMember(filePath);
		if (member instanceof IFile) {
			IFile file = (IFile) member;
			if (file.exists() && !file.isReadOnly()) {
		        InputStream source = new ByteArrayInputStream(content.getBytes());

		        try {
		            file.setContents(source, IResource.FORCE, new NullProgressMonitor());

		            source.close();
		        } catch (CoreException | IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}

	// Switch the current File to the new one
	public void switchFile(String filePath) {
		System.out.println("switchFile('" + filePath + "')");
		// TODO: This works but relies heavily on the assumption that only one Workbench Window is available.
		IWorkbenchPage page = PlatformUI.getWorkbench().getWorkbenchWindows()[0].getActivePage(); 
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource member = workspace.getRoot().findMember(filePath);
		if (member instanceof IFile) {			
			IFile file = (IFile) member;
			IEditorDescriptor desc = PlatformUI.getWorkbench().
					getEditorRegistry().getDefaultEditor(file.getName());
			try {
				page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}
}

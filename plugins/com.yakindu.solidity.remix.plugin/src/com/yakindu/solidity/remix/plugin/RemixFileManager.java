package com.yakindu.solidity.remix.plugin;

import java.util.Map;

public class RemixFileManager {

	// Get a list of names from a path.
	// Folder:
	// export interface Folder {
	// [path: string]: {
	// isDirectory: boolean
	// }
	// }
	public Map<String, String> getFolder(String path) {
		System.out.println("getFolder('" + path + ")");
		return null;
	}

	// Get the name of the current file selected.
	public String getCurrentFile() {
		System.out.println("getCurrentFile");
		return null;
	}

	// Get the content of a file.
	public String getFile(String fileName) {
		System.out.println("getFile('" + fileName + "')");
		return null;
	}

	// Set the content of a file.
	public void setFile(String fileName, String content) {
		System.out.println("setFile('" + fileName + "', '..')");
	}

	// Switch the current File to the new one
	public void switchFile(String fileName) {
		System.out.println("switchFile('" + fileName + "')");
	}
}

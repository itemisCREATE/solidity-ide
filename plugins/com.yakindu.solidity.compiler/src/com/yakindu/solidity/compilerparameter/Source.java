package com.yakindu.solidity.compilerparameter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.resources.IFile;

public class Source {

	String keccak256;
	String content ="";
	List<String> urls;

	public Source(IFile file) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(file.getContents(true), file.getCharset()));) {
			String line = reader.readLine();
			while (line != null) {
				content += line.trim();
				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getKeccak256() {
		return keccak256;
	}

	public void setKeccak256(String keccak256) {
		this.keccak256 = keccak256;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}

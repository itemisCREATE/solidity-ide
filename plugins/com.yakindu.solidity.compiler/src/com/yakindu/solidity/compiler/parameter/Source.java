/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.compiler.parameter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.internal.utils.FileUtil;
import org.eclipse.core.resources.IFile;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class Source {

	String keccak256;
	String content = "";
	List<String> urls;

	public Source(IFile file) {
		@SuppressWarnings("restriction")
		String seperator = FileUtil.getLineSeparator(file);
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(file.getContents(true), file.getCharset()));) {
			String line = reader.readLine();
			while (line != null) {
				content += line +seperator;
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

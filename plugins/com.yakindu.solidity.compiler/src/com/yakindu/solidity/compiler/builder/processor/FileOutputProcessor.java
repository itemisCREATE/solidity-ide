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
package com.yakindu.solidity.compiler.builder.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.yakindu.solidity.ui.preferences.SolidityPreferences;

/**
 * @author Florian Antony - Initial contribution and API
 */

public class FileOutputProcessor implements ISolcOutputProcessor {

	@Inject
	private IPreferenceStore preferences;

	private class OutputFile {

		private final File output;
		private String content = "";

		public OutputFile(String absolutFileName) {
			this.output = new File(absolutFileName);
		}

		public void addLine(String line) {
			if (content.isEmpty()) {
				content += line;
			} else {
				content += (System.getProperty("line.separator") + line);
			}
		}

		public void write() {
			if (output.exists()) {
				output.delete();
			}
			if (content.isEmpty()) {
				return;
			}
			try {
				output.getParentFile().mkdirs();
				if (output.createNewFile()) {
					try (FileWriter writer = new FileWriter(output)) {
						writer.write(content);
						writer.flush();
					} catch (IOException e) {
						throw e;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private CompileOutputType switchContext(String line, CompileOutputType old) {
		CompileOutputType outputType = CompileOutputType.getTypeForTrigger(line);
		if (outputType != null) {
			return outputType;
		}
		return old;
	}

	@Override
	public void processLineForFile(BufferedReader output, IFile file) throws IOException {
		String fileName = getOutputFileName(file);

		CompileOutputType outputType = null;
		Map<CompileOutputType, OutputFile> outputFiles = initializeOutputFiles(fileName);
		String line;
		line = output.readLine();
		while (line != null && !Thread.currentThread().isInterrupted()) {
			if (!line.isEmpty()) {
				outputType = switchContext(line, outputType);
				if (outputType != null) {
					outputFiles.get(outputType).addLine(line);
				}
			}
			line = output.readLine();
		}
		writeFiles(outputFiles);
	}

	private Map<CompileOutputType, OutputFile> initializeOutputFiles(String fileName) {
		Map<CompileOutputType, OutputFile> outputFiles = Maps.newHashMap();
		for (CompileOutputType type : CompileOutputType.values()) {
			outputFiles.put(type, new OutputFile(fileName + type.EXTENSION));
		}
		return outputFiles;
	}

	private void writeFiles(Map<CompileOutputType, OutputFile> outputFiles) {
		for (OutputFile outputFile : outputFiles.values()) {
			outputFile.write();
		}
	}

	private String getOutputFileName(IFile file) {
		String outputDirectory = file.getParent().getParent().getLocation().toOSString() + "\\"
				+ preferences.getString(SolidityPreferences.COMPILER_OUTPUT_PATH);
		String plainFileName = file.getName().replaceAll(".sol", "");
		String fileName = outputDirectory + "\\" + plainFileName;
		return fileName;
	}

}

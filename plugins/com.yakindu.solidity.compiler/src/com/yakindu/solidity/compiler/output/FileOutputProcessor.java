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
package com.yakindu.solidity.compiler.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.yakindu.solidity.compiler.preferences.ICompilerPreferences;
import com.yakindu.solidity.compiler.result.Abi;
import com.yakindu.solidity.compiler.result.Bytecode;
import com.yakindu.solidity.compiler.result.CompiledContract;
import com.yakindu.solidity.compiler.result.CompilerOutput;
import com.yakindu.solidity.compiler.result.EvmOutput;

/**
 * @author Florian Antony - Initial contribution and API
 */

public class FileOutputProcessor {

	@Inject
	private ICompilerPreferences prefs;
	private final GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

	public void writeOutputFiles(CompilerOutput compilerOutput, Set<IResource> filesToCompile) {

		for (Entry<String, Map<String, CompiledContract>> entry : compilerOutput.getContracts().entrySet()) {
			String outputFileName = getOutputFileName(findFileForName(filesToCompile, entry.getKey()));
			for (CompiledContract contract : entry.getValue().values()) {
				if (contract != null && prefs.isWriteABIFile())
					writeABIFile(outputFileName, contract.getAbi());

				EvmOutput evmOutput = contract.getEvm();
				if (evmOutput != null && prefs.isWriteBINFile())
					writeBINFile(outputFileName, evmOutput.getBytecode());
				if (evmOutput != null && prefs.isWriteASMFile())
					writeASMFile(outputFileName, evmOutput.getAssembly());
			}
		}
	}

	private String getOutputFileName(IFile file) {
		String plainFileName = file.getName().replaceAll(".sol", "");
		return file.getProject().getLocation().append(prefs.getCompilerOutputPath()).append(plainFileName).toOSString();
	}

	private void writeASMFile(String outputFileName, String assembly) {
		writeFile(outputFileName + CompileOutputType.ASM.extension(), assembly);
	}

	private void writeBINFile(String outputFileName, Bytecode bytecode) {
		writeFile(outputFileName + CompileOutputType.BIN.extension(), gsonBuilder.create().toJson(bytecode));
	}

//	private void writeASTFile(String outputFileName, String ast) {
//		writeFile(outputFileName + CompileOutputType.AST.extension(), ast);
//	}

	private void writeABIFile(String outputFileName, List<Abi> abi) {
		writeFile(outputFileName + CompileOutputType.ABI.extension(), gsonBuilder.create().toJson(abi));
	}

	private void writeFile(String outputFileName, String content) {
		if (content == null) {
			return;
		}
		File file = new File(outputFileName);
		if (file.exists()) {
			file.delete();
		}
		if (content == null || content.isEmpty()) {
			return;
		}
		try {
			file.getParentFile().mkdirs();
			if (file.createNewFile()) {
				try (FileWriter writer = new FileWriter(outputFileName)) {
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

	private IFile findFileForName(Set<IResource> filesToCompile, String fileName) {
		IFile errorFile = filesToCompile.stream().filter(file -> file.getName().equals(fileName))
				.map(file -> (IFile) file).findFirst().orElse(null);
		return errorFile;
	}
}

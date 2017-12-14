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
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.yakindu.solidity.compiler.result.Bytecode;
import com.yakindu.solidity.compiler.result.CompiledContract;
import com.yakindu.solidity.compiler.result.CompilerOutput;
import com.yakindu.solidity.compiler.result.Documentation;
import com.yakindu.solidity.compiler.result.EvmOutput;
import com.yakindu.solidity.compiler.result.GasEstimates;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class JsonOutputProcessor implements ISolcOutputProcessor {

	@Override
	public void processLineForFile(BufferedReader output, IFile file) throws IOException {
		GsonBuilder gson = new GsonBuilder();
		gson.registerTypeAdapter(CompiledContract.class, new JsonDeserializer<CompiledContract>() {

			@Override
			public CompiledContract deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				CompiledContract contract = new CompiledContract();
				for (Entry<String, JsonElement> elements : json.getAsJsonObject().entrySet()) {
					contract.setName(elements.getKey());
					JsonObject contractData = elements.getValue().getAsJsonObject();
					contract.setAbi(context.deserialize(contractData.get("abi"), List.class));
					contract.setDevdoc(context.deserialize(contractData.get("devdoc"), Documentation.class));
					contract.setEvm(context.deserialize(contractData.get("evm"), EvmOutput.class));
					contract.setUserdoc(context.deserialize(contractData.get("userdoc"), Documentation.class));
				}
				return contract;
			}
		});

		gson.registerTypeAdapter(EvmOutput.class, new JsonDeserializer<EvmOutput>() {

			@Override
			public EvmOutput deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				EvmOutput evm = new EvmOutput();
				JsonObject jsonEvm = json.getAsJsonObject();
				evm.setAssembly(jsonEvm.get("assembly").getAsString());
				evm.setBytecode(context.deserialize(jsonEvm.get("bytecode"), Bytecode.class));
				evm.setDeployedBytecode(context.deserialize(jsonEvm.get("deployedBytecode"), Bytecode.class));
				evm.setGasEstimates(context.deserialize(jsonEvm.get("gasEstimates"), GasEstimates.class));
				evm.setMethodIdentifiers(context.deserialize(jsonEvm.get("methodIdentifiers"), Map.class));
				return evm;
			}
		});
		CompilerOutput compilerOutput = gson.create().fromJson(output, CompilerOutput.class);
		System.out.println(compilerOutput);
	}

}

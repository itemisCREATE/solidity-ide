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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IResource;

import com.google.common.collect.Sets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.inject.Inject;
import com.yakindu.solidity.compiler.result.Bytecode;
import com.yakindu.solidity.compiler.result.CompiledContract;
import com.yakindu.solidity.compiler.result.CompiledSource;
import com.yakindu.solidity.compiler.result.CompilerOutput;
import com.yakindu.solidity.compiler.result.Documentation;
import com.yakindu.solidity.compiler.result.EvmOutput;
import com.yakindu.solidity.compiler.result.GasEstimates;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class OutputHandler {

	@Inject
	private SolidityMarkerCreator markerCreator;

	@Inject
	private FileOutputProcessor outputFileWriter;

	private final GsonBuilder gson;

	public OutputHandler() {
		gson = new GsonBuilder();
		registerTypeAdapters();

	}

	private void registerTypeAdapters() {

		gson.registerTypeAdapter(CompiledSource.class, new JsonDeserializer<CompiledSource>() {

			@Override
			public CompiledSource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				JsonObject object = json.getAsJsonObject();
				CompiledSource source = new CompiledSource();
				source.setAst(readObjectMemberAsString(object, "ast"));
				source.setId(object.get("id").getAsInt());
				return source;
			}
		});

		gson.registerTypeAdapter(CompiledContract.class, new JsonDeserializer<CompiledContract>() {

			@Override
			public CompiledContract deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				CompiledContract contract = new CompiledContract();
				for (Entry<String, JsonElement> contractEntry : readMembersAsSet(json)) {
					contract.setName(contractEntry.getKey());
					JsonObject contractData = contractEntry.getValue().getAsJsonObject();
					contract.setAbi(context.deserialize(contractData.get("abi"), List.class));
					contract.setDevdoc(context.deserialize(contractData.get("devdoc"), Documentation.class));
					contract.setEvm(context.deserialize(contractData.get("evm"), EvmOutput.class));
					JsonElement element = contractData.get("userdoc");
					contract.setUserdoc(context.deserialize(element, Documentation.class));
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
				evm.setAssembly(readStringMember(jsonEvm, "assembly"));
				evm.setBytecode(context.deserialize(jsonEvm.get("bytecode"), Bytecode.class));
				evm.setDeployedBytecode(context.deserialize(jsonEvm.get("deployedBytecode"), Bytecode.class));
				evm.setGasEstimates(context.deserialize(jsonEvm.get("gasEstimates"), GasEstimates.class));
				evm.setMethodIdentifiers(context.deserialize(jsonEvm.get("methodIdentifiers"), Map.class));
				return evm;
			}

		});
	}

	private Set<Entry<String, JsonElement>> readMembersAsSet(JsonElement json) {
		JsonObject object = json.getAsJsonObject();
		return (object == null) ? Sets.newHashSet() : object.entrySet();
	}

	private String readObjectMemberAsString(JsonObject object, String key) {
		JsonElement element = object.get(key);
		return (element == null) ? null : element.getAsJsonObject().toString();
	}

	private String readStringMember(JsonObject object, String key) {
		JsonElement element = object.get(key);
		return (element == null) ? null : element.getAsString();
	}

	public void handleOutput(final InputStream stream, final Set<IResource> filesToCompile) {
		try (final InputStreamReader output = new InputStreamReader(stream, "UTF-8")) {
			CompilerOutput compilerOutput = gson.create().fromJson(output, CompilerOutput.class);
			markerCreator.createMarkers(compilerOutput, filesToCompile);
			outputFileWriter.writeOutputFiles(compilerOutput, filesToCompile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

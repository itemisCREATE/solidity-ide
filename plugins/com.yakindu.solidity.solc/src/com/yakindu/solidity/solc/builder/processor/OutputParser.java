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
package com.yakindu.solidity.solc.builder.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.yakindu.solidity.solc.result.Bytecode;
import com.yakindu.solidity.solc.result.CompileError;
import com.yakindu.solidity.solc.result.CompiledContract;
import com.yakindu.solidity.solc.result.CompiledSource;
import com.yakindu.solidity.solc.result.CompilerOutput;
import com.yakindu.solidity.solc.result.EvmOutput;
import com.yakindu.solidity.solc.result.GasEstimates;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class OutputParser {

	private final GsonBuilder gson;

	public OutputParser() {
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

		gson.registerTypeAdapter(CompilerOutput.class, new JsonDeserializer<CompilerOutput>() {

			@Override
			public CompilerOutput deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				CompilerOutput output = new CompilerOutput();
				JsonObject outputJson = json.getAsJsonObject();
				output.setSources(context.deserialize(outputJson.get("sources"), Map.class));
			
				List<CompileError> errors = Lists.newArrayList();
				JsonArray jsonArray = outputJson.getAsJsonArray("errors");
				if(jsonArray != null) {
					for (JsonElement jsonElement : jsonArray) {
						errors.add(context.deserialize(jsonElement, CompileError.class));
					}
				}
				output.setErrors(errors);
				Set<Entry<String, JsonElement>> contractFiles = readMembersAsSet(outputJson.get("contracts"));
				Map<String, Map<String, CompiledContract>> transformedContracts = Maps.newHashMap();
				for (Entry<String, JsonElement> fileEntries : contractFiles) {
					Set<Entry<String, JsonElement>> contractEntries = readMembersAsSet(fileEntries.getValue());
					Map<String, CompiledContract> compiledContractMap = Maps.newHashMap();
					for (Entry<String, JsonElement> contractEntry : contractEntries) {
						compiledContractMap.put(contractEntry.getKey(),
								context.deserialize(contractEntry.getValue(), CompiledContract.class));
						
						transformedContracts.put(fileEntries.getKey(), compiledContractMap);
					} 
				}
				output.setContracts(transformedContracts);
				return output;
			}

		});
	}

	private Set<Entry<String, JsonElement>> readMembersAsSet(JsonElement json) {
		if(json != null) {
			JsonObject object = json.getAsJsonObject();
			return (object == null) ? Sets.newHashSet() : object.entrySet();
		}
		return Sets.newHashSet();
	}

	private String readObjectMemberAsString(JsonObject object, String key) {
		JsonElement element = object.get(key);
		return (element == null) ? null : element.getAsJsonObject().toString();
	}

	private String readStringMember(JsonObject object, String key) {
		JsonElement element = object.get(key);
		return (element == null) ? null : element.getAsString();
	}

	public Optional<CompilerOutput> parse(final InputStream stream, final Set<File> filesToCompile) {
		try (final InputStreamReader output = new InputStreamReader(stream, "UTF-8");
				final BufferedReader out = new BufferedReader(output);) {
			CompilerOutput compilerOutput = gson.create().fromJson(output, CompilerOutput.class);
			if (compilerOutput != null) {
				return Optional.of(compilerOutput);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}

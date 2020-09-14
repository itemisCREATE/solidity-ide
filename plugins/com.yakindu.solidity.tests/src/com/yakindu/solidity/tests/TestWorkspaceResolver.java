package com.yakindu.solidity.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.yakindu.solidity.IWorkspaceResourceResolver;

public class TestWorkspaceResolver implements IWorkspaceResourceResolver {

	Set<File> allFiles = computeFiles();
	Map<String, File> cache = new HashMap<String, File>();

	@Override
	public File resolve(Resource resource) {
		String uriPath = "";
		URI uri = resource.getURI();
		for (String segment : uri.segments()) {
			if(!uriPath.isEmpty()) {
				uriPath += "\\"+segment;
			}
			else {				
				if (segment.equals("..")) {
					uriPath+=segment;
				}
			}
		}
		File cacheResult = cache.get(uriPath);
		if (cacheResult != null) {
			return cacheResult;
		} else {
			for (File file : allFiles) {
				if (file.getPath().endsWith(uriPath)) {
					cache.put(uriPath, file);
					return file;
				}
			}
		}
//		Optional<File> matchingFile = allFiles.stream().filter(f -> f.getPath().endsWith(finalUriPath)).findFirst();
//		if (matchingFile.isPresent()) {
//			return matchingFile.get();
//		}
		return null;
	}

	public static Set<File> computeFiles() {
		Path baseDir = Paths.get("../../examples/com.yakindu.solidity.examples");
		Set<File> allFiles = new HashSet<File>();
		Set<Path> allFilesPaths;
		try {
			allFilesPaths = Files.walk(baseDir, new FileVisitOption[0]).filter(f -> f.toString().endsWith(".sol"))
					.collect(Collectors.toSet());
			for (Path filePath : allFilesPaths) {
				allFiles.add(filePath.toFile());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allFiles;
	}
}

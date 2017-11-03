package com.yakindu.solidity.ide.builder.processor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;

import com.google.common.collect.Maps;
/**
 * @author Florian Antony - Initial contribution and API
 */
public class FileOutputProcessor implements SolcOutputProcessor {

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
				// TODO
				System.out.println();
			}

		}
	}

	private final Map<CompileOutputType, OutputFile> outputFiles;

	private CompileOutputType outputType;

	public FileOutputProcessor(IFile file) {
		String outputDirectory = file.getParent().getParent().getLocation().toOSString() + "\\solidity-output\\";
		String plainFileName = file.getName().replaceAll(".sol", "");
		String fileName = outputDirectory + plainFileName + "\\" + plainFileName;
		this.outputFiles = Maps.newHashMap();
		for (CompileOutputType type : CompileOutputType.values()) {
			outputFiles.put(type, new OutputFile(fileName + type.EXTENSION));
		}
	}

	@Override
	public void processLine(String line) {
		if (!switchContext(line)) {
			outputFiles.get(outputType).addLine(line);
		}
	}

	private boolean switchContext(String line) {
		CompileOutputType outputType = CompileOutputType.getTypeForTrigger(line);
		if (outputType != null) {
			this.outputType = outputType;
			return true;
		}
		return false;
	}

	@Override
	public void complete() {
		for (OutputFile outputFile : outputFiles.values()) {
			outputFile.write();
		}
	}

}

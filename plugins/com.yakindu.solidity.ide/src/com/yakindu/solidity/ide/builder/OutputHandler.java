package com.yakindu.solidity.ide.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.resources.IFile;

import com.yakindu.solidity.ide.builder.processor.FileOutputProcessor;
import com.yakindu.solidity.ide.builder.processor.MarkerOutputProcessor;
import com.yakindu.solidity.ide.builder.processor.SolcOutputProcessor;
/**
 * @author Florian Antony - Initial contribution and API
 */
public class OutputHandler {

	private final IFile file;
	private final ExecutorService service;

	public OutputHandler(IFile file) {
		this.file = file;
		this.service = Executors.newFixedThreadPool(2);
	}

	public void shutdown() {
		service.shutdown();
	}

	public void handleError(final InputStream errorStream) {
		final SolcOutputProcessor markerProcessor = new MarkerOutputProcessor(file);
		processCompilerOutput(errorStream, markerProcessor);

	}

	public void handleOutput(InputStream inputStream) {
		final SolcOutputProcessor outputFileWriter = new FileOutputProcessor(file);
		processCompilerOutput(inputStream, outputFileWriter);

	}
	private void processCompilerOutput(final InputStream stream, final SolcOutputProcessor processor) {
		this.service.submit(new Runnable() {
			@Override
			public void run() {
				try (final BufferedReader output = new BufferedReader(new InputStreamReader(stream))) {
					String line;
					line = output.readLine();
					while (line != null && !Thread.currentThread().isInterrupted()) {
						if (!line.isEmpty()) {
							processor.processLine(line);
						}
						line = output.readLine();
					}
					processor.complete();
				} catch (IOException e) {
					// TODO logging
				}
			}
		});
	}
}

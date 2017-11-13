package com.yakindu.solidity.compiler.builder.processor;

import java.io.BufferedReader;
import java.io.IOException;

import org.eclipse.core.resources.IFile;

/**
 * @author Florian Antony - Initial contribution and API
 */
public interface ISolcOutputProcessor {

	public void processLineForFile(BufferedReader output, IFile file) throws IOException;

}

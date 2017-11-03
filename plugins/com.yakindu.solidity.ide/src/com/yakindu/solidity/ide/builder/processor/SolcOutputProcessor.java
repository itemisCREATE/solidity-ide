package com.yakindu.solidity.ide.builder.processor;

/**
 * @author Florian Antony - Initial contribution and API
 */
public interface SolcOutputProcessor {

	public void processLine(String line);

	public void complete();
}

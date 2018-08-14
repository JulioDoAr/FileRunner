package com.jdominguez.process.imp.example;

import java.io.File;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jdominguez.process.FileProcess;

/**
 * Example process that show a archive structure
 * @author jdominguez
 *
 */
public class ExampleProcess extends FileProcess {
	private static final Logger log = LogManager.getLogger();
	
	private final String SEPARATOR = "-";

	private int depth = 0;
	
	@Override
	public void preProcessDirectory(File file) {
		log.info(String.join("", Collections.nCopies(depth, SEPARATOR)) 
				+ " procesing Directory : " + file.getName());
		depth++;
	}
	@Override
	public void processFile(File file) {
		log.info(String.join("", Collections.nCopies(depth, SEPARATOR)) 
				+ " processing File : " + file.getName());
	}
	@Override
	public void postProcessDirectory(File file) {
		depth--;
	}
	@Override
	public void finallyProcess() {
	}

}

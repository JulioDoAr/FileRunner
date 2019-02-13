package com.jdominguez.process;

import java.io.File;

/**
 * Abstract class that represents a generic process.
 * @author jdominguez
 *
 */
public abstract class FileProcess {
	
	/**
	 * Generic constructor
	 */
	public FileProcess() {}
	
	/**
	 * Method that will be executed BEFORE start to process each directory
	 * @param file The file to process
	 */
	public void preProcessDirectory(File file) {}
	/**
	 * Method that will be executed for each file
	 * @param file The file to process
	 */
	public void processFile(File file) {}
	/**
	 * Method that will be executed AFTER start to process each directory
	 * @param file The file to process
	 */
	public void postProcessDirectory(File file) {}
	/**
	 * Method that will be executed to finalize the process
	 */
	public void finallyProcess() {}

}

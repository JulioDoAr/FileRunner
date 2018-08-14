package com.jdominguez.process;

import java.io.File;

/**
 * Abstract class that represents a generic process.
 * @author jdominguez
 *
 */
public abstract class FileProcess {
	
	/**
	 * List of archives that will be traveled
	 */
	protected String[] rootFiles = {};
	/**
	 * List of patterns that will be excluded
	 */
	protected String[] excludedFiles = {};
	/**
	 * Flag if it is recursive. </br>Default = false
	 */
	protected boolean recursive = false;
	
	/**
	 * Generic constructor
	 */
	public FileProcess() {}
	
	/**
	 * Method that will be executed BEFORE start to process each directory
	 * @param file The file to process
	 */
	public abstract void preProcessDirectory(File file);
	/**
	 * Method that will be executed for each file
	 * @param file The file to process
	 */
	public abstract void processFile(File file);
	/**
	 * Method that will be executed AFTER start to process each directory
	 * @param file The file to process
	 */
	public abstract void postProcessDirectory(File file);
	/**
	 * Method that will be executed to finalize the process
	 */
	public abstract void finallyProcess();

	public String[] getRootFiles() {
		return rootFiles;
	}
	public void setRootFiles(String[] rootFiles) {
		this.rootFiles = rootFiles;
	}
	public String[] getExcludedFiles() {
		return excludedFiles;
	}
	public void setExcludedFiles(String[] excludedFiles) {
		this.excludedFiles = excludedFiles;
	}
	public boolean isRecursive() {
		return recursive;
	}
	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}
}

package com.jdominguez.process;

public class FileProcessProperties {
	
	private String name;
	private String clazz;
	private String[] rootFiles;
	private String[] ignoredPatterns;
	private boolean recursive;
	
	public FileProcessProperties() {
		name = "";
		clazz = "";
		rootFiles = new String[0];
		ignoredPatterns = new String[0];
		recursive = false;
	}
	
	public String[] getIgnoredPatterns() {
		return ignoredPatterns;
	}
	public void setIgnoredPatterns(String[] blackList) {
		this.ignoredPatterns = blackList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String[] getRootFiles() {
		return rootFiles;
	}
	public void setRootFiles(String[] rootFiles) {
		this.rootFiles = rootFiles;
	}
	public boolean isRecursive() {
		return recursive;
	}
	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}
	
	
	
}

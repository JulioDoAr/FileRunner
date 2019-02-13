package com.jdominguez.configuration;

import java.io.File;
import java.net.URL;

public class Configuration {
	
	private static final String DEFAULT_FILE_NAME = "processes.json";
	private static final String CLASSPATH = "classpath:";

	private File configurationFile;
	
	public Configuration() {
		this.configurationFile = new File(this.getClass().getClassLoader().getResource(DEFAULT_FILE_NAME).getFile());
	}
	
	public Configuration(String url) {
		if(url.startsWith(CLASSPATH)) {
			url = url.replace(CLASSPATH, "");
			this.configurationFile = new File(this.getClass().getClassLoader().getResource(url).getFile());
		} else
			this.configurationFile = new File(url);
	}

	public File getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(File configurationFile) {
		this.configurationFile = configurationFile;
	}
	
	
}

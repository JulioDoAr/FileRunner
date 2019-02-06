package com.jdominguez.configuration;

import java.io.File;
import java.net.URL;

public class Configuration {

	private File configurationFile;
	
	public Configuration() {
		this.configurationFile = new File(this.getClass().getClassLoader().getResource("processes.json").getFile());
	}

	public File getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(File configurationFile) {
		this.configurationFile = configurationFile;
	}
	
	
}

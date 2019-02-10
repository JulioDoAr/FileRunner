package com.jdominguez.configuration;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void loadDefaultconfig() {
		Configuration conf = new Configuration();
		assert conf.getConfigurationFile().exists() : "File does not exist";
	}
	
	@Test
	public void loadExternalUserconfig() {
		Configuration conf = new Configuration("C:/Users/julio/Documents/workspaceSTS/FileRunner/src/test/resources/processes.json");
		assert conf.getConfigurationFile().exists() : "File does not exist";
	}

	@Test
	public void loadInternalUserconfig() {
		Configuration conf = new Configuration("classpath:internaluserconfig/processes.json");
		assert conf.getConfigurationFile().exists() : "File does not exist";
	}
}

package com.jdominguez.configuration;

import org.junit.Test;

public class ConfigurationTest {

	private static final String EXTERNAL_CONFIG = "C:/Users/Usuario/Entornos/workspace_sts/FileRunner/src/test/resources/processes.json";
	private static final String INTERNAL_CONFIG = "classpath:internaluserconfig/processes.json";
	
	@Test
	public void loadDefaultconfig() {
		Configuration conf = new Configuration();
		assert conf.getConfigurationFile().exists() : "File does not exist";
	}
	
	@Test
	public void loadExternalUserconfig() {
		Configuration conf = new Configuration(EXTERNAL_CONFIG);
		assert conf.getConfigurationFile().exists() : "File does not exist";
	}

	@Test
	public void loadInternalUserconfig() {
		Configuration conf = new Configuration(INTERNAL_CONFIG);
		assert conf.getConfigurationFile().exists() : "File does not exist";
	}
}

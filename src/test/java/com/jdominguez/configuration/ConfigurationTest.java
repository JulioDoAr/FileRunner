package com.jdominguez.configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class ConfigurationTest {

	@Test
	public void loadDefaultConfig() {
		Configuration c1 = new Configuration();
		File f1 = new File(c1.getConfigurationFile().toString());
		assert f1.exists();
	}
}

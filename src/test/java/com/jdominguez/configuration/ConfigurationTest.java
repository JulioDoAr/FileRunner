package com.jdominguez.configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationTest {

	public static void main(String[] args) {
		Configuration c1 = new Configuration();
		System.out.println(c1.getConfigurationFile());
		File f1 = new File(c1.getConfigurationFile().toString());
		System.out.println(f1.exists());
		
	}
}

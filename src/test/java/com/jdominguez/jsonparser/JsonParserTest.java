package com.jdominguez.jsonparser;

import java.io.IOException;

import com.jdominguez.configuration.Configuration;
import com.jdominguez.process.FileProcessProperties;

public class JsonParserTest {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		JsonParser parser = new JsonParser(conf);
		
		try {
			parser.loadProperties("proceso1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void testEscribir() {
		Configuration conf = new Configuration();
		JsonParser parser = new JsonParser(conf);
		
		FileProcessProperties[] properties = new FileProcessProperties[3];
		for (int i = 0; i < properties.length; i++) {
			FileProcessProperties prop = new FileProcessProperties();
			prop.setName("proceso1");
			prop.setClazz("");
			prop.setIgnoredPatterns(new String[] {"bl1", "bl2"});
			properties[i] = prop;
		}
		
		System.out.println("Escribiendo fichero " + conf.getConfigurationFile().getAbsolutePath() + " exist: " + conf.getConfigurationFile().exists());
		try {
			parser.saveProperties(properties);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

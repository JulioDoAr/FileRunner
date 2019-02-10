package com.jdominguez.jsonparser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdominguez.configuration.Configuration;
import com.jdominguez.process.FileProcessProperties;

/**
 * Resource manager
 * @author jdominguez
 */
public class JsonParser {

	private Configuration configuration;
	private ObjectMapper mapper;

	public JsonParser(Configuration configuration) {
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		this.configuration = configuration;
	}
	
	public FileProcessProperties loadProperties(String name) throws JsonParseException, JsonMappingException, IOException {
		FileProcessProperties selectedproperty = null;
		FileProcessProperties[] properties = mapper.readValue(configuration.getConfigurationFile(), FileProcessProperties[].class);
		for(FileProcessProperties property : properties)
			if(name.equals(property.getName())) 
				selectedproperty = property;
		return selectedproperty;
	}
	
	public void saveProperties(FileProcessProperties[] properties) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(configuration.getConfigurationFile(), properties);
	}
}

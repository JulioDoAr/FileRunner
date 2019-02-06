package com.jdominguez.jsonparser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdominguez.configuration.Configuration;
import com.jdominguez.process.FileProcessProperties;
import com.jdominguez.utils.StringUtils;

/**
 * Resource manager
 * @author jdominguez
 *
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
//	
//	/** 
//	 * Create a new instance of clazz from the json in the directory path ({@link JsonParser.DIRECTORY_PATH})
//	 * @param clazz Class type of the new instance
//	 * @return A new instance of the class from the resource
//	 * @throws IOException
//	 */
//	public <T> T toObject(Class<T> clazz) throws IOException {
//		URL url = getClass().getClassLoader().getResource(StringUtils.format(DIRECTORY_PATH, clazz.getSimpleName()));
//		return  mapper.readValue(url, clazz);
//	}
//	/**
//	 * Save an object in format JSON in the directory path ({@link JsonParser.DIRECTORY_PATH})
//	 * @param object Object to save as JSON
//	 * @throws IOException
//	 * @throws URISyntaxException
//	 */
//	public void toJson(Object object)  throws IOException, URISyntaxException {
//		URL url = getClass().getClassLoader().getResource(StringUtils.format(DIRECTORY_PATH, object.getClass().getSimpleName()));
//		
//		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(url.getFile()), object);
//	}
}

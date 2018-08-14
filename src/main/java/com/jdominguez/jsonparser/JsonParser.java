package com.jdominguez.jsonparser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdominguez.utils.StringUtils;

/**
 * Resource manager
 * @author jdominguez
 *
 */
public class JsonParser {
	final static Logger log = LogManager.getLogger(JsonParser.class);

	/** Resource directory where save the beans relative to the resource directory of the application. */
	public static String DIRECTORY_PATH = "json/{0}.json";
	
	private static JsonParser instance;
	private ObjectMapper mapper;

	private JsonParser() {
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	/** 
	 * Returns the instance of the parser. If not exist, create it.
	 * @return The instance of JsonParser
	 */
	public static JsonParser getInstance() {
		if(instance == null)
			instance = new JsonParser();
		return instance;
	}
	/** 
	 * Create a new instance of clazz from the json in the directory path ({@link JsonParser.DIRECTORY_PATH})
	 * @param clazz Class type of the new instance
	 * @return A new instance of the class from the resource
	 * @throws IOException
	 */
	public <T> T toObject(Class<T> clazz) throws IOException {
		URL url = getClass().getClassLoader().getResource(StringUtils.format(DIRECTORY_PATH, clazz.getSimpleName()));
		log.info("Loading resource from " + url.getFile());
		return  mapper.readValue(url, clazz);
	}
	/**
	 * Save an object in format JSON in the directory path ({@link JsonParser.DIRECTORY_PATH})
	 * @param object Object to save as JSON
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void toJson(Object object)  throws IOException, URISyntaxException {
		URL url = getClass().getClassLoader().getResource(StringUtils.format(DIRECTORY_PATH, object.getClass().getSimpleName()));
		log.info("Writing resource to " + url.getFile());
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(url.getFile()), object);
	}
}

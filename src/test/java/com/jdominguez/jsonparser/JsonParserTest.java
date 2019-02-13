package com.jdominguez.jsonparser;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jdominguez.configuration.Configuration;
import com.jdominguez.process.FileProcessProperties;

public class JsonParserTest {

	private static final String PROCESS_COMPLETE = "complete";
	private static final String PROCESS_DEFAULT = "defaultConfig";
	private static final String PROCESS_NON_EXIST = "procesoInexistente";

	Configuration conf;

	@Before
	public void before() {
		conf = new Configuration();
	}

	@Test
	public void loadProcess() throws JsonParseException, JsonMappingException, IOException {
		JsonParser parser = new JsonParser(conf);
		FileProcessProperties fpp = null;
		fpp = parser.loadProperties(PROCESS_COMPLETE);
		assert fpp != null : "Ha fallado la carga del proceso";
	}

	@Test
	public void loadNullIfProcessNotExist() throws JsonParseException, JsonMappingException, IOException {
		JsonParser parser = new JsonParser(conf);
		FileProcessProperties fpp = null;
		fpp = parser.loadProperties(PROCESS_NON_EXIST);
		assert fpp == null : "Ha cargado un proceso inexistente?";
	}

	@Test
	public void loadDefaultConfig() throws JsonParseException, JsonMappingException, IOException {
		JsonParser parser = new JsonParser(conf);
		FileProcessProperties fpp = null;
		fpp = parser.loadProperties(PROCESS_DEFAULT);
		if (fpp == null || fpp.getClazz() == null || fpp.getIgnoredPatterns() == null || fpp.getName() == null
				|| fpp.getRootFiles() == null)
			assert false : "Al cargar por defecto, algo va a null";
	}
}

package com.jdominguez.runner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.jdominguez.configuration.Configuration;
import com.jdominguez.jsonparser.JsonParser;
import com.jdominguez.process.FileProcess;
import com.jdominguez.process.FileProcessProperties;

/**
 * Executor of processes
 * @author jdominguez
 *
 */
public class FileRunnerExecutor {
	
	private static FileRunner fileRunner;

	/**
	 * Create a new instance of the process of the parameter and runs it
	 * @param type Type of process to execute
	 */
	public synchronized static void executeProcess(String name) {
		executeProcess(name, new Configuration());
	}

	public synchronized static void executeProcess(String name, Configuration conf) {
		waitProces();
		try {
			JsonParser parser = new JsonParser(conf);
			FileProcessProperties properties = parser.loadProperties(name);
			fileRunner = new FileRunner(properties);
			fileRunner.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Wait to finish the process if is executing any
	 */
	public static void waitProces() {
		if(fileRunner == null) 
			return;
		while(isWorking()){}
	}
	/**
	 * Return if exist any process and is working
	 * @return
	 */
	public static boolean isWorking() {
		if(fileRunner == null) 
			return false;
		return fileRunner.isAlive();
	}
}

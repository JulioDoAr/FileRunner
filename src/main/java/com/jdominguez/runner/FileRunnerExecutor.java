package com.jdominguez.runner;

import java.io.IOException;

import com.jdominguez.jsonparser.JsonParser;
import com.jdominguez.process.FileProcess;

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
	public synchronized static void executeProcess(Class<? extends FileProcess> type) {
		waitProces();
		try {
			fileRunner = new FileRunner(JsonParser.getInstance().toObject(type));
			fileRunner.start();
		} catch (IOException e) {
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

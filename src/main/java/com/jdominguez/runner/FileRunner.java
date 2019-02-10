package com.jdominguez.runner;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.jdominguez.configuration.Configuration;
import com.jdominguez.process.FileProcess;
import com.jdominguez.process.FileProcessProperties;
import com.jdominguez.utils.StringUtils;

/**
 * @author jdominguez
 */
public class FileRunner extends Thread{

	/**
	 * Process that will be executed for every archive
	 */
	private FileProcess process;
	private FileProcessProperties properties;

	/**
	 * Basic constructor
	 * @param process Process that will be executed
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public FileRunner(FileProcessProperties properties) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super();
		this.properties = properties;
		createProcessInstance();
	}
	
	private void createProcessInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<? extends FileProcess> clazz = (Class<? extends FileProcess>) Class.forName(properties.getClazz());
		this.process = clazz.getConstructor().newInstance();
	}

	@Override
	public void run() {
		super.run();
		for (String url : properties.getRootFiles()) {
			processURL(url);
		}
	}

	private void processURL(String url) {
		File mainFile = new File(url);
		if(mainFile.exists()){
			if(mainFile.isDirectory())
			for(File children : mainFile.listFiles())
				processArchive(children);
			else 
				processArchive(mainFile);
			process.finallyProcess();
		} else {
			System.out.println("The url " + url + " doesn't exist");
		}
	}
	private void processArchive(File file){
		if(isExcluded(file))
			return;

		if(file.isFile())
			processFile(file);
		 else
			processDirectory(file);
		
	}
	private void processDirectory(File parent){
		process.preProcessDirectory(parent);

		if(properties.isRecursive())
			if(parent.listFiles() != null) 
				for(File children : parent.listFiles())
					processArchive(children);

		process.postProcessDirectory(parent);
	}
	private void processFile(File file){
		process.processFile(file);
	}
	private boolean isExcluded(File file) {
		return StringUtils.inContained(file.getName(), properties.getIgnoredPatterns());
	}
}

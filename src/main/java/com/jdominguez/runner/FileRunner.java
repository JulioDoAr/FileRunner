package com.jdominguez.runner;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jdominguez.process.FileProcess;
import com.jdominguez.utils.StringUtils;

/**
 * @author jdominguez
 */
public class FileRunner extends Thread{
	final static Logger log = LogManager.getLogger(FileRunner.class);

	/**
	 * Process that will be executed for every archive
	 */
	private FileProcess process;

	/**
	 * Basic constructor
	 * @param process Process that will be executed
	 */
	public FileRunner(FileProcess process) {
		super();
		this.process = process;
	}

	@Override
	public void run() {
		super.run();
		for (String url : process.getRootFiles()) {
			processURL(url);
		}
	}

	private void processURL(String url) {
		File mainFile = new File(url);
		if(mainFile.exists()){
			processArchive(mainFile);
			process.finallyProcess();
		} else {
			log.error("The url " + url + " doesn't exist");
		}
	}
	private void processArchive(File file){
		if(isExcluded(file))
			return;

		if(file.isFile()){
			processFile(file);
		} else{
			processDirectory(file);
		}
	}
	private void processDirectory(File parent){
		process.preProcessDirectory(parent);

		if(!process.isRecursive())
			if(parent.listFiles() != null) 
				for(File children : parent.listFiles())
					processArchive(children);

		process.postProcessDirectory(parent);
	}
	private void processFile(File file){
		process.processFile(file);
	}
	private boolean isExcluded(File file) {
		return StringUtils.inContained(file.getName(), process.getExcludedFiles());
	}
}

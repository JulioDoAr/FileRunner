package e2e;

import java.io.File;
import java.util.Collections;

import com.jdominguez.process.FileProcess;

public class FileProcessExample extends FileProcess {
	
	private final String SEPARATOR = "-";

	private int depth = 0;
	
	@Override
	public void preProcessDirectory(File file) {
		System.out.println(String.join("", Collections.nCopies(depth, SEPARATOR)) 
				+ " procesing Directory : " + file.getName());
		depth++;
	}
	@Override
	public void processFile(File file) {
		System.out.println(String.join("", Collections.nCopies(depth, SEPARATOR)) 
				+ " processing File : " + file.getName());
	}
	@Override
	public void postProcessDirectory(File file) {
		depth--;
	}
	@Override
	public void finallyProcess() {
		System.out.println(" Proceso finalizado.");
	}

}

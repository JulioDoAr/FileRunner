package com.jdominguez.test.example;

import com.jdominguez.process.imp.example.ExampleProcess;
import com.jdominguez.runner.FileRunnerExecutor;

public class Test {

	public static void main(String[] args) {
		FileRunnerExecutor.executeProcess(ExampleProcess.class);
	}
}

package e2e;


import org.junit.Test;

import com.jdominguez.runner.FileRunnerExecutor;

public class Tests {
	
	@Test
	public void e2e_Full() {
		FileRunnerExecutor.executeProcess("proceso1");
	}

	@Test
	public void e2e_WithoutIgnoredPatterns() {
		FileRunnerExecutor.executeProcess("proceso2");
	}

	@Test
	public void e2e_WithIgnorePattern() {
		FileRunnerExecutor.executeProcess("proceso3");
	}

	@Test
	public void e2e_NameNotFound() {
		FileRunnerExecutor.executeProcess("nameNotFound");
	}
}

package e2e;


import org.junit.Test;

import com.jdominguez.runner.FileRunnerExecutor;

public class Tests {
	
	@Test
	public void e2e_Full() {
		FileRunnerExecutor.executeProcess("complete");
	}

	@Test
	public void e2e_WithoutIgnoredPatterns() {
		FileRunnerExecutor.executeProcess("withoutIgnoredRecursive");
	}

	@Test
	public void e2e_WithIgnorePattern() {
		FileRunnerExecutor.executeProcess("withIgnored");
	}

	@Test
	public void e2e_NameNotFound() {
		FileRunnerExecutor.executeProcess("withoutClass");
	}
}

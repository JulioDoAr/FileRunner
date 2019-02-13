# Example
```java
public class ExampleProcess extends FileProcess {
	
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
		System.out.println("Process finished.");
	}

}
```
```json
[ {
  "name" : "process1",
  "clazz" : "e2e.FileProcessExample",
  "rootFiles" : [ "/home", "C:/Program Files (x86)/Java", "C:/Program Files/Java" ],
  "ignoredPatterns" : [ ".jar" ],
  "recursive" : true
} ]
```
```java
public static void main(String[] args) {
	FileRunnerExecutor.executeProcess("process1");
}
```
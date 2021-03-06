# FileRunner
Java library that helps you to create a recursive processes around a directory hierarchy
1. [How to use](GUIDE.md)
2. [Example project](EXAMPLE.md)

# How to use
We will have to do 3 steps:
1. Create the "Process" class.
2. Create the configuration file.
3. Run our process.

### Creating our Process
We need to create a class that extends from ``com.jdominguez.process.FileProcess`` to consider it a "Process".
This class let you override 3 methods:

```java
/**
 * Method that will be executed BEFORE start to process each directory
 * @param file The file to process
 */
public void preProcessDirectory(File file) {}
/**
 * Method that will be executed for each file
 * @param file The file to process
 */
public void processFile(File file) {}
/**
 * Method that will be executed AFTER start to process each directory
 * @param file The file to process
 */
public void postProcessDirectory(File file) {}
/**
 * Method that will be executed to finalize the process
 */
public void finallyProcess() {}
```

### Create the configuration file
We need to create one configuration file where we will write our process configurations. The default path is one file named ``processes.json``. This file will contain the data of our processes:
1. **"name"** _Default: ```""```_ - The name of the process. We will find process by this key.
2. **"clazz"** _Default: ```""```_ - The class to instance. Must inherit from ``com.jdominguez.process.FileProcess``.
3. **"rootFile"** _Default: ```[]```_ - List of files to process.
4. **"ignoredPatterns"** _Default: ```[]```_ - List of plains string to not process.
5. **"recursive"** _Default: ```false```_ - Flag to indicate if is recursive or not.
```json
[ {
  "name" : "process1"
  "clazz" : "pkg.ExampleProcess",
}, {
  "name" : "process2",
  "clazz" : "pkg.OtherProcess",
  "rootFiles" : [ "/file/to/process/1", "file/to/other/process" ],
  "ignoredPatterns" : [ ".json" ],
  "recursive" : true
} ]
```

### Run our process
Once you have configured and created your process, you can execute it wherever you want writing this:
```java
	FileRunnerExecutor.executeProcess("process1");
```
This code will load the default configuration that is in our resource directory, in a file named "processes.json"

### Others configurations
We can change the configuration file dynamically creating a ``com.jdominguez.configuration.Configuration`` and calling the ``com.jdominguez.runner.FileRunnerExecutor`` with our personal configuration.

```java
Configuration configuration1 = new Configuration("classpath:internal/user/directory/myProcesses.json");
FileRunnerExecutor.executeProcess("myProcess", configuration1);
```
This loads a process from a directory that is in the resource directory of the project.

```java
Configuration configuration2 = new Configuration("absolute/path/to/myProcesses.json");
FileRunnerExecutor.executeProcess("myProcess", configuration2);
```
This loads a process by the absolute path of the configuration file.

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

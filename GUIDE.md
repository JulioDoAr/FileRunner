# How to use
We will have to do 4 steps:
1. Create the "Process" class.
2. Create the configuration file.
3. Run our process.

### Creating our Process
We need to create a class that extends from ``com.jdominguez.process.FileProcess`` to consider it a "Process".
This class let you override 4 methods:

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
1. Run `mvn clean package`
1. Upload `hpi` file that gets generated inside `target` folder to Jenkins. 
1. Create a freestyle project, and just add as post-build step "Test Foo Task"
1. Run Job

See error come up:

```
Performing...
ERROR: Step ‘Test Foo Task’ aborted due to exception: 
java.lang.ClassNotFoundException: nu.xom.Node
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at org.eclipse.jetty.webapp.WebAppClassLoader.loadClass(WebAppClassLoader.java:450)
	at org.eclipse.jetty.webapp.WebAppClassLoader.loadClass(WebAppClassLoader.java:403)
Caused: java.lang.NoClassDefFoundError: nu/xom/Node
	at Foo.perform(Foo.java:26)
	at hudson.tasks.BuildStepMonitor$1.perform(BuildStepMonitor.java:20)
	at hudson.model.AbstractBuild$AbstractBuildExecution.perform(AbstractBuild.java:735)
	at hudson.model.AbstractBuild$AbstractBuildExecution.performAllBuildSteps(AbstractBuild.java:676)
	at hudson.model.Build$BuildExecution.post2(Build.java:186)
	at hudson.model.AbstractBuild$AbstractBuildExecution.post(AbstractBuild.java:621)
	at hudson.model.Run.execute(Run.java:1760)
	at hudson.model.FreeStyleBuild.run(FreeStyleBuild.java:43)
	at hudson.model.ResourceController.execute(ResourceController.java:97)
	at hudson.model.Executor.run(Executor.java:405)
Finished: FAILURE
```

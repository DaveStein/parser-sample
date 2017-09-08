import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import jenkins.model.GlobalConfiguration;

import org.kohsuke.stapler.DataBoundConstructor;

public class Foo extends Recorder {
  @DataBoundConstructor
  public Foo() {
  }

  @Override
  public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
    listener.getLogger().println("Performing...");
    UsesPrivateJsonLib.perform(listener.getLogger(), GlobalConfiguration.all().get(Config.class).getRootElement());
    listener.getLogger().println("Performed");
    return true;
  }

  @Override
  public DescriptorImpl getDescriptor() {
      return (DescriptorImpl) super.getDescriptor();
  }

  public BuildStepMonitor getRequiredMonitorService() {
    return BuildStepMonitor.NONE;
  }


  @Extension
  public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {

    public DescriptorImpl() {
      load();
    }

    public boolean isApplicable(Class type) {
      return true;
    }

    @Override
    public String getDisplayName() {
      return "Test Foo Task";
    }

  }
}

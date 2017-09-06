import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.Descriptor;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import net.sf.json.xml.XMLSerializer;

public class Foo extends Recorder {
  @DataBoundConstructor
  public Foo() {
  }

  @Override
  public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
    listener.getLogger().println("Performing...");
    XMLSerializer ser = new XMLSerializer();
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

    @Override
    public boolean configure(StaplerRequest staplerRequest, JSONObject json) throws FormException {
      return true; // indicate that everything is good so far
    }
  }
}
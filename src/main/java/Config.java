
import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import org.kohsuke.stapler.DataBoundSetter;

@Extension
public class Config extends GlobalConfiguration {

    private String rootElement;

    public Config() {
        load();
    }

    public String getRootElement() {
        return rootElement;
    }

    @DataBoundSetter
    public void setRootElement(String rootElement) {
        this.rootElement = rootElement;
        save();
    }

}

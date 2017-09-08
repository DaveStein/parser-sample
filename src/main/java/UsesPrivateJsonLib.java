import java.io.PrintStream;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

class UsesPrivateJsonLib {

    static void perform(PrintStream ps, String rootElement) {
        XMLSerializer ser = new XMLSerializer();
        if (rootElement != null) {
            ser.setRootName(rootElement);
        }
        ps.println(ser.write(new JSONObject().accumulate("x", 1).accumulate("y", 2)));
    }

}

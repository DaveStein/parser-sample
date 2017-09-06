import java.io.PrintStream;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

class UsesPrivateJsonLib {

    static void perform(PrintStream ps) {
        XMLSerializer ser = new XMLSerializer();
        ps.println(ser.write(new JSONObject().accumulate("x", 1).accumulate("y", 2)));
    }

}

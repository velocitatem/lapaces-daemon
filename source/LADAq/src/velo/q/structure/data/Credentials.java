package velo.q.structure.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc

/**
 * The Class Credentials.
 */
public class Credentials {

    /**
     * The path.
     */
    public static String opensky, nasa, alphavantage, path;

    /**
     * The obj.
     */
    private static JSONObject obj;

    /**
     * The inited.
     */
    public static boolean inited = false;

    /**
     * Inits the.
     *
     * @return true, if successful
     */
    public static boolean init() {
        if (path == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            File f = new File(path);
            Scanner s = null;
            try {
                s = new Scanner(f);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while (s.hasNextLine()) {
                sb.append(s.nextLine() + "\n");
            }
            try {
                obj = (JSONObject) new JSONParser().parse(sb.toString());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            opensky = (String) obj.get("opensky");
            nasa = (String) obj.get("nasa");
            alphavantage = (String) obj.get("alphavantage");
            boolean pass = opensky != null && nasa != null && alphavantage != null;
            inited = pass;
            return pass;
        }
    }
}

package velo.ladaalpha.fields.internet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;


// TODO: Auto-generated Javadoc

/**
 * The Class HttpResponse.
 */
public class HttpResponse {

    /**
     * The body.
     */
    private String body;

    /**
     * The response code.
     */
    private int responseCode;

    /**
     * The headers.
     */
    private final HashMap<String, String> headers = new HashMap<String, String>();

    /**
     * Gets the json body.
     *
     * @return the json body
     */
    public JSONObject getJsonBody() {
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(this.body);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return object;
    }

    /**
     * Adds the header.
     *
     * @param name the name
     * @param val  the val
     */
    public void addHeader(String name, String val) {
        this.headers.put(name, val);
    }

    /**
     * Gets the headers.
     *
     * @return the headers
     */
    public HashMap<String, String> getHeaders() {
        return headers;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the response code.
     *
     * @return the response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code.
     *
     * @param responseCode the new response code
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "HttpResponse [body=" + body + ", responseCode=" + responseCode + ", headers=" + headers + "]";
    }


}

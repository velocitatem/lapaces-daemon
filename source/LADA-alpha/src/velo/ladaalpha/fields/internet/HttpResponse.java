package velo.ladaalpha.fields.internet;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class HttpResponse {
	private String body;
	private int responseCode;
	private HashMap<String, String> headers = new HashMap<String, String>();
	public JSONObject getJsonBody() {
		JSONParser parser = new JSONParser();
		JSONObject object = null;
		try {
			object = (JSONObject) parser.parse(this.body);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	public void addHeader(String name, String val) {
		this.headers.put(name, val);
	}
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	@Override
	public String toString() {
		return "HttpResponse [body=" + body + ", responseCode=" + responseCode + ", headers=" + headers + "]";
	}
	
	
}

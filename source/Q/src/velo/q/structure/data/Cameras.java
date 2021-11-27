package velo.q.structure.data;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;

public class Cameras extends Source{
	public Cameras() {
		super(name, data, corePath);
	}
	public static String name = "cameras";
	public static DataPoint[] data = {getCamerasFor()};
	public static String corePath = "https://searchapi.earthcam.com/search.php?term=";
	public static DataPoint getCamerasFor() {
		class camVec extends DataPoint {
			public camVec() {
				super("cameras", new String[] {"location"});				
			}
			@Override
			public Object fetch(Object[] p) {			
				String queryTerm = (String)p[0];
				String url = corePath+queryTerm;
				HttpResponse res = APIreq.GET(url);
				JSONArray array = (JSONArray) res.getJsonBody().get("item_data");
				ArrayList<String> links = new ArrayList<String>();
				for(int i = 0 ; i < array.size(); i += 1) {
					JSONObject obl = (JSONObject) array.get(i);
					String location = (String) obl.get("cam_location"), link = (String) obl.get("db_url");
					links.add(link);	
				}
				return links;
			}			
			@Override
			public String stringify(Object o ) { 
				ArrayList<String> links = (ArrayList<String>) o;
				String out = "";
				for(String l : links) out+=l+"\n"; 
				return out;
			}
		}
		return new camVec();
	}
}

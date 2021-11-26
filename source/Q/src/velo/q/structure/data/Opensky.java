package velo.q.structure.data;

import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.ladaalpha.fields.linguistics.IRSAtranslator;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;

public class Opensky extends Source {
	public Opensky() {
		super(name, data, corePath);
	}
	public static String name = "opensky";
	public static DataPoint[] data = {allaircraft(), arrivals()};
	public static String corePath = "https://danalves24com:openskyosint@opensky-network.org/api/";
	public static DataPoint allaircraft() {
		class ala extends DataPoint {
			public ala() {
				super("all-aircraft", new String[] {});
			}
			@Override
			public Object fetch(Object[] p) {
				HttpResponse res = APIreq.GET(corePath+"states/all");
				JSONArray arr = ((JSONArray)(res.getJsonBody().get("states")));
				return arr;
			}
			@Override
			public String stringify(Object o) {
				StringBuilder sb = new StringBuilder();
				return sb.toString();
			}
		}
		return new ala();
	}
	public static DataPoint arrivals() {
		class arrivals extends DataPoint {
			public arrivals() {
				super("arrivals", new String[] {"airport", "days-back", "days-forward"});
			}
			@Override
			public Object fetch(Object[] arr) {
				double back = Double.valueOf((String)arr[1]), forward = Double.valueOf((String) arr[2]);				
				if(back+forward>7) {
					return null;
				}
				long now = System.currentTimeMillis() / 1000;
				long start = (long) (now - (86400 * back)), end = (long) (now + (86400 * forward));						
				String airport = (String)arr[0];
				String query = corePath+"flights/arrival"+"?airport="+airport+"&begin="+start+"&end="+end;
				HttpResponse res = APIreq.GET(query);
				JSONArray ARR = null;
				try {
					ARR = (JSONArray) new JSONParser().parse(res.getBody());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ARR;
			}
			@Override
			public String stringify(Object o ) { 
				HttpResponse airlines = APIreq.GET("https://raw.githubusercontent.com/npow/airline-codes/master/airlines.json");
				JSONParser parser = new JSONParser();
				JSONArray airlineCodes = null; 
				try {
					airlineCodes = (JSONArray) parser.parse(airlines.getBody());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JSONArray array = (JSONArray) o;				
				StringBuilder sb = new StringBuilder();
				for(int i =0 ; i < array.size(); i+=1) {
					JSONObject sub = (JSONObject)array.get(i);
					long firstSeen = (long) sub.get("firstSeen") , lastSeen = (long) sub.get("lastSeen"), durRaw = lastSeen - firstSeen;
					String dep = (String) sub.get("estDepartureAirport"), arr = (String) sub.get("estArrivalAirport"), callsign = (String) sub.get("callsign"), icao = (String)sub.get("icao24"), icaoSubs = callsign.substring(0,3), airline = "";				
					dep += " ~ " +IRSAtranslator.convert(dep); arr += " ~ " +IRSAtranslator.convert(arr);callsign += " ~ " +IRSAtranslator.convert(callsign);					
					boolean found = false; for(int c = 0 ; !found && c < airlineCodes.size(); c += 1) {
						JSONObject ob = (JSONObject) airlineCodes.get(c);
						String icaoM = (String) ob.get("icao");
						if(icaoM.equals(icaoSubs)) { airline = (String) ob.get("name");found = true;}
					} Date d1 = new Date(firstSeen*1000), d2 = new Date(lastSeen*1000);
					String[] pcs = {"\tfirst seen:\t"+d1.toString(), "\tlast seen:\t"+d2.toString(), "\torigin:\t\t"+dep, "\tdestination:\t"+arr,"\tcallsign:\t"+callsign, "\ticao:\t\t"+icao,"\tairline:\t"+airline,"\tduration(h):\t"+(durRaw/3600.001)};
					String tmp = String.join("\n", pcs);
					sb.append(tmp+"\n\n");
				}
				return sb.toString();
			}
		}
		return new arrivals();
 	}
	
}

package velo.q.structure.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.linguistics.IRSAtranslator;
import velo.q.structure.data.Opensky;

class openskyTest {

	@Test
	public void allAricraft() {
		JSONArray aray = (JSONArray)Opensky.allaircraft().fetch(null);
		for(int i = 0; i < aray.size() && i <10; i+=1) {
			JSONArray subarr = (JSONArray)aray.get(i);
			System.out.println(subarr.get(2) + " \t \t " + subarr.get(9));
		}
		
	}
	
	@Test
	public void arrivals() {
		JSONArray array = (JSONArray) Opensky.arrivals().fetch(new Object[] {"LKPR", "1.0", "2.0"});
		
		for(int i = 0; i < array.size() && i <10; i+=1) {		
			JSONObject obj = (JSONObject)array.get(i);
			String callsign = IRSAtranslator.convert((String) obj.get("callsign")), code = IRSAtranslator.convert((String)obj.get("icao24")), dest = IRSAtranslator.convert((String)obj.get("estDepartureAirport"));
			callsign = callsign==null?null:callsign.toLowerCase();
			dest = dest==null?null:dest.toUpperCase();
			System.out.println(callsign + "\t\t arriving from \t\t" + dest); 
			
			
		}
	}
}

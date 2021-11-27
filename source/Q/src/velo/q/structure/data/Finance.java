package velo.q.structure.data;

import org.json.simple.JSONObject;

import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;

public class Finance extends Source {
	public Finance() {
		super("finance", new DataPoint[] {forex()}, corePath);
	}
	private static String corePath = "https://www.alphavantage.co/", key = "202ED4BWPD8J55R5";
	
	public static DataPoint forex() {
		class forex extends DataPoint {

			public forex() {
				super("forex", new String[] {"source", "target"});
			}
			@Override
			public Object fetch(Object[] p) {
				String src = (String) p[0], target = (String)p[1];
				String path = "query?function=CURRENCY_EXCHANGE_RATE&from_currency="+src+"&to_currency="+target+"&apikey="+key;
				HttpResponse res = APIreq.GET(corePath+path);				
				return res.getJsonBody();
			}
			@Override
			public String stringify(Object o) {
				JSONObject e = (JSONObject) o;
				e = (JSONObject) e.get("Realtime Currency Exchange Rate");
				String from = (String) e.get("1. From_Currency Code"), to = (String) e.get("3. To_Currency Code"), rate = (String)e.get("5. Exchange Rate"), refresh = (String)e.get("6. Last Refreshed");;
				return "\t"+from+" ==> "+to + " = "+rate+" @ "+refresh+"UTC";
			}
			
		}
		return new forex();
 	}

}

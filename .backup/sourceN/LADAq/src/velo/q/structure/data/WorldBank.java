package velo.q.structure.data;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.ladaalpha.fields.linguistics.IRSAtranslator;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;

// TODO: Auto-generated Javadoc
class IndicatorResult {
	public HashMap<String, Double> data;
	public String name, note, org, country;

	public IndicatorResult(HashMap<String, Double> data, String name, String note, String org, String country) {
		super();
		this.data = data;
		this.country = country;
		this.name = name;
		this.note = note;
		this.org = org;
	}

}

/**
 * The Class WorldBank.
 */
public class WorldBank extends Source {
	
	/**
	 * Instantiates a new world bank.
	 */
	public WorldBank() {
		super("world-bank", new DataPoint[] { countries(), indicator(), findIndicator() }, corePath);
	}

	/** The core path. */
	private static String corePath = "http://api.worldbank.org/v2/";

	/**
	 * Indicator.
	 *
	 * @return the data point
	 */
	public static DataPoint indicator() {
		class indicator extends DataPoint {
			public indicator() {
				super("wb-indicator", new String[] { "indicator", "country", "start-year" });
			}

			@Override
			public Object fetch(Object[] p) {
				String country = (String) p[1], code = (String) p[0], start = p.length < 3 ? null : (String) p[2];
				String indicatorData = "https://api.worldbank.org/v2/indicator/" + code + "?format=json";
				HttpResponse indicatorRes = APIreq.GET(indicatorData);
				JSONObject indicator = null;
				try {
					indicator = (JSONObject) ((JSONArray) ((JSONArray) new JSONParser().parse(indicatorRes.getBody()))
							.get(1)).get(0);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String id = (String) ((JSONObject) indicator.get("source")).get("id");
				int idVal = Integer.valueOf(id);
				String name = (String) indicator.get("name"), note = (String) indicator.get("sourceNote"),
						org = (String) indicator.get("sourceOrganization");
				String path = "https://api.worldbank.org/v2/sources/" + idVal + "/country/" + country + "/series/"
						+ code + "/data?format=jsonstat";
				HttpResponse res = APIreq.GET(path);
				if (res.getJsonBody() == null)
					return -2;
				String prim = (String) res.getJsonBody().keySet().iterator().next();
				JSONObject data = (JSONObject) res.getJsonBody().get(prim);
				JSONObject l = data;
				String[] g = { "dimension", "time", "category", "label" };
				for (String w : g) {
					l = (JSONObject) l.get(w);
				}
				Object[] set = l.keySet().toArray();
				Arrays.sort(set);
				String b = (String) set[0], e = (String) set[set.length - 1];
				Integer bi = Integer.valueOf((String) l.get(b)), ei = Integer.valueOf((String) l.get(e));
				bi = start == null ? bi : Integer.valueOf(start);
				JSONArray dims = ((JSONArray) ((JSONObject) data.get("dimension")).get("size"));
				HashMap<String, Double> r = new HashMap<String, Double>();
				for (int f = bi; f < ei; f += 1) {
					try {
						path = "https://api.worldbank.org/v2/sources/" + idVal + "/country/" + country + "/series/"
								+ code + "/time/yr" + f + "/data?format=jsonstat";
						res = APIreq.GET(path);
						data = (JSONObject) res.getJsonBody().get(prim);
						JSONArray array = (JSONArray) data.get("value");
						double sum = 0;
						int it = 0;
						for (Object t : array) {
							sum += t == null ? 0 : Double.valueOf("" + t);
							it += t == null ? 0 : 1;
						}
						double avg = sum / it;
						if (!Double.isNaN(avg)) {
							r.put("" + f, avg);
						}
					} catch (Exception e5) {
					}
				}
				return new IndicatorResult(r, name, note, org, country);
			}

			@Override
			public String stringify(Object o) {
				try {
					int code = ((Integer) o);
					switch (code) {
					case -2:
						return "\tErr: country not found or not supported";
					}
				} catch (Exception e) {
				}
				IndicatorResult res = (IndicatorResult) o;
				HashMap<String, Double> data = res.data;
				TreeMap<String, Double> sorted = new TreeMap<>(data);
				StringBuilder sb = new StringBuilder();
				sb.append("\tLOC:\t" + res.country + "\n\tNAME:\t" + res.name + "\n" + "\tABOUT:\t" + res.note + "\n"
						+ "\tFROM:\t" + res.org + "\n\n");
				DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
				DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
				symbols.setGroupingSeparator(',');
				formatter.setDecimalFormatSymbols(symbols);
				for (Map.Entry<String, Double> e : sorted.entrySet()) {
					String key = e.getKey();
					Double y = e.getValue();
					sb.append("\t\t" + key + "\t=\t" + formatter.format(y) + "\n");
				}
				return sb.toString();
			}
		}
		return new indicator();
	}

	/**
	 * Countries.
	 *
	 * @return the data point
	 */
	public static DataPoint countries() {
		class countries extends DataPoint {
			public countries() {
				super("country", new String[] { "query" });
			}

			@Override
			public Object fetch(Object[] p) {
				ArrayList<String> comp = new ArrayList<String>();
				for (Object o : p) {
					comp.add((String) o);
				}
				String country = String.join(" ", comp);
				HttpResponse res = APIreq.GET(corePath + "country?format=json&per_page=299");
				JSONObject countryRes = null;
				JSONArray arr = null;
				try {
					arr = (JSONArray) new JSONParser().parse(res.getBody());
					arr = (JSONArray) arr.get(1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Object c : arr) {
					JSONObject o = (JSONObject) c;
					String name = (String) o.get("name");
					List<String> nameSplit = Arrays.asList(name.split(" "));
					if (name.equals(country) || name.contains(comp.get(0))) {
						countryRes = o;
					}
				}
				return countryRes;
			}

			@Override
			public String stringify(Object o) {
				StringBuilder sb = new StringBuilder();
				JSONObject c = (JSONObject) o;
				JSONObject regionO = (JSONObject) c.get("region"), incomeO = (JSONObject) c.get("incomeLevel");
				String name = (String) c.get("name"), iso2code = (String) c.get("iso2Code"),
						region = (String) regionO.get("value"), income = (String) incomeO.get("value"),
						capital = (String) c.get("capitalCity"), lat = (String) c.get("latitude"),
						lon = (String) c.get("longitude"), id = (String) c.get("id");
				String[][] guide = {
						{ "Name",
								name + " (ISO2|" + iso2code + " - [" + IRSAtranslator.convert(iso2code)
										+ "]) (ISO-3166|" + id + " - [" + IRSAtranslator.convert(id) + "])" },
						{ "Region", region }, { "Income", income }, { "Capital", capital },
						{ "Location", "LATITUDE|" + lat + "\t:\t" + "LONGITUDE|" + lon } };
				for (String[] ar : guide) {
					sb.append("\t" + ar[0] + ":  " + ar[1] + "\n");
				}
				return sb.toString();
			}
		}
		return new countries();
	}

	/**
	 * Find indicator.
	 *
	 * @return the data point
	 */
	public static DataPoint findIndicator() {
		class findIndicator extends DataPoint {
			public findIndicator() {
				super("wb-find-indicator", new String[] { "query" });
			}

			@Override
			public Object fetch(Object[] p) {
				ArrayList<String> qS = new ArrayList<String>();
				for (Object o : p)
					qS.add((String) o);
				int pp = 200;
				String intel = "https://api.worldbank.org/v2/indicator?format=json&per_page=" + pp,
						query = String.join(" ", qS);
				HttpResponse res = APIreq.GET(intel);
				JSONObject abt = null;
				try {
					abt = (JSONObject) ((JSONArray) new JSONParser().parse(res.getBody())).get(0);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int pages = Math.toIntExact((long) abt.get("pages"));
				ArrayList<JSONObject> matches = new ArrayList<JSONObject>();
				for (int i = 1; i <= pages; i++) {
					String pathL = "https://api.worldbank.org/v2/indicator?format=json&per_page=" + pp + "&page=" + i;
					HttpResponse l = APIreq.GET(pathL);
					JSONArray list = null;
					try {
						list = (JSONArray) ((JSONArray) new JSONParser().parse(l.getBody())).get(1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Object o : list) {
						JSONObject item = (JSONObject) o;
						String name = (String) item.get("name");
						if (name.contains(query)) {
							matches.add(item);
						}
					}
				}
				return matches;
			}

			@Override
			public String stringify(Object o) {
				ArrayList<JSONObject> data = (ArrayList<JSONObject>) o;
				StringBuilder sb = new StringBuilder();
				for (JSONObject ob : data) {
					String a = (String) ob.get("name");
					int al = a.length();
					sb.append("\t" + ob.get("id") + (((String) ob.get("id")).length() < 15 ? "\t" : "") + "\t\t:\t" + a
							+ "\n");
				}
				return sb.toString();
			}
		}
		return new findIndicator();
	}
}

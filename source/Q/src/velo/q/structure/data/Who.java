package velo.q.structure.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.ladaalpha.fields.math.LMath;
import velo.ladaalpha.misc.Plot;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;

// TODO: Auto-generated Javadoc
class WhoIndicatorReport {
	public String code, name, loc;
	public JSONArray data;

	public WhoIndicatorReport(String code, String name, String loc, JSONArray data) {
		super();
		this.loc = loc;
		this.code = code;
		this.name = name;
		this.data = data;
	}

}

/**
 * The Class Who.
 */
public class Who extends Source {
	
	/**
	 * Instantiates a new who.
	 */
	public Who() {
		super("WHO", new DataPoint[] { indicator() }, corePath);
	}

	/** The core path. */
	public static String corePath = "https://ghoapi.azureedge.net/";

	/**
	 * Indicator.
	 *
	 * @return the data point
	 */
	public static DataPoint indicator() {
		class indicator extends DataPoint {
			public indicator() {
				super("who-indicator", new String[] { "indicator", "country" });
			}

			@Override
			public Object fetch(Object[] p) {
				String code = null, name = null, indicator = (String) p[0], country = p.length<2?null: (((String) p[1]).equals("|")?null:((String)p[1])),
						abtPath = corePath + "/api/indicator/" + indicator;
				HttpResponse r1 = APIreq.GET(abtPath);
				JSONObject abt = r1.getJsonBody();
				code = (String) abt.get("IndicatorCode");
				name = (String) abt.get("IndicatorName");
				String path = corePath + "api/" + indicator + (country==null?"":"?$filter=SpatialDim%20eq%20%27" + country + "%27");
				System.out.println(path);
				HttpResponse res = APIreq.GET(path);
				JSONArray o = (JSONArray) res.getJsonBody().get("value");
				return new WhoIndicatorReport(code, name, country, o);
			}

			private Double[][] parseData(JSONArray array) {
				
				HashMap<Double, ArrayList<Double>> map = new HashMap<Double, ArrayList<Double>>();
				ArrayList<Double> years = new ArrayList<Double>();
				for(Object o : array) {
					JSONObject ob = (JSONObject)o;
					Double year = 1.0*(long) ob.get("TimeDim");
					boolean exists = false; int exI = 0, i =0;
					for(Double k : map.keySet()) {
						if(year.equals(k)) {
							exists = true;
							exI = i;
						}
						i+=1;
					}
					String stringVal = (String) ob.get("Value");
					if(stringVal.contains(" ")) {
						stringVal = stringVal.split(" ")[0];
						stringVal = stringVal.contains(".")?stringVal:""+(Integer.valueOf(stringVal)*1.0);
						System.out.println(stringVal);
					}
					Double val = Double.valueOf(stringVal);
					if(exists) {
						map.get(year).add(val);
					}
					else {
						ArrayList<Double> vi = new ArrayList<Double>();
						vi.add(val);
						map.put(year, vi);
						years.add(year);
					}
				}
				Object[] oa = years.toArray();			
				Double[] yearsA = new Double[oa.length];
				int s = 0;
				for(Object fg : oa) {
					yearsA[s] = (Double)fg;
					s+=1;
				}
				Arrays.sort(yearsA);
				Double[] means = new Double[yearsA.length];
				years = new ArrayList<Double>(Arrays.asList(yearsA));
				for(Double yy : map.keySet()) {
					ArrayList<Double> data = map.get(yy); Double sum = 0.0, mean;
					for(Double d : data) {
						sum+=d;
					}
					mean = sum / data.size();
					int index = years.indexOf(yy);
					means[index] = mean;
				}
				System.out.println(Arrays.toString(yearsA));
				System.out.println(Arrays.toString(means));
				return new Double[][] {yearsA, means};
			}
			@Override
			public String stringify(Object l) {
				WhoIndicatorReport rep = (WhoIndicatorReport) l;
				JSONArray array = rep.data;
				StringBuilder sb = new StringBuilder();
				sb.append("\tLOC:\t" + rep.loc + "\n");
				sb.append("\tCODE:\t" + rep.code + "\n");
				sb.append("\tNAME:\t" + rep.name + "\n\n");
				Double[][] mat = parseData(array);
				int s = mat[0].length;
				for(int i = 0; i < s; i ++) {
					sb.append("\t\t"+mat[0][i]+"\t:\t"+mat[1][i]+"\n");
				}
				return sb.toString();
			}

			@Override
			public void plot(Object o) {

				WhoIndicatorReport rep = (WhoIndicatorReport) o;
				JSONArray array = rep.data;
				Double[][] mat = parseData(array);
				List<Double> x = Arrays.asList(mat[0]), y = Arrays.asList(mat[1]);
				Double sum = 0.0;
				for(Double j : y) {
					sum+=j;
				}
				int s = x.size();
				for(int i = 0 ; i < s; i+=1) {
					x.set(i, x.get(i)-2000);
					y.set(i, y.get(i)/sum);
				};
				Plot plot = Plot.plot(Plot.plotOpts().title(rep.name).legend(Plot.LegendFormat.BOTTOM))
						.xAxis("Year - 2000", null).yAxis("Normalized Values", null)
						.series(null, Plot.data().xy(x, y), null);
				String sf = System.currentTimeMillis() + "";
				try {
					plot.save(sf, "png");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Desktop.getDesktop().open(new File(sf + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new indicator();
	}
}

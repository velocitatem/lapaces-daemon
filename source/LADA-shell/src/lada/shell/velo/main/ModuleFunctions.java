package lada.shell.velo.main;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;

import velo.ladaalpha.fields.astronomy.navigation.Moment;
import velo.ladaalpha.fields.cryptography.Hashing;
import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.ladaalpha.fields.internet.Internet;
import velo.ladaalpha.fields.internet.Target;
import velo.ladaalpha.fields.linguistics.IRSAtranslator;
import velo.ladaalpha.fields.linguistics.LinguisticParser;
import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.LMath;
import velo.ladaalpha.fields.math.LinearFunction;
import velo.ladaalpha.fields.math.calculus.Limits;
import velo.ladaalpha.fields.math.calculus.NumericalDifferentiation;
import velo.ladaalpha.fields.math.calculus.NumericalIntegration;
import velo.ladaalpha.fields.math.calculus.TaylorSeries;
import velo.ladaalpha.fields.math.operations.SystemOfLinearFunctions;
import velo.ladaalpha.fields.math.stats.DistributionDirections;
import velo.ladaalpha.fields.math.stats.Distributions;
import velo.ladaalpha.fields.math.stats.OneVarStats;
import velo.ladaalpha.fields.math.stats.Probability;
import velo.ladaalpha.fields.math.stats.Regression;
import velo.ladaalpha.fields.math.stats.Scores;
import velo.ladaalpha.fields.physics.ComplexVector;
import velo.ladaalpha.fields.physics.kinematics.Kinematics;
import velo.ladaalpha.misc.SortingAlgorithms;

public class ModuleFunctions {
	public static Function averageSpeed() {
		class f extends Function {
			f() {
				super("average-speed", new String[] {"distance", "time"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return Kinematics.averageSpeed((double)params[0], (double)params[1]);				
			}
		}
		return new f();
	}
	public static Function deltaT() {
		class f extends Function {
			f() {
				super("deltaX", new String[] {"v0", "v", "t"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return Kinematics.DeltaX((double)params[0], (double)params[1], (double)params[2]);				
			}
		}
		return new f();
	}
	public static Function limit() {
		class f extends Function {
			f() {
				super("limit", new String[] {"equation", "x"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return Limits.limit(new Equation().equationFromString((String)params[0]), (double)params[1]);				
			}
		}
		return new f();
	}
	public static Function numericalDifferentiation() {
		class f extends Function {
			f() {
				super("differentiation", new String[] {"equation", "x", "order"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return NumericalDifferentiation.differentiate(new Equation().equationFromString((String)params[0]), (double)params[1], (int)(double)params[2]);				
			}
		}
		return new f();
	}
	public static Function tangentLine() {
		class f extends Function {
			f() {
				super("tangen-line", new String[] {"equation", "x"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return NumericalDifferentiation.tangentLine(new Equation().equationFromString((String)params[0]), (double)params[1]);				
			}
			@Override
			public String stringify(Object o) {
				LinearFunction lf = (LinearFunction)o;
				return lf.toString();
			}
		}
		return new f();
	}
	public static Function taylorSeries() {
		class f extends Function {
			f() {
				super("taylor-series", new String[] {"equation", "x"});
			}
			
			@Override
			public Object evaluate(Object[] params) {
				return TaylorSeries.computeCenteredAt(new Equation().equationFromString((String)params[0]), (double)params[1]);				
			}
			@Override
			public String stringify(Object o) {
				return ((Equation)o).toString();
			}
			
		}
		return new f();
	}
	public static Function sysLin() {
		class f extends Function {
			f() {
				super("linear-system-solution", new String[] {"m1", "b1", "m2", "b2"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return new SystemOfLinearFunctions(new LinearFunction((double)params[0], (double)params[1]), new LinearFunction((double)params[2], (double)params[3])).solution();						
			}
			@Override
			public String stringify(Object o) {
				return Arrays.toString((double[])o);
			}
		}
		return new f();
	}
	public static Function complexVectorMagnitude() {
		class f extends Function {
			f() {
				super("complex-vector-magnitude", new String[] {"ax", "ay"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return new ComplexVector((double)params[0], (double)params[1]).getMagnitude();
			}
		}
		return new f();
	}
	public static Function complexVectorThetaDegrees() {
		class f extends Function {
			f() {
				super("complex-vector-theta-degrees", new String[] {"ax", "ay"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return new ComplexVector((double)params[0], (double)params[1]).ThetaDegrees();
			}
		}
		return new f();
	}
	public static Function complexVectorfromParams() {
		class f extends Function {
			f() {
				super("complex-vector-from-theta-and-magnitude", new String[] {"theta", "magnitude"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return ComplexVector.vectorGivenThetaAndMagnitude((double)params[0], (double)params[1]);
			}
			@Override
			public Object stringify(Object o) {
				return ((ComplexVector)o).toString();
			}
		}
		return new f();
	}
	public static Function factorial() {
		class f extends Function {
			f() {
				super("factorial", new String[] {"a"});
			}
			@Override
			public Object evaluate(Object[] params) {
				return LMath.factorial((double)params[0]);
			}
		}
		return new f();
	}
	public static Function julianDay() {
		class f extends Function {
			f() {
				super("get-current-julian-day", new String[] {});
			}
			@Override
			public Object evaluate(Object[] params) {
				LocalDateTime now = LocalDateTime.now();
				int year = now.getYear();
				int month = now.getMonthValue();
				int day =  now.getDayOfMonth();
				int hour = now.getHour();
				int minute = now.getMinute();
				int second = now.getSecond();
				int millis = now.get(ChronoField.MILLI_OF_SECOND);
				return new Moment(year, month, day, hour, minute, second, millis).getJulianDay();
			}
		}
		return new f();
	}
	public static Function julianDay1() {
		class f extends Function {
			f() {
				super("get-custom-julian-day", new String[] {"year","month","day","hour","minute","second","millis"});
			}
			@Override
			public Object evaluate(Object[] params) {
				for(int i = 0; i < params.length ; i += 1 ) {
					if(params[i] != null) {
						Double val = (double)params[i];
						params[i] = val.intValue();
					}
				}
				return new Moment((int)params[0], (int)params[1], (int)params[2], (int)params[3], (int)params[4], (int)params[5], (int)params[6]).getJulianDay();
			}
		}
		return new f();
	}
	public static Function hashFunctions() {
		class f extends Function {
			f() {
				super("hashing", new String[] {"type", "body"});
			}
			@Override
			public Object evaluate(Object[] params) {
				String input = (String)params[1];
				// awful, i know
				switch((String)params[0]) {				
				case "md2": return Hashing.md2(input);
				case "md5": return Hashing.md5(input);
				case "sha1": return Hashing.sha1(input);
				case "sha224": return Hashing.sha224(input);
				case "sha256": return Hashing.sha256(input);
				case "sha384": return Hashing.sha384(input);
				case "sha512": return Hashing.sha512(input);
				default: return null;
				}
				
			}
		}
		return new f();
	}
	private static double[] doubleVec(String[] arr) {
		double[] vec = new double[arr.length];
		int i = 0;
		for(String s : arr) {
			vec[i] = Double.valueOf(s);
			i++;
		}
		return vec;
	}
	public static Function[] sort() {
		
		class ins extends Function {
			ins() {
				super("insertion", new String[] {"array"});
			}
			@Override
			public Object evaluate(Object[] params) {							
				return SortingAlgorithms.insertionSort(doubleVec((String[])params[0]));
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString((double[])o);
			}
		}
		class bubble extends Function {
			bubble() {
				super("bubble", new String[] {"array"});
			}
			@Override
			public Object evaluate(Object[] params) {							
				return SortingAlgorithms.bubbleSort(doubleVec((String[])params[0]));
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString((double[])o);
			}
		}
		
		class selection extends Function {
			selection() {
				super("selection", new String[] {"array"});
			}
			@Override
			public Object evaluate(Object[] params) {							
				return SortingAlgorithms.selectionSort(doubleVec((String[])params[0]));
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString((double[])o);
			}
		}
		
		class merge extends Function {
			merge() {
				super("merge", new String[] {"array"});
			}
			@Override
			public Object evaluate(Object[] params) {
				double[] v = doubleVec((String[])params[0]);
				return SortingAlgorithms.mergeSort(v, 0, v.length-1);
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString((double[])o);
			}
		}
		
		return new Function[] {new ins(), new bubble(), new selection(), new merge()};
	}
	public static Function portScan() {
		class f extends Function {
			public f() {
				super("port-scan", new String[] {"ip"});
			}

			@Override
			public Object evaluate(Object[] params) {
				String ip = (String)params[0];
				if(Internet.reachHost(ip, 2000)) {
					return Internet.scanPorts(ip);	
				}
				else {
					return null;
				}
				
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString(((ArrayList<Integer>)o).toArray());
			}
		}
		return new f();
	}
	public static Function deviceProbe() {
		class f extends Function {
			public f() {
				super("device-probe", new String[] {"ip"});
			}

			@Override
			public Object evaluate(Object[] params) {
				String ip = (String)params[0];
				if(Internet.reachHost(ip, 2000)) {
					return new Target(ip, Internet.getIPHostname(ip), Internet.scanPorts(ip));	
				}
				else {
					return null;
				}
				
			}
			@Override
			public Object stringify(Object o) {
				return o.toString();
			}
		}
		return new f();
	}
	public static Function ping() {
		class f extends Function {
			public f() {
				super("ping", new String[] {"ip"});
			}

			@Override
			public Object evaluate(Object[] params) {
				String ip = (String)params[0];
				return Internet.reachHost(ip, 2000);
				
			}
		}
		return new f();
	}
	public static Function getPublicIP() {
		class f extends Function {
			public f() {
				super("public-ip", new String[] {});
			}

			@Override
			public Object evaluate(Object[] params) {
				return Internet.getPublicIP();				
			}
		}
		return new f();
	}
	public static Function getPrivateIP() {
		class f extends Function {
			public f() {
				super("private-ip", new String[] {});
			}

			@Override
			public Object evaluate(Object[] params) {
				return Internet.getLocalIP();				
			}
		}
		return new f();
	}
	public static Function getLanIP() {
		class f extends Function {
			public f() {
				super("lan-ip", new String[] {});
			}

			@Override
			public Object evaluate(Object[] params) {
				return Internet.getLANIP();				
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString(((ArrayList<String>)o).toArray());
			}
		}
		return new f();
	}
	public static Function urlIP() {
		class f extends Function {
			public f() {
				super("url-ip", new String[] {"url"});
			}

			@Override
			public Object evaluate(Object[] params) {
				String ip = (String)params[0];
				return Internet.getURLIP(ip);
			}
		}
		return new f();
	}
	public static Function scanNetwork() {
		class f extends Function {
			public f() {
				super("scan-network", new String[] {"T"}, "scan duration proportional to 22600*T (ms)");
			}

			@Override
			public Object evaluate(Object[] params) {				
				return Internet.scanNetwork(((Double)params[0]).intValue());
			}
			@Override
			public Object stringify(Object o) {
				return Arrays.toString(((ArrayList<String>)o).toArray());
			}
		}
		return new f();
	}
	public static Function LSRL() {
		class f extends Function {
			public f() {
				super("LSRL", new String[] {"x", "y"});
			}
			@Override
			public Object evaluate(Object[] params) {
				double[] x = doubleVec((String[])params[0]), y = doubleVec((String[])params[1]);
				return Regression.LSRL(x, y);
			}
		}
		return new f();
	}
	public static Function OVS() {
		class f extends Function {
			public f() {
				super("one-var-stats", new String[] {"array"});
			}
			@Override
			public Object evaluate(Object[] params) {
				double[] x = doubleVec((String[])params[0]);
				return new OneVarStats(x);
			}
		}
		return new f();
	}
	public static Function zScore() {
		class f extends Function {
			public f() {
				super("z-score", new String[] {"x","mu","sigma"});
			}
			@Override
			public Object evaluate(Object[] params) {
				double x = (double)params[0], mu = (double)params[1], sigma = (double)params[2];
				return Scores.zScore(x, mu, sigma);
			}
		}
		return new f();
	}
	public static Function PDF() {
		class f extends Function {
			public f() {
				super("probability-distribution-function", new String[] {"z-score", "direction"});
			}
			@Override
			public Object evaluate(Object[] params) {
				double zScore = (double)params[0]; int direction = ((Double)params[1]).intValue();				
				return Distributions.PDF(zScore, direction==1?DistributionDirections.LEQ:DistributionDirections.GEQ);
			}
		}
		return new f();
	}
	public static Function integrate() {
		class f extends Function {
			public f() {
				super("integration", new String[] {"equation", "a", "b", "n"});
			}
			@Override
			public Object evaluate(Object[] params) {
				double a = ((Double)params[1]), b = ((Double)params[2]), n = (Double)params[3];
				return NumericalIntegration.integrateSMPSN(new Equation().equationFromString((String)params[0]), a, b, n);
			}
		}
		return new f();
	}
	public static Function probSim() {
		class f extends Function {
			public f()
			{
				super("prob-sim", new String[] {"trials", "prob"});
			}
			@Override
			public Object evaluate(Object[] params) {
				Double trials = (Double)params[0], prob = (Double)params[1];
				return Probability.simulate(trials.intValue(), prob);
			}
		}
		return new f();
	}
	public static Function IRSA() {
		return new Function("IRSA-parse", new String[] {"code"}) {
			@Override
			public Object evaluate(Object[] params) {
				String[] v = new String[params.length]; int i = 0;
				for(Object o : params) {v[i] = (String)o; i++;};
				String sv = String.join(" ", v).trim();
				return IRSAtranslator.convert(sv);
			}
		};
	}
	public static Function get() {
		return new Function("get", new String[] {"url"}) {
			@Override
			public Object evaluate(Object[] params) {
				String path = (String) params[0];
				return APIreq.GET(path);						
			}
			@Override
			public String stringify(Object o) {
				StringBuilder sb = new StringBuilder();
				HttpResponse res = (HttpResponse)o;
				String[] d = {
						"Status: "+res.getResponseCode(),
						"Headers: "+res.getHeaders(),
						"Body: \n"+res.getBody()
				};
				sb.append("\n");
				for(String s :d) {					
					sb.append("\t"+s+"\n");
				}
				return sb.toString();
			}
		};
	}
	public static Function removeStopWords() {
		String n = "rm-stopw"; String[] p = {"body"};
		return new Function(n, p) {			
			@Override
			public Object evaluate(Object[] params) {
				String body = (String) params[0];
				return LinguisticParser.removeStopWords(body);
			}
		};
	}
	
	public static Function removeAll() {
		return new Function("rm-select", new String[] {"body", "regex"}) {
			@Override
			public Object evaluate(Object[] params) {
				String body = (String) params[0];
				String[] query = (String[]) params[1];
				return LinguisticParser.removeAll(body, query);
			}
		};
		
	}
}

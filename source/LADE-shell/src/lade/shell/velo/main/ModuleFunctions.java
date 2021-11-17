package lade.shell.velo.main;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Arrays;

import velo.ladealpha.fields.astronomy.navigation.Moment;
import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;
import velo.ladealpha.fields.math.LinearFunction;
import velo.ladealpha.fields.math.calculus.Limits;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;
import velo.ladealpha.fields.math.calculus.TaylorSeries;
import velo.ladealpha.fields.math.operations.SystemOfLinearFunctions;
import velo.ladealpha.fields.physics.ComplexVector;
import velo.ladealpha.fields.physics.kinematics.Kinematics;

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
				int day = now.getDayOfMonth();
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
				
				return new Moment((int)params[0], (int)params[1], (int)params[2], (int)params[3], (int)params[4], (int)params[5], (int)params[6]).getJulianDay();
			}
		}
		return new f();
	}
}

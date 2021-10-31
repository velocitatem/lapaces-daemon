package velo.ladealpha.fields.life;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;

// TODO: Auto-generated Javadoc
/**
 * The Class Life.
 */
public class Life {

	/** The subject. */
	private String subject;

	/** The patterns. */
	public Behavior[] patterns;

	/**
	 * Instantiates a new life.
	 *
	 * @param subject  the subject
	 * @param patterns the patterns
	 */
	public Life(String subject, Behavior[] patterns) {
		super();
		this.subject = subject;
		this.patterns = patterns;
	}

	
	public void graph() {
		
	}
	
	/**
	 * Gets the function set.
	 *
	 * @return the function set
	 */
	public String getFunctionSet() {
		String r = "";
		for (Behavior b : patterns) {
			for (Event e : b.getEvents()) {
				r += e + "\n";
			}
		}
		return r;
	}

	/**
	 * Composite equation.
	 *
	 * @return the equation
	 */
	private Equation compositeEquation() {
		return new Equation().equationFromString(this.getCompositeFunction());
	}

	/**
	 * Gets the composite function.
	 *
	 * @return the composite function
	 */
	public String getCompositeFunction() {
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("1");
		for (Behavior b : patterns) {
			for (Event e : b.getEvents()) {
				lst.add("cos( 1/" + e.getDay_freq() + " * x - " + e.getSigma() + " * pi )");
			}
		}
		return String.join("+", lst);
	}

	/**
	 * Compute closest event.
	 *
	 * @param x the x
	 * @return the event
	 */
	private Event computeClosestEvent(double x) {
		double smallestDiff = Double.POSITIVE_INFINITY;
		Event closestEvent = null;
		for (Behavior b : patterns) {
			for (Event e : b.getEvents()) {
				// System.out.println(e);
				if (!e.isExclusion()) {
					double diff = Math.abs(e.closestOccurance(x) - x);
					if (diff < smallestDiff) {
						smallestDiff = diff;
						closestEvent = e;
					}
				}
			}
		}
		return closestEvent;
	}

	/**
	 * Gets the closest event.
	 *
	 * @param day  the day
	 * @param hour the hour
	 * @return the closest event
	 */
	public Event getClosestEvent(double day, double hour) {
		double hourRadians = (hour / 24) * (2 * Math.PI);
		double hourRadiansCompliment = (2 * Math.PI) - hourRadians;
		double x = (Math.PI * 2 * day) - hourRadiansCompliment;
		return computeClosestEvent(x);
	}

	/**
	 * Generate report.
	 *
	 * @param baseDay            the base day
	 * @param prospectiveRange   the prospective range
	 * @param retrospectiveRange the retrospective range
	 * @return the life report
	 */
	public LifeReport generateReport(double baseDay, double prospectiveRange, double retrospectiveRange) {
		double start = baseDay - retrospectiveRange, end = baseDay + prospectiveRange;
		ArrayList<Double> xs = new ArrayList<Double>();
		HashMap<Double, Event> eventList = new HashMap<Double, Event>();
		for (double d = start; d < end; d += 0.1) {
			Event e = computeClosestEvent(d);
			double temporalPos = LMath.round(e.closestOccurance(d), 3);
			if (!xs.contains(temporalPos)) {
				eventList.put(temporalPos, e);
				xs.add(temporalPos);
			}
		}
		LifeReport lr = new LifeReport();
		Double[] vec = new Double[xs.size()];
		int i = 0;
		for (Map.Entry<Double, Event> set : eventList.entrySet()) {
			vec[i] = set.getKey();
			i += 1;
		}
		Arrays.sort(vec);
		System.out.println(Arrays.toString(vec));
		for (Double p : vec) {
			for (Map.Entry<Double, Event> set : eventList.entrySet()) {
				if (set.getKey() == p) {
					int day = (int) (set.getKey() / (Math.PI * 2));
					double time = ((((set.getKey() / (Math.PI * 2)) - day)) * 24);
					int minute = (int) ((time - ((int) time)) * 60);
					LifeReportComponent lrc = new LifeReportComponent(set.getValue(), day, time, minute);
					lr.add(lrc);
				}
			}
		}
		return lr;
	}

	/**
	 * Compute slope vector.
	 *
	 * @param x the x
	 * @return the array list
	 */
	public ArrayList<Double> computeSlopeVector(double x) {
		ArrayList<Double> vec = new ArrayList<Double>();
		for (Behavior b : patterns) {
			for (Event e : b.getEvents()) {
				vec.add(NumericalDifferentiation.differentiate(e.getEq(), x));
			}
		}
		return vec;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the patterns.
	 *
	 * @return the patterns
	 */
	public Behavior[] getPatterns() {
		return patterns;
	}

	/**
	 * Sets the patterns.
	 *
	 * @param patterns the patterns to set
	 */
	public void setPatterns(Behavior[] patterns) {
		this.patterns = patterns;
	}

}

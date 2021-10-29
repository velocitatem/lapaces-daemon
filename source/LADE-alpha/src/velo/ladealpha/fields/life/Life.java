package velo.ladealpha.fields.life;

import java.util.ArrayList;

import velo.ladealpha.fields.math.Equation;

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
	 * @param subject the subject
	 * @param patterns the patterns
	 */
	public Life(String subject, Behavior[] patterns) {
		super();
		this.subject = subject;
		this.patterns = patterns;
	}
	
	/**
	 * Gets the function set.
	 *
	 * @return the function set
	 */
	public String getFunctionSet() {
		String r = "";
		for(Behavior b : patterns) {
			for(Event e : b.getEvents()) {
				r+=e+"\n";
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
		for(Behavior b : patterns) {
			for(Event e : b.getEvents()) {
				lst.add("cos( 1/"+e.getDay_freq()+"x - "+e.getSigma()+"\\pi )");
			}
		}
		return String.join("+", lst);
	}
	
	/**
	 * Gets the closest event.
	 *
	 * @param day the day
	 * @param hour the hour
	 * @return the closest event
	 */
	public Event getClosestEvent(double day, double hour) {
		double hourRadians = (hour / 24) * (2*Math.PI);
		double hourRadiansCompliment = (2*Math.PI) - hourRadians; 
		double x = (Math.PI*2*day) - hourRadiansCompliment;
		double smallestDiff = Double.POSITIVE_INFINITY;
		Event closestEvent = null;
		for(Behavior b : patterns) {
			for(Event e : b.getEvents()) {
				System.out.println(e);
				if(!e.isExclusion()) {
					double diff = Math.abs(e.closestOccurance(x) - x);					
					if(diff<smallestDiff) {	
						smallestDiff = diff;						
						closestEvent = e;
					}
				}
			}
		}
//		System.out.println((smallestDiff/(Math.PI*2))*24);
		return closestEvent;
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

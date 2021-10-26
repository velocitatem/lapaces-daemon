package velo.ladealpha.fields.life;

public class Life {
	private String subject;
	public Behavior[] patterns;
	
	public Life(String subject, Behavior[] patterns) {
		super();
		this.subject = subject;
		this.patterns = patterns;
	}
	
	public Event getClosestEvent(double day, double hour) {
		double hourRadians = (hour / 24) * (2*Math.PI);
		double hourRadiansCompliment = (2*Math.PI) - hourRadians; 
		double x = (Math.PI*2*day) - hourRadiansCompliment;
		double closestX = Double.POSITIVE_INFINITY, smallestDiff = Double.POSITIVE_INFINITY;
		Event closestEvent = null;
		for(Behavior b : patterns) {
			for(Event e : b.getEvents()) {
				double diff = Math.abs(e.closestOccurance(x) - x);
				System.out.println(e);
				if(diff<smallestDiff) {
					
					smallestDiff = diff;
					closestX = 2;
					closestEvent = e;
				}
			}
		}
		System.out.println((smallestDiff/(Math.PI*2))*24);
		return closestEvent;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the patterns
	 */
	public Behavior[] getPatterns() {
		return patterns;
	}
	/**
	 * @param patterns the patterns to set
	 */
	public void setPatterns(Behavior[] patterns) {
		this.patterns = patterns;
	}
	
	
	
}

package velo.ladealpha.fields.life;

// TODO: Auto-generated Javadoc
/**
 * The Class Behavior.
 */
public class Behavior {
	
	/** The time of day. */
	double frequencyInDays, startTime, endTime, timeOfDay;
	
	/** The name. */
	String name;
	
	/** The secondary. */
	Event primary, secondary;
	
	/** The secondary exclusion. */
	Event primaryExclusion, secondaryExclusion;
	
	/**
	 * Exlude weekend.
	 *
	 * @return the behavior
	 */
	public Behavior exludeWeekend() {
		
		if(secondary==null) {
			primaryExclusion = new Event(name + " exclusion", 6, timeOfDay);
			primaryExclusion.setShift(-2);
		}
		else {
			primaryExclusion = new Event(name + " start exclusion", 6, startTime);
			primaryExclusion.setShift(-2);
			secondaryExclusion = new Event(name + " end exclusion", 6, endTime);
			secondaryExclusion.setShift(-2);
		}				
		return this;
	}
	
	/**
	 * Even.
	 *
	 * @return the behavior
	 */
	public Behavior even() {
		if(secondary==null) {
			return new Behavior(name, frequencyInDays, timeOfDay + 24);
		}
		else {
			return new Behavior(name, frequencyInDays, startTime + 24, endTime + 24);
		}		
	}
	
	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public Event[] getEvents() {
		if(secondary==null) {
			if(primaryExclusion == null) {
				return new Event[] {primary};
			}
			else {
				return new Event[] {primary, primaryExclusion};
			}
		}
		else {
			if(primaryExclusion == null && secondaryExclusion == null) {
				return new Event[] {primary, secondary};
			}
			else {
				return new Event[] {primary, secondary, primaryExclusion, secondaryExclusion};
			}
		}
	}
	
	/**
	 * Instantiates a new behavior.
	 *
	 * @param name the name
	 * @param frequencyInDays the frequency in days
	 * @param timeOfDay the time of day
	 */
	public Behavior(String name, double frequencyInDays, double timeOfDay) {
		super();
		this.name = name;
		this.frequencyInDays = frequencyInDays;
		this.timeOfDay = timeOfDay;
		this.primary = new Event(name, frequencyInDays, timeOfDay);
	}

	/**
	 * Instantiates a new behavior.
	 *
	 * @param name the name
	 * @param frequencyInDays the frequency in days
	 * @param startTime the start time
	 * @param endTime the end time
	 */
	public Behavior(String name, double frequencyInDays, double startTime, double endTime) {
		super();
		this.name = name;
		this.frequencyInDays = frequencyInDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.primary = new Event(name + " start", frequencyInDays, startTime);
		this.secondary = new Event(name + " end", frequencyInDays, endTime);
	}

	/**
	 * Gets the frequency in days.
	 *
	 * @return the frequencyInDays
	 */
	public double getFrequencyInDays() {
		return frequencyInDays;
	}

	/**
	 * Sets the frequency in days.
	 *
	 * @param frequencyInDays the frequencyInDays to set
	 */
	public void setFrequencyInDays(double frequencyInDays) {
		this.frequencyInDays = frequencyInDays;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the time of day.
	 *
	 * @return the timeOfDay
	 */
	public double getTimeOfDay() {
		return timeOfDay;
	}

	/**
	 * Sets the time of day.
	 *
	 * @param timeOfDay the timeOfDay to set
	 */
	public void setTimeOfDay(double timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	
}

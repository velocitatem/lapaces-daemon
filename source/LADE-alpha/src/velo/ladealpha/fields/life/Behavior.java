package velo.ladealpha.fields.life;

public class Behavior {
	double frequencyInDays, startTime, endTime, timeOfDay;
	String name;
	Event primary, secondary;
	Event primaryExclusion, secondaryExclusion;
	public Behavior even() {
		if(secondary==null) {
			return new Behavior(name, frequencyInDays, timeOfDay + 24);
		}
		else {
			return new Behavior(name, frequencyInDays, startTime + 24, endTime + 24);
		}		
	}
	
	public Event[] getEvents() {
		if(secondary==null) {
			return new Event[] {primary};
		}
		else {
			return new Event[] {primary, secondary};
		}
	}
	
	public Behavior(String name, double frequencyInDays, double timeOfDay) {
		super();
		this.name = name;
		this.frequencyInDays = frequencyInDays;
		this.timeOfDay = timeOfDay;
		this.primary = new Event(name, frequencyInDays, timeOfDay);
	}

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
	 * @return the frequencyInDays
	 */
	public double getFrequencyInDays() {
		return frequencyInDays;
	}

	/**
	 * @param frequencyInDays the frequencyInDays to set
	 */
	public void setFrequencyInDays(double frequencyInDays) {
		this.frequencyInDays = frequencyInDays;
	}

	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the timeOfDay
	 */
	public double getTimeOfDay() {
		return timeOfDay;
	}

	/**
	 * @param timeOfDay the timeOfDay to set
	 */
	public void setTimeOfDay(double timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	
}

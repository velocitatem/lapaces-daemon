package velo.ladaalpha.fields.life;

// TODO: Auto-generated Javadoc
/**
 * The Class LifeReportComponent.
 */
public class LifeReportComponent {
	
	/** The event. */
	private Event event;
	
	/** The minute. */
	private double day, hour, minute;

	/**
	 * Instantiates a new life report component.
	 *
	 * @param event the event
	 * @param day the day
	 * @param hour the hour
	 * @param minute the minute
	 */
	public LifeReportComponent(Event event, double day, double hour, double minute) {
		super();
		this.event = event;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "D-" + (int) day + " H-" + (int) hour + " M-" + (int) minute + "\t \t" + event.getName();
	}

	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Sets the event.
	 *
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public double getDay() {
		return day;
	}

	/**
	 * Sets the day.
	 *
	 * @param day the day to set
	 */
	public void setDay(double day) {
		this.day = day;
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public double getHour() {
		return hour;
	}

	/**
	 * Sets the hour.
	 *
	 * @param hour the hour to set
	 */
	public void setHour(double hour) {
		this.hour = hour;
	}

	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	public double getMinute() {
		return minute;
	}

	/**
	 * Sets the minute.
	 *
	 * @param minute the minute to set
	 */
	public void setMinute(double minute) {
		this.minute = minute;
	}

}

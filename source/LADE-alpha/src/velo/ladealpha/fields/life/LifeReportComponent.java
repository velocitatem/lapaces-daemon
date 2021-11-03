package velo.ladealpha.fields.life;

public class LifeReportComponent {
	private Event event;
	private double day, hour, minute;

	public LifeReportComponent(Event event, double day, double hour, double minute) {
		super();
		this.event = event;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	@Override
	public String toString() {
		return "D-" + (int) day + " H-" + (int) hour + " M-" + (int) minute + "\t \t" + event.getName();
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @return the day
	 */
	public double getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(double day) {
		this.day = day;
	}

	/**
	 * @return the hour
	 */
	public double getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(double hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public double getMinute() {
		return minute;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(double minute) {
		this.minute = minute;
	}

}

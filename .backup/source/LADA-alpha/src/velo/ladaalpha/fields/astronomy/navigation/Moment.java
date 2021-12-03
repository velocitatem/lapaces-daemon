package velo.ladaalpha.fields.astronomy.navigation;

import velo.ladaalpha.fields.astronomy.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class Moment.
 */
public class Moment {
	
	/** The Millisecond. */
	private int Year, Month, Day, Hour, Minute, Second, Millisecond;

	/**
	 * Instantiates a new moment.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 * @param ms the ms
	 */
	public Moment(int year, int month, int day, int hour, int minute, int second, int ms) {
		super();
		Year = year;
		Month = month;
		Day = day;
		Hour = hour;
		Minute = minute;
		Second = second;
		Millisecond = ms;
	}

	/**
	 * Gets the julian day.
	 *
	 * @return the julian day
	 */
	public double getJulianDay() {
		int Y = Year, M = Month, B = 0;		
		
		if(M == 1 || M == 2) {
			Y = Y - 1;
			M = M + 12;
		}
		
		if(!IsJulianDate()) {
			int A = Y / 100;
			B  = (2 - A + (int)(A / 4));		
		}
		return 
				(int) (Constants.days_in_year * (Y + Constants.JuliansDayConstant)) +
				(int) (30.6001 * (M + 1)) + DayOfMonth() + B - 1524.5;
	}

	/**
	 * Gets the date from julian day.
	 *
	 * @param jd the jd
	 * @return the date from julian day
	 */
	public static Moment getDateFromJulianDay(double jd) {
		Moment m = null;
		return m;
	}
	
	/**
	 * T value.
	 *
	 * @return the double
	 */
	public double T_Value() {
		return (getJulianDay() - 2451545.0) / (Constants.days_in_year * 100);
	}
	
	/**
	 * Checks if is julian date.
	 *
	 * @return true, if successful
	 */
	public boolean IsJulianDate() {		
		if (Year > 1582) { return false; }
		if (Year < 1582) { return true; }
		if (Month > 10) { return false; }
		if (Month < 10) { return true; }
		if (Day > 14) { return false; }				
		return true;
	}
	
	/**
	 * Day of month.
	 *
	 * @return the double
	 */
	public double DayOfMonth() {
		return Day + 
				(Hour / 24.0) + 
				(Minute / 1440.0) + 
				(Second + Millisecond / 1000.0) / 86400.0;
	}
	
	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return Year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the year to set
	 */
	public void setYear(int year) {
		Year = year;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public int getMonth() {
		return Month;
	}

	/**
	 * Sets the month.
	 *
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.Month = month;
	}

	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return Day;
	}

	/**
	 * Sets the day.
	 *
	 * @param day the day to set
	 */
	public void setDay(int day) {
		Day = day;
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public int getHour() {
		return Hour;
	}

	/**
	 * Sets the hour.
	 *
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		Hour = hour;
	}

	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	public int getMinute() {
		return Minute;
	}

	/**
	 * Sets the minute.
	 *
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		Minute = minute;
	}

	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	public int getSecond() {
		return Second;
	}

	/**
	 * Sets the second.
	 *
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		Second = second;
	}

	/**
	 * Gets the millisecond.
	 *
	 * @return the millisecond
	 */
	public int getMillisecond() {
		return Millisecond;
	}

	/**
	 * Sets the millisecond.
	 *
	 * @param millisecond the millisecond to set
	 */
	public void setMillisecond(int millisecond) {
		Millisecond = millisecond;
	}
	
}

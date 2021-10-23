package velo.ladealpha.fields.astronomy.navigation;

import velo.ladealpha.fields.astronomy.Constants;

public class Moment {
	private int Year, Month, Day, Hour, Minute, Second, Millisecond;

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
				(int) (Constants.days_in_year * (Y + Constants.JuliansDayConstant)) +(int) (30.6001 * (M + 1)) + DayOfMonth() + B - 1524.5;
	}

	public static Moment getDateFromJulianDay(double jd) {
		Moment m = null;
		return m;
	}
	
	public boolean IsJulianDate() {		
		if (Year > 1582) { return false; }
		if (Year < 1582) { return true; }
		if (Month > 10) { return false; }
		if (Month < 10) { return true; }
		if (Day > 14) { return false; }				
		return true;
	}
	
	public double DayOfMonth() {
		return Day + 
				(Hour / 24.0) + 
				(Minute / 1440.0) + 
				(Second + Millisecond / 1000.0) / 86400.0;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return Year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		Year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return Month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.Month = month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return Day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		Day = day;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return Hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		Hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return Minute;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		Minute = minute;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return Second;
	}

	/**
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		Second = second;
	}

	/**
	 * @return the millisecond
	 */
	public int getMillisecond() {
		return Millisecond;
	}

	/**
	 * @param millisecond the millisecond to set
	 */
	public void setMillisecond(int millisecond) {
		Millisecond = millisecond;
	}
	
}

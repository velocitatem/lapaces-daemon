package velo.ladealpha.fields.astronomy;

public class Constants {
	public static double days_in_year = 365.25; 
	
	public static int JuliansDayConstant = 4716;
	
	private static double au_p = 149597.870700;
	public static double au_meters = au_p * 1000000;
	
	private static double pc_p = 3.0856775814913673;
	public static double pc_meters = pc_p * Math.pow(10, 16);
	
}

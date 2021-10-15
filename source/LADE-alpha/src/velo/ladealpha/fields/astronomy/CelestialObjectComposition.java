package velo.ladealpha.fields.astronomy;

import java.util.ArrayList;
import java.util.HashMap;

public class CelestialObjectComposition {
	private ArrayList<HashMap<String, Double>> composition;

	public CelestialObjectComposition(Object[][] data) {
		composition = new ArrayList<HashMap<String,Double>>();
		for(int i = 0 ; i < data.length; i+=1) {
			String type = String.valueOf(data[i][0]);
			double value = (double)data[i][1];
			HashMap<String, Double> dat = new HashMap<String, Double>();
			dat.put(type, value);
			composition.add(dat);			
		}
	}	
}

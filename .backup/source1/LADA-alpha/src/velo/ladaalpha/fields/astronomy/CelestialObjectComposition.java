package velo.ladaalpha.fields.astronomy;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class CelestialObjectComposition.
 */
public class CelestialObjectComposition {
	
	/** The composition. */
	private ArrayList<HashMap<String, Double>> composition;

	/**
	 * Instantiates a new celestial object composition.
	 *
	 * @param data the data
	 */
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

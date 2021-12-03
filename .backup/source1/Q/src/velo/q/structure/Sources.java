package velo.q.structure;

import velo.q.structure.data.Cameras;
import velo.q.structure.data.Finance;
import velo.q.structure.data.Nasa;
import velo.q.structure.data.Opensky;
import velo.q.structure.data.Who;
import velo.q.structure.data.WorldBank;

// TODO: Auto-generated Javadoc
/**
 * The Class Sources.
 */
public class Sources {
	
	/**
	 * Gets the soruces.
	 *
	 * @return the soruces
	 */
	public static Source[] getSoruces() {
		return new Source[] { new Cameras(), new Opensky(), new Finance(), new Nasa(), new WorldBank(), new Who() };
	};
}

package velo.q.structure;

import velo.q.structure.data.Cameras;
import velo.q.structure.data.Opensky;

public class Sources {
	public static Source[] getSoruces() {			
			return new Source[] {new Cameras(), new Opensky()};
	};
}

package velo.q.structure;

import velo.q.structure.data.*;

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
        return new Source[]{new Cameras(), new Opensky(), new Finance(), new Nasa(), new WorldBank(), new Who()};
    }

}

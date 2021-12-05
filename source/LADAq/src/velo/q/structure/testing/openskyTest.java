package velo.q.structure.testing;

import org.junit.jupiter.api.Test;
import velo.q.structure.data.Opensky;

class openskyTest {

    @Test
    public void allAricraft() {
		/*
		JSONArray aray = (JSONArray)Opensky.allaircraft().fetch(null);
		for(int i = 0; i < aray.size() && i <10; i+=1) {
			JSONArray subarr = (JSONArray)aray.get(i);
			System.out.println(subarr.get(2) + " \t \t " + subarr.get(9));
		}
		*/

    }

    @Test
    public void arrivals() {
        Object o = Opensky.arrivals().fetch(new Object[]{"LKPR", "3", "3"});
        System.out.println(Opensky.arrivals().stringify(o));

    }
}

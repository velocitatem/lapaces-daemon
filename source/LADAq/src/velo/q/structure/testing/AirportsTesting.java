package velo.q.structure.testing;

import org.junit.jupiter.api.Test;
import velo.q.structure.DataPoint;
import velo.q.structure.data.Opensky;


class AirportsTesting {

    @Test
    void test() {
        DataPoint dp = Opensky.findAirport();
        Object o = dp.fetch(new Object[]{"Vienna"});
        System.out.println(dp.stringify(o));
    }

}

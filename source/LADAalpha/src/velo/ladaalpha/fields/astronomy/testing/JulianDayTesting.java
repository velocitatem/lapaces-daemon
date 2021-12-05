package velo.ladaalpha.fields.astronomy.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.astronomy.navigation.Moment;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class JulianDayTesting.
 */
class JulianDayTesting {

    /**
     * Test.
     */
    @Test
    void test() {
        Moment moment = new Moment(1957, 10, 4, 19, 29, 0, 0);
        assertEquals((int) 2436116.31180556, (int) moment.getJulianDay());
        System.out.println(moment.T_Value());
        moment = new Moment(2000, 1, 1, 12, 0, 0, 0);
        assertEquals((int) 2451545.0000000, moment.getJulianDay());
    }

}

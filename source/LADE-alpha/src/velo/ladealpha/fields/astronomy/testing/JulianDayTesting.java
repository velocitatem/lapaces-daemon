package velo.ladealpha.fields.astronomy.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.astronomy.navigation.Moment;

class JulianDayTesting {

	@Test
	void test() {
		Moment moment = new Moment(1957, 10, 4, 19, 29, 0, 0);
		assertEquals((int)2436116.31180556, (int)moment.getJulianDay());
		System.out.println(moment.T_Value());
		moment = new Moment(2000, 1, 1, 12, 0, 0, 0);
		assertEquals((int)2451545.0000000, moment.getJulianDay());
	}

}

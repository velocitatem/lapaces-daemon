package velo.q.structure.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;


import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.q.structure.DataPoint;
import velo.q.structure.data.Opensky;

class AirportsTesting {

	@Test
	void test() {
		DataPoint dp = Opensky.findAirport();
		Object o = dp.fetch(new Object [] {"Vienna"});
		System.out.println(dp.stringify(o));
	}

}

package velo.q.structure.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.q.structure.DataPoint;
import velo.q.structure.data.Who;

class WhoTesting {

	@Test
	void test() {
		DataPoint o = Who.indicator();
		Object n = o.fetch(new Object[] {"WHS3_48", "ARG"});		
		o.plot(n);
	}


}

package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.stats.OneVarStats;

class OneVarStatsTest {

	@Test
	void test() {
		double[] arr = {0.7071, 0.866, 1.7321, 0.5, 2};
		OneVarStats ovs = new OneVarStats(arr);
		double[] res = {ovs.getMed(), ovs.getxBar(), ovs.getN()}, exp = {0.866,1.16104,5.0};
		int i =0;
		System.out.println(ovs);
		for(double r : res) {
			assertEquals(exp[i], r);
			i+=1;
		}
	}

}

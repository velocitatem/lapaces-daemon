package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.stats.OneVarStats;
import velo.ladaalpha.fields.math.stats.TwoVarStats;
import velo.ladaalpha.misc.MkArray;

class VarStatsTest {

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
	
	@Test
	void test2() {
		double[] x = MkArray.IncrementalDoubleArray(1, 5);
		double[] y = {31.25, 39.2, 45.0, 48.05, 50.0};
		TwoVarStats tvs = new TwoVarStats(x, y);
		System.out.println(tvs);
		// r = 0.965
		
	}

}

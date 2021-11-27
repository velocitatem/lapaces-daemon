package velo.q.structure.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.q.structure.DataPoint;
import velo.q.structure.data.WorldBank;

class WorldBankTesting {

	@Test
	void test() {
		/*
		DataPoint p = WorldBank.countries();
		Object o = p.fetch(new Object[] {"Sri", "Lanka"});
		String r = p.stringify(o);
		System.out.println(r);
		*/
	}
	
	@Test 
	void indicators() {
		DataPoint p = WorldBank.indicator();
		//tell indicator 1.0.HCount.Poor4uds COL
		//Object o = p.fetch(new Object[] {"NY.GDP.MKTP.CD", "CZE"});
		//System.out.println(p.stringify(o));
	}

	@Test
	void queryIndicators() {
		DataPoint p = WorldBank.findIndicator();
		Object o = p.fetch(new Object[] {"Poverty"});
		System.out.println(p.stringify(o));
	}
}

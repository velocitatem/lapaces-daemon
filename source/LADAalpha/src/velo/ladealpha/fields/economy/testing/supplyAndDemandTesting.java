package velo.ladealpha.fields.economy.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.economy.supplyANDdemand.Demand;
import velo.ladaalpha.fields.economy.supplyANDdemand.Supply;
import velo.ladaalpha.fields.economy.supplyANDdemand.SupplyAndDemandSystem;

// TODO: Auto-generated Javadoc
/**
 * The Class supplyAndDemandTesting.
 */
class supplyAndDemandTesting {

	/**
	 * Test.
	 */
	@Test
	void test() {
		Supply supply = new Supply(0, 100, 2, 600);
		Demand demand = new Demand(0, 100, 2, 50);
		System.out.println(supply.toString());
		System.out.println(demand.toString());
		SupplyAndDemandSystem sads = new SupplyAndDemandSystem(supply, demand);
		System.out.println(sads.getEquilibriumVerbose());
	}

}

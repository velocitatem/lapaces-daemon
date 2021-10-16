package velo.ladealpha.fields.economy.supplyANDdemand;

import velo.ladealpha.fields.math.LinearFunction;
import velo.ladealpha.fields.math.operations.SystemOfLinearFunctions;

public class SupplyAndDemandSystem {
	private Supply supply;
	private Demand demand;
	public SupplyAndDemandSystem(LinearFunction supply, LinearFunction demand) { 
		 this.supply = (Supply) supply;
		 this.demand = (Demand) demand;
	}
	public double[] getEquilibrium() {
		return new SystemOfLinearFunctions(supply, demand).solution();
	}
	public String getEquilibriumVerbose() {
		double[] eq = this.getEquilibrium();
		return "Eq: ("+eq[0] + " , " +  eq[1] + ")";
	}
} 

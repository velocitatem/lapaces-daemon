package velo.ladaalpha.fields.economy.supplyANDdemand;

import velo.ladaalpha.fields.math.LinearFunction;
import velo.ladaalpha.fields.math.operations.SystemOfLinearFunctions;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplyAndDemandSystem.
 */
public class SupplyAndDemandSystem {
	
	/** The supply. */
	private Supply supply;
	
	/** The demand. */
	private Demand demand;
	
	/**
	 * Instantiates a new supply and demand system.
	 *
	 * @param supply the supply
	 * @param demand the demand
	 */
	public SupplyAndDemandSystem(LinearFunction supply, LinearFunction demand) { 
		 this.supply = (Supply) supply;
		 this.demand = (Demand) demand;
	}
	
	/**
	 * Gets the equilibrium.
	 *
	 * @return the equilibrium
	 */
	public double[] getEquilibrium() {
		return new SystemOfLinearFunctions(supply, demand).solution();
	}
	
	/**
	 * Gets the equilibrium verbose.
	 *
	 * @return the equilibrium verbose
	 */
	public String getEquilibriumVerbose() {
		double[] eq = this.getEquilibrium();
		return "Eq: ("+eq[0] + " , " +  eq[1] + ")";
	}
} 

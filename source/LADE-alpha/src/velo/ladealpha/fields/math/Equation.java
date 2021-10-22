package velo.ladealpha.fields.math;

import java.util.ArrayList;

/**
 * @author velo
 * 
 */
public class Equation{
	private ArrayList<EquationComponent> components = new ArrayList<EquationComponent>();
	public Equation() {
		
	}
	
	public Equation(ArrayList<EquationComponent> components) {
		super();
		this.components = components;
	}

	/**
	 * @return the components
	 */
	public ArrayList<EquationComponent> getComponents() {
		return components;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(ArrayList<EquationComponent> components) {
		this.components = components;
	}

	public void add(EquationComponents type, double[] parameter_set) {
		EquationComponent component = new EquationComponent(type, parameter_set);
		components.add(component);
	}
	public double compute(double input) {
		double res = 0;
		for(EquationComponent component : components) {
			if(component.getType() == EquationComponents.AXPN) {
				double[] set = component.getValues();
				res += (set[0] * Math.pow(input, set[1]));
			}
			else if ( component.getType() == EquationComponents.Constant) {
				res += component.getValues()[0];
			}
			else if ( component.getType() == EquationComponents.Sqrt) {
				res += Math.sqrt(component.getValues()[0]);
			}
		}
		return res;
	}
}

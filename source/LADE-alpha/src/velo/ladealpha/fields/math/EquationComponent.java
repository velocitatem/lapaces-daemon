package velo.ladealpha.fields.math;

public class EquationComponent {
	private EquationComponents type;
	private double[] values;
	public EquationComponent(EquationComponents type, double[] values) {
		super();
		this.type = type;
		this.values = values;
	}
	/**
	 * @return the type
	 */
	public EquationComponents getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(EquationComponents type) {
		this.type = type;
	}
	/**
	 * @return the values
	 */
	public double[] getValues() {
		return values;
	}
	/**
	 * @param values the values to set
	 */
	public void setValues(double[] values) {
		this.values = values;
	}
	
}

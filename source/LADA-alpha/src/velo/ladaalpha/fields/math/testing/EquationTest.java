package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;


// TODO: Auto-generated Javadoc
/**
 * The Class EquationTest.
 */
class EquationTest {

	/**
	 * The Class eq1.
	 */
	class eq1 extends Equation {
		
		/**
		 * Compute.
		 *
		 * @param input the input
		 * @return the double
		 */
		@Override
		public double compute(double input) {
			return (4*input)/Math.pow(2, input);
		}
	}
	
	/**
	 * Test.
	 */
	@Test
	void test() {
		
 		Equation eq = new eq1();		
		double result = eq.compute(5);
	//	System.out.println(result);
	}
	
	/**
	 * Inverse.
	 */
	@Test
	void inverse() {
		System.out.println(new eq1().computeInverse(1000));
	}

}

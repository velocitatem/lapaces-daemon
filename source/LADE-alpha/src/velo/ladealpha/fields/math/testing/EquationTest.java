package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;


class EquationTest {

	class eq1 extends Equation {
		@Override
		public double compute(double input) {
			return (4*input)/Math.pow(2, input);
		}
	}
	
	@Test
	void test() {
		
 		Equation eq = new eq1();		
		double result = eq.compute(5);
	//	System.out.println(result);
	}
	
	@Test
	void inverse() {
		System.out.println(new eq1().computeInverse(1000));
	}

}

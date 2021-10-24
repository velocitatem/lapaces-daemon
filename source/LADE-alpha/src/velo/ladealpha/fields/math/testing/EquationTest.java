package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;


class EquationTest {

	@Test
	void test() {
		class eq1 extends Equation {
			@Override
			public double compute(double input) {
				return (4*input)/Math.pow(2, input);
			}
		}
 		Equation eq = new eq1();		
		double result = eq.compute(5);
		System.out.println(result);
	}

}

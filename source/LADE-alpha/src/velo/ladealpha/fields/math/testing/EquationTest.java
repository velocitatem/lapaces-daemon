package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.EquationComponents;

class EquationTest {

	@Test
	void test() {
		Equation eq = new Equation();
		eq.add(EquationComponents.AXPN, new double[] {2,4});
		eq.add(EquationComponents.Constant, new double[] {9});
		double result = eq.compute(5);
		System.out.println(result);
	}

}

package velo.ladealpha.fields.services.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;
import velo.ladealpha.fields.services.GnuplotGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class GnuplotGeneratorTst.
 */
class GnuplotGeneratorTst {

	/**
	 * Test.
	 */
	@Test
	void test() {
		Equation eq = new Equation().equationFromString("Math.cos(x + Math.PI)")
				, eq1 = new Equation().equationFromString("1 / (3*x)");
		
		GnuplotGenerator gg = new GnuplotGenerator();
		String o = gg.generate(new Equation[] {eq, eq1}, "Test");
		System.out.println(o);
	}

}

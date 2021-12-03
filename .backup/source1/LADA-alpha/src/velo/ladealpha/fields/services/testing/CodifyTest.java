package velo.ladealpha.fields.services.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.services.Codify;

// TODO: Auto-generated Javadoc
/**
 * The Class CodifyTest.
 */
class CodifyTest {

	/**
	 * Test.
	 */
	@Test
	void test() {
		Codify c = new Codify();
		c.computeStringEquation("3 * x + 2", 4.0);
	}

}

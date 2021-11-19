package velo.ladaalpha.fields.physics.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.physics.ComplexVector;

class ComplexVectorOps {

	@Test
	void test() {
		
		int c = 5;
		assertEquals(Math.PI/2, new ComplexVector(0, c).ThetaRadians());
		assertEquals(90, new ComplexVector(0, c).ThetaDegrees());
		assertEquals(Math.PI/4, new ComplexVector(c, c).ThetaRadians());
	}

}

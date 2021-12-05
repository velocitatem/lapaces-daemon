package velo.ladaalpha.fields.physics.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.physics.ComplexVector;
import static org.junit.jupiter.api.Assertions.assertEquals;
// TODO: Auto-generated Javadoc

/**
 * The Class ComplexVectorOps.
 */
class ComplexVectorOps {

    /**
     * Test.
     */
    @Test
    void test() {

        int c = 5;
        assertEquals(Math.PI / 2, new ComplexVector(0, c).ThetaRadians());
        assertEquals(90, new ComplexVector(0, c).ThetaDegrees());
        assertEquals(Math.PI / 4, new ComplexVector(c, c).ThetaRadians());
    }

}

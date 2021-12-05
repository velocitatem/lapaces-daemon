package velo.ladaalpha.fields.math.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.calculus.NumericalDifferentiation;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class NumericaDifferentiationTest.
 */
class NumericaDifferentiationTest {

    /**
     * The x.
     */
    double x = 7.5;

    /**
     * The Class f.
     */
    class f extends Equation {

        /**
         * Compute.
         *
         * @param x the x
         * @return the double
         */
        @Override
        public double compute(double x) {
            return Math.tan((6 * x) / 2);
        }
    }

    /**
     * Test.
     */
    @Test
    void test() {

        assertEquals(3, (int) NumericalDifferentiation.differentiate(new f(), x));

    }

    /**
     * Test 2.
     */
    @Test
    void test2() {
        assertEquals(3, (int) NumericalDifferentiation.differentiate(new f()).compute(x));
    }

    /**
     * High order.
     */
    @Test
    void highOrder() {
        System.out.println(NumericalDifferentiation.differentiate(
                new Equation().equationFromString("Math.pow(Math.sqrt(x), 4)"), 5, 3));
    }

}

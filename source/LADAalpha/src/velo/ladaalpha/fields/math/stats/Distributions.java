package velo.ladaalpha.fields.math.stats;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.calculus.NumericalIntegration;

// TODO: Auto-generated Javadoc

/**
 * The Class Distributions.
 */
public class Distributions {

    /**
     * The Class PDFequation.
     */
    private static class PDFequation extends Equation {

        /**
         * Compute.
         *
         * @param input the input
         * @return the double
         */
        @Override
        public double compute(double input) {
            return (Math.pow(Math.E, -(Math.pow(input, 2) / 2))) / (Math.sqrt(2 * Math.PI));
        }
    }

    /**
     * Pdf.
     *
     * @param z   the z
     * @param dir the dir
     * @return the double
     */
    public static Double PDF(double z, DistributionDirections dir) {

        return dir.equals(DistributionDirections.LEQ) ? NumericalIntegration.integrateSMPSN(new PDFequation(), -10, z, 1000) : NumericalIntegration.integrateSMPSN(new PDFequation(), z, 10, 1000);
    }
}

package velo.ladaalpha.fields.life.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.life.Behavior;
import velo.ladaalpha.fields.life.Life;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class LifeTesting.
 */
class LifeTesting {

    /**
     * The secod life.
     */
    // sample life model
    Life life = new Life("Daniel Rosel", new Behavior[]{
            new Behavior("Waking up", 1, 5.75), new Behavior("Preparing for the day", 2, 5.76, 6.25),
            new Behavior("Covid Test", 3, 14), new Behavior("Being social", 4, 20, 21).even(),
            new Behavior("Gym", 2, 6.5, 7.5).even(), new Behavior("Homework", 1, 19, 21), new Behavior("School", 1, 8.5, 15.5).exludeWeekend(),
            new Behavior("Work", 1, 11.5, 12.25), new Behavior("Work", 1, 16, 18), new Behavior("Dinner", 1, 18, 19),
            new Behavior("Dentist", 100, 12)

    }), smallLife = new Life("Daniel Rosel", new Behavior[]{new Behavior("Climb", 2, 6.25).even()}),
            secodLife = new Life("John Doe", new Behavior[]{

                    new Behavior("Waking up", 1, 7.5), new Behavior("Breakfast", 1, 7.7),
                    new Behavior("Traveling to work", 1, 8, 8.45), new Behavior("Working", 1, 8.5, 16.5)

            });

    /**
     * Odd day behavior.
     */
    @Test
    void oddDayBehavior() {
        double probe = 2;
        assertEquals(smallLife.getPatterns()[0].getEvents()[0].getSigma(),
                new Behavior("", 2, 24 + 6.25).getEvents()[0].getSigma());
    }

    /**
     * Composite function.
     */
    @Test
    void compositeFunction() {

        System.out.println(life.getCompositeFunction());
    }

    /**
     * Weekend.
     */
    @Test
    void weekend() {
        Life life = new Life("Everyone", new Behavior[]{

        });
        Behavior b = new Behavior("Weekend Work Negation", 6, 12);

    }

    /**
     * Test.
     */
    @Test
    void test() {
        assertEquals("Work end", life.getClosestEvent(1, 18.2).getName());
    }

    /**
     * Report.
     */
    @Test
    void report() {

        System.out.println(secodLife.getFunctionSet());
        System.out.println(secodLife.generateReport(5, 4, 4));
    }


    /**
     * Code.
     */
    @Test
    void code() {

    }

    /**
     * Life vector.
     */
    @Test
    void lifeVector() {
        System.out.println("V:" + Arrays.toString(life.computeSlopeVector(4).toArray()));
    }

}

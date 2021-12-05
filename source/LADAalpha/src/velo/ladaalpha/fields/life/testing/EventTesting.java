package velo.ladaalpha.fields.life.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.life.Event;
import velo.ladaalpha.fields.math.LMath;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class EventTesting.
 */
class EventTesting {

    /**
     * Test.
     */
    @Test
    void test() {
        Event event = new Event("test", 1, 18);
        double o = LMath.round(event.closestOccurance(4), 2);
        assertEquals(4.71, o);
    }

}

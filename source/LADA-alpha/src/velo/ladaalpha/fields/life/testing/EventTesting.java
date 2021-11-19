package velo.ladaalpha.fields.life.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.life.Event;
import velo.ladaalpha.fields.math.LMath;

class EventTesting {

	@Test
	void test() {
		Event event = new Event("test", 1, 18);
		double o = LMath.round(event.closestOccurance(4), 2);
		assertEquals(4.71, o);
	}

}

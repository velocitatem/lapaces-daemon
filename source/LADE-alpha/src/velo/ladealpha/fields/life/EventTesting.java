package velo.ladealpha.fields.life;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class EventTesting {

	@Test
	void test() {
		Event event = new Event(2, 1.3, 2);
		System.out.println(Arrays.deepToString(event.intersections(2, 20).toArray()));
	}

}

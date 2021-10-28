package velo.ladealpha.fields.life.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.life.Behavior;
import velo.ladealpha.fields.life.Life;

class LifeTesting {

	// sample life model
	Life life = new Life("Daniel Rosel", new Behavior[] {
			new Behavior("Waking up", 1, 5.75), new Behavior("Preparing for the day", 2, 5.75, 6.25),
			new Behavior("Covid Test", 3, 14), new Behavior("Being social", 4, 20, 21).even(),
			new Behavior("Gym", 2, 6.5, 7.5).even(), new Behavior("Homework", 1, 19, 21), new Behavior("School", 1, 8.5, 15.5).exludeWeekend(),
			new Behavior("Work", 1, 11.5, 12.25), new Behavior("Work", 1, 16, 18), new Behavior("Dinner", 1, 18, 19),
			new Behavior("Dentist", 100, 12)

	}), smallLife = new Life("Daniel Rosel", new Behavior[] { new Behavior("Climb", 2, 6.25).even() });

	@Test
	void oddDayBehavior() {
		double probe = 2;
		assertEquals(smallLife.getPatterns()[0].getEvents()[0].getSigma(),
				new Behavior("", 2, 24 + 6.25).getEvents()[0].getSigma());
	}

	@Test
	void compositeFunction() {

		System.out.println(life.getCompositeFunction());
	}

	@Test
	void weekend() {
		Life life = new Life("Everyone", new Behavior[] {

		});
		Behavior b = new Behavior("Weekend Work Negation", 6, 12);
		System.out.println(b.getEvents()[0].toString());
	}

	@Test
	void test() {
		assertEquals("Work end", life.getClosestEvent(1, 18.2).getName());
	}

}

package velo.ladealpha.fields.life.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.life.Behavior;
import velo.ladealpha.fields.life.Life;

class LifeTesting {

	@Test
	void test() {
		Life life = new Life("John Doe", new Behavior[] {						
				new Behavior("Waking up", 1, 6.5),
				new Behavior("Preparing for school",1, 7, 8),
				new Behavior("Covid Test", 3, 17),
				new Behavior("Text friends", 4, 20, 21)
		});
		System.out.println(life.getClosestEvent(5, 18).getName());
	}

}

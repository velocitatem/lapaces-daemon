package lada.shell.velo.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void test() {
		String[] commands = {
			"run physics/kinematics 0 distance 2 time 4",
			"run physics/kinematics 1 v0 2 v 3 t 3",
			"run physics/vectors 0 ax 1 ay 1",
			"run physics/vectors 1 ax 1 ay 1",
			"run physics/vectors 2 theta 1.52 magnitude 1",
			"run math/calculus 0 equation x*2 x 2",
			"run math/calculus 1 equation Math.pow(2,x) x 2 order 1",
			"run math/calculus 2 equation Math.pow(2,x) x 3",
			"run math/operations 0 m1 2 b1 2 m2 -2 b2 2",
			"run math/operations 1 a 4",
			"run math/stats 0 x arr(0,1,2,3) y arr(1,2,3,4)",
			"run astronomy/navigation 0",
			"run astronomy/navigation 1 year 2021 month 6 day 15 hour 12 minute 30 second 30 millis 5",
			"run computing/cryptography 0 type md2 body hello",
			"run computing/sorting 0 array arr(-0.5,-2,3,-40)",
			"run computing/sorting 1 array arr(-0.5,-2,3,-40)",
			"run computing/sorting 2 array arr(-0.5,-2,3,-40)",
			"run computing/sorting 3 array arr(-0.5,-2,3,-40)",
			"run system/network 0 ip 127.0.0.1",
			"run system/network 1 ip 127.0.0.1",
			"run system/network 2 T 1",
			"run system/network 3 ip 127.0.01",
			"run system/network 4",
			"run system/network 6",
			"run system/network 7 url https://github.com"
		};
		for(String s : commands) {
			System.out.println("# `"+s+"`");
			try {
				System.out.println("```");
				Main.forward(s);
				System.out.println("```");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}


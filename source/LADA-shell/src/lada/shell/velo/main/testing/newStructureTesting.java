package lada.shell.velo.main.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lada.shell.velo.main.Main;

class newStructureTesting {

	@Test
	void test() {
		Main.forward("run computing/cryptography 0 type=sha256 body=(hello world)");
	}

}

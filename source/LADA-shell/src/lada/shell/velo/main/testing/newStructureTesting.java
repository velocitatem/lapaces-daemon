package lada.shell.velo.main.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lada.shell.velo.main.Main;

class newStructureTesting {

	@Test
	void test() {
		Main.forward("run computing/sorting 0 array=arr[1,2,4,8,2]");
	}

}

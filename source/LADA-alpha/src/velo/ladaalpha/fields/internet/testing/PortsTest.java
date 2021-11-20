package velo.ladaalpha.fields.internet.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.internet.Internet;

class PortsTest {

	@Test
	void test() {
		ArrayList<Integer> l = Internet.scanPorts("10.0.1.101");
		System.out.println(Arrays.toString(l.toArray()));
	}

}

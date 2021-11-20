package velo.ladaalpha.fields.internet.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.net.SocketException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.internet.Internet;

class LANIPTest {

	@Test
	void test() {
		Internet.getLANIP();
	}
	
	@Test
	void networkScan() {
		System.out.println(Arrays.toString(Internet.scanNetwork(1).toArray()));;
	}

}

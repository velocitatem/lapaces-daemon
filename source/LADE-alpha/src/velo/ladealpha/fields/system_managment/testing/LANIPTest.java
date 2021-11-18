package velo.ladealpha.fields.system_managment.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.net.SocketException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.system_managment.Internet;

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

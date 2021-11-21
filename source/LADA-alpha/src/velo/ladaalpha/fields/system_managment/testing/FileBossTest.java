package velo.ladaalpha.fields.system_managment.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.system_managment.FileBoss;

class FileBossTest {

	@Test
	void test() {
		FileBoss.createFile("/tmp/test.txt");
		
	}

}

package velo.ladaalpha.fields.system_managment.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.system_managment.FileBoss;

// TODO: Auto-generated Javadoc
/**
 * The Class FileBossTest.
 */
class FileBossTest {

	/**
	 * Test.
	 */
	@Test
	void test() {
		FileBoss.createFile("/tmp/test.txt");
		
	}

}

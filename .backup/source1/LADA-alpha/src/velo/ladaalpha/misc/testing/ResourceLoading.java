package velo.ladaalpha.misc.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import resources.ResourceLoader;
import velo.ladaalpha.misc.SystemCommand;
import velo.ladealpha.fields.services.ResourceFileLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceLoading.
 */
class ResourceLoading {

	/**
	 * Test.
	 */
	@Test
	void test() {
		
		ResourceFileLoader rl = new ResourceFileLoader();
		String path = rl.loadFile("script.js");
		String out = SystemCommand.runSV("node "+ path);		
		System.out.println(out);

	}

}

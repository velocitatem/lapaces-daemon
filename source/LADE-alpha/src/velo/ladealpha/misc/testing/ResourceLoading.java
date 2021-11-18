package velo.ladealpha.misc.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import resources.ResourceLoader;
import velo.ladealpha.misc.SystemCommand;

class ResourceLoading {

	@Test
	void test() {
		
		String p = System.currentTimeMillis() + "-tmp";
		File out = new File(p);
		try {
			out.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter(p);
			BufferedReader br = ResourceLoader.loadFile("script.js");			
			String line;
			while ((line = br.readLine()) != null) {
				fw.write(line+"\n");
			}			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SystemCommand.run("node " + p);

	}

}

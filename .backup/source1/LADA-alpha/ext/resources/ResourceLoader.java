package resources;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

public class ResourceLoader {
	static ResourceLoader rl = new ResourceLoader();
	public static BufferedReader loadFile(String name) {
		URL url = rl.getClass().getResource("files/"+name);		
		BufferedReader read = null;
		try {
			read = new BufferedReader(new InputStreamReader(url.openStream()));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return read;
	}
}

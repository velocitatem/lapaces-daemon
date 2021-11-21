package velo.ladaalpha.fields.system_managment;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBoss {
	public static Boolean fileExists(String fileName) {
		return new File(fileName).exists();
	}
	public static void createFile(String fileName) {
		if(!fileExists(fileName)) {
			File file = new File(fileName);
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("file exists");
		}				
	}
	public static Boolean copyFiles(String a, String b) {
		Path r = null;
		try {
			r = Files.copy(Paths.get(a), Paths.get(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r!=null;
	}
	public static Boolean moveFiles(String a, String b) {
		Path r = null;
		try {
			r = Files.move(Paths.get(a), Paths.get(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r!=null;
	}
	public static void deleteFile(String fileName) {
		new File(fileName).delete();
	}
	
}

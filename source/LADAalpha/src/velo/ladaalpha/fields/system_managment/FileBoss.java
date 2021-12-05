package velo.ladaalpha.fields.system_managment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc

/**
 * The Class FileBoss.
 */
public class FileBoss {

    /**
     * File exists.
     *
     * @param fileName the file name
     * @return the boolean
     */
    public static Boolean fileExists(String fileName) {
        return new File(fileName).exists();
    }

    /**
     * Creates the file.
     *
     * @param fileName the file name
     */
    public static void createFile(String fileName) {
        if (!fileExists(fileName)) {
            File file = new File(fileName);
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("file exists");
        }
    }

    /**
     * Copy files.
     *
     * @param a the a
     * @param b the b
     * @return the boolean
     */
    public static Boolean copyFiles(String a, String b) {
        Path r = null;
        try {
            r = Files.copy(Paths.get(a), Paths.get(b));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return r != null;
    }

    /**
     * Move files.
     *
     * @param a the a
     * @param b the b
     * @return the boolean
     */
    public static Boolean moveFiles(String a, String b) {
        Path r = null;
        try {
            r = Files.move(Paths.get(a), Paths.get(b));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return r != null;
    }

    /**
     * Delete file.
     *
     * @param fileName the file name
     */
    public static void deleteFile(String fileName) {
        new File(fileName).delete();
    }

}

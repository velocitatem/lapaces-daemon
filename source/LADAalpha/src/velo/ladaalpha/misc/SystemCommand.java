package velo.ladaalpha.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: Auto-generated Javadoc

/**
 * The Class SystemCommand.
 */
public class SystemCommand {

    /**
     * Run SV.
     *
     * @param command the command
     * @return the string
     */
    public static String runSV(String command) {
        String s = null;
        StringBuilder sb = new StringBuilder();
        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                sb.append(s + "\n");
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                sb.append(s + "\n");
            }

        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Run.
     *
     * @param command the command
     */
    public static void run(String command) {
        String s = null;

        try {

            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }
    }
}

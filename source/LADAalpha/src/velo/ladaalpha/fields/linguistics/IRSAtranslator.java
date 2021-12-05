package velo.ladaalpha.fields.linguistics;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc

/**
 * The Class IRSAtranslator.
 */
public class IRSAtranslator {

    /**
     * The numbers.
     */
    private static final String[] a = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-Ray", "Yankee", "Zulu"};
    private static final String[] numbers = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    /**
     * Convert.
     *
     * @param msg the msg
     * @return the string
     */
    public static String convert(String msg) {
        if (msg == null) {
            return null;
        }
        String[] i = msg.split("");
        String[] r = new String[i.length];
        for (int f = 0; f < i.length; f += 1) {
            try {
                Integer k = Integer.valueOf(i[f]);
                r[f] = numbers[k];
            } catch (Exception e) {
                if (i[f].equals(".")) {
                    r[f] = "Decimal";
                } else if (!i[f].equals(" ")) {

                    int p = 0;
                    for (String aa : a) {
                        if (aa.substring(0, 1).equals(i[f])) {
                            r[f] = aa;
                        }
                        p += 1;
                    }
                }
            }
        }

        ArrayList<String> fin = new ArrayList<String>();
        for (String rr : r) {
            if (rr != null) fin.add(rr);
        }
        return String.join(" ", fin);
    }
}

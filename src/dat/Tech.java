/*
 * Copyright (C) 2015 joulupunikki joulupunikki@gmail.communist.invalid.
 *
 *  Disclaimer of Warranties and Limitation of Liability.
 *
 *     The creators and distributors offer this software as-is and
 *     as-available, and make no representations or warranties of any
 *     kind concerning this software, whether express, implied, statutory,
 *     or other. This includes, without limitation, warranties of title,
 *     merchantability, fitness for a particular purpose, non-infringement,
 *     absence of latent or other defects, accuracy, or the presence or
 *     absence of errors, whether or not known or discoverable.
 *
 *     To the extent possible, in no event will the creators or distributors
 *     be liable on any legal theory (including, without limitation,
 *     negligence) or otherwise for any direct, special, indirect,
 *     incidental, consequential, punitive, exemplary, or other losses,
 *     costs, expenses, or damages arising out of the use of this software,
 *     even if the creators or distributors have been advised of the
 *     possibility of such losses, costs, expenses, or damages.
 *
 *     The disclaimer of warranties and limitation of liability provided
 *     above shall be interpreted in a manner that, to the extent possible,
 *     most closely approximates an absolute disclaimer and waiver of
 *     all liability.
 *
 */
package dat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.FN;
import util.Util;

/**
 * Read in and store technology data from TECH.DAT.
 *
 * @author joulupunikki <joulupunikki@gmail.communist.invalid>
 */
public class Tech implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // tech name
    public String name;
    // tech index
    public int idx;
    // tech stats
    public int[] stats = new int[7];
    // tech short description
    public String extra;

    /**
     * Parse a line of TECH.DAT.
     *
     * @param s
     * @param file_name
     * @param line_nr
     * @param tech_idx
     * @return
     */
    public static Tech getTech(String s, String file_name, int line_nr, int tech_idx) {

        Tech ret_val = new Tech();

        ret_val.idx = tech_idx;

        Pattern value = Pattern.compile("\"[^\"]*\"");
        Matcher m = value.matcher(s);
        //skip "name"
        Util.testFFErrorAndExit(m.find(), file_name, line_nr);
        //get the name
        Util.testFFErrorAndExit(m.find(), file_name, line_nr);
        ret_val.name = s.substring(m.start() + 1, m.end() - 1);
        //skip "stats"
        Util.testFFErrorAndExit(m.find(), file_name, line_nr);
        //get stats
        Util.testFFErrorAndExit(m.find(), file_name, line_nr);
        //
        String s_stats = s.substring(m.start() + 1, m.end());
        //System.out.println("Here");
        Util.processIntVals(s_stats, ret_val.stats, file_name, line_nr);

        //skip "extra"
        Util.testFFErrorAndExit(m.find(), file_name, line_nr);
        //get extras
        Util.testFFErrorAndExit(m.find(), file_name, line_nr);
        ret_val.extra = s.substring(m.start() + 1, m.end() - 1);

        return ret_val;

    }

    /**
     * Read and parse TECH.DAT.
     *
     * @return Tech[]
     */
    public static Tech[] readTech() {

        String file_name = FN.S_TECH_DAT;
        LinkedList<Tech> tech_list = new LinkedList<>();
        Tech[] techs;
//        int[][] ter_color = new int[C.TER_COLOR_HEX][];
        int line_nr = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(file_name))) {
            String s = in.readLine();
            line_nr++;
            //System.out.println("s = " + s);
            //true if between { and } false if between } and {
            boolean read = false;
            int tech_idx = 0;
//            int terrain_type = 0;
            Pattern mark_begin = Pattern.compile("^\\{");
            Pattern mark_end = Pattern.compile("^\\}");
            Pattern comment = Pattern.compile("^//|^[\\s]*$"); // fix #57

            while (s != null) {
                //System.out.println("s = " + s);
                Matcher matcher = comment.matcher(s);

                //if not comment
                if (!(matcher.find())) {
                    //if between { and }
                    if (read) {
                        matcher = mark_end.matcher(s);
                        // if found } at beginning of line
                        if (matcher.find()) {

                            break;
                            // else read data
                        } else {

                            tech_list.add(getTech(s, file_name, line_nr, tech_idx++));

                        }
                        // else between } and {
                    } else {
                        matcher = mark_begin.matcher(s);
                        // if found { at beginning of line
                        if (matcher.find()) {
                            read = true;
                            // incorrect data file
                        } else {
                            throw new Exception();
                        }
                    }
                }
                s = in.readLine();
                line_nr++;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Failed to read " + file_name);
            Util.logEx(null, e);
            Util.logFFErrorAndExit(file_name, line_nr, e);
            //CrashReporter.showCrashReport(e);
        }

        techs = new Tech[tech_list.size()];
        int i = 0;
        for (Tech tech : tech_list) {
            techs[i++] = tech;
        }
//        printData(unit_spot);
//        System.exit(0);
        return techs;

    }

    /**
     * For debugging purposes.
     *
     * @param techs
     */
    public static void print(Tech[] techs) {
        for (Tech tech : techs) {
            System.out.print("name " + tech.name + ", stats");
            for (int val : tech.stats) {
                System.out.print(" " + val);

            }
            System.out.println("");
            System.out.println("extra " + tech.extra);
        }
    }

}

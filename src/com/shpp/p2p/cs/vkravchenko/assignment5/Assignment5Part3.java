package com.shpp.p2p.cs.vkravchenko.assignment5;

import acm.util.ErrorException;
import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment5Part3 extends TextProgram {

    /* The file containing the names of the articles. */
    private static final String DIC_FILE = "en-dictionary.txt";

    public void run() {
        // read dictionary of file to ArrayList
        ArrayList<String> dictionary = readDicFile();

        while (true) {
            String n = readLine("Enter 3 char:  ");

            formWordOfDic(dictionary, n.toLowerCase());

            println();
        }


    }

    /**
     * @param dictionary  ArrayList dictionary
     * @param s  String of 3 char
     *           This program looks for occurrences of letters in the word, excluding repeated
     *           searches in the word part up to the found letter inclusive.
     */
    private void formWordOfDic(ArrayList<String> dictionary, String s) {
        for (String str : dictionary) {
            int a1, a2;
            if (((a1 = str.indexOf(s.charAt(0))) > -1) &&
                    ((a2 = str.substring(a1 + 1).indexOf(s.charAt(1))) > -1) &&
                    ((str.substring(a2 + 1 + a1 + 1).indexOf(s.charAt(2))) > -1)) {


                print(str + "\t");
            }
        }
        println();
    }


    /**
     * @return dictionary  ArrayList
     *          read dictionary in file to ArrayList
     */
    private ArrayList<String> readDicFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(DIC_FILE));
            ArrayList<String> result = new ArrayList<String>();

            /* Use the standard file-reading loop to  list. */
            while (true) {
                String title = br.readLine();
                if (title == null)
                    break;

                result.add(title);
            }

            br.close();

            /* For reference, let's see how many word there are. */
            println("Read " + result.size() + " words.");
            return result;

        } catch (IOException e) {
            throw new ErrorException(e);
        }
    }
}

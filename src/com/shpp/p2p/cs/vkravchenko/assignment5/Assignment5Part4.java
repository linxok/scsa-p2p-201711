package com.shpp.p2p.cs.vkravchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This program read CSV file, ask column and if it real print him.
 */
public class Assignment5Part4 extends TextProgram {
    private final static String FILENAME = "food-origins.csv";    // filename

    /**
     * ask number column and print it
     */
    public void run() {

        while (true) {  // loop

            int columnIndex = readInt("Enter column index");

            ArrayList<String> column = null;
            try {
                column = extractColumn(FILENAME, columnIndex);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (column != null) { // if not column
                for (String str : column) { // print array string
                    println(str);
                }
            } else println("Out of range column");
        } // loop
    }

    /**
     * @param filename    name and path file
     * @param columnIndex number of column
     * @return array list string of real column else null
     * read CSV file in array List < ArrayList> string and return column
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex) throws IOException {

        ArrayList<String> column = new ArrayList<>();

        ArrayList<ArrayList<String>> fileCSV = readFileCSV(filename);

        for (ArrayList<String> arr : fileCSV) {
            if (arr.size() <= columnIndex) return null;
            column.add(arr.get(columnIndex));
        }
        return column;
    }

    /**
     * @param filename filename
     * @return list<ArrayList> String
     * read CSV file in array List < ArrayList> string
     */
    private ArrayList<ArrayList<String>> readFileCSV(String filename) throws IOException {

        ArrayList<ArrayList<String>> arrayListString = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));

        while (true) {

            String lineStr = br.readLine();

            if (lineStr == null) break;

            arrayListString.add(fieldIn(lineStr));
        }

        br.close();

        return arrayListString;
    }


    /**
     * @param lineStr line String
     * @return ArrayList String
     * parse line string and return ArrayList<String>
     */
    private ArrayList<String> fieldIn(String lineStr) {

        ArrayList<String> strCSV = new ArrayList<>();

        int endStr; // iterator position on string

        while (lineStr.length() > 1) {

            if ((endStr = lineStr.indexOf(",")) > -1) {

                if ((lineStr.charAt(endStr + 1) == '"')) {
                    strCSV.add(lineStr.substring(0, endStr));
                    lineStr = lineStr.substring(endStr + 2);

                    strCSV.add(lineStr.substring(0, lineStr.indexOf('"')));
                    lineStr = lineStr.substring(lineStr.indexOf('"')+2);
                } else {
                    strCSV.add(lineStr.substring(0, endStr));
                    lineStr = lineStr.substring(endStr + 1);
                }
            } else break;
        }

        if (lineStr.length() > 0) strCSV.add(lineStr);  // if string present add him to ArrayList

        return strCSV;

    } //end fieldIn

} // end

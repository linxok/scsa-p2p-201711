package com.shpp.p2p.cs.vkravchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.util.ArrayList;

public class Assignment5Part2 extends TextProgram {
    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number: ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {

        String result = "";                                     // initial string

        ArrayList<Integer> arrayList = new ArrayList<>();       // array list Integer

        int count = 0;

        int c = 0; // transference

        int maxLength = Math.max(n1.length(), n2.length());     // max length string

        while (maxLength - count > 0) {
            int a = 0, b = 0;

            if (n1.length() - count > 0) a = n1.charAt(n1.length() - 1 - count) - '0';

            if (n2.length() - count > 0) b = n2.charAt(n2.length() - 1 - count) - '0';

            c = c + a + b;

            arrayList.add(c % 10);

            c = c / 10;

            count++;
        }
        if (c > 0) arrayList.add(c);

        for (Integer anArrayList : arrayList) {         // of numbers to form a string in reverse order

            result = (char) (anArrayList + '0') + result;
        }

        return result;
    }
}

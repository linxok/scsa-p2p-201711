
package com.shpp.p2p.cs.vkravchenco.consoletest;

import com.shpp.cs.a.console.TextProgram;

public class Assignment2Part1 extends TextProgram {

    public void run() {

        double a = readDouble("Please enter a:");
        double b = readDouble("Please enter b:");
        double c = readDouble("Please enter c:");
        double x1, x2;

        double d = (b * b) - (4 * a * c);                     // Discriminant

        if (d < 0) {                                      // no root
            println("There ar not real root");

        } else if (d == 0) {                               // 1 root
            x1 = -(b / (2 * a));
            println("There ar one root: " + x1);
        } else {                                        // 2 roots
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            println("There ar two roots: " + x1 + " and " + x2);
        }

    }

}



/**
 * Цель: написать консольную программу, которая будет принимать на вход 3 числа типа double (a,b,c), и выдавать корни квадратного уравнения.
 * Если что — вот оно: a*(x^2) + b*x + c = 0
 * К слову, получить квадратный корень числа можно так:
 * double y = Math.sqrt(x)
 * <p>
 * Соответственно, вид программы будет вроде:
 * <p>
 * Please enter a: 1
 * Please enter b: 2
 * Please enter c: 1
 * There is one root: -1.0
 * Please enter a: 1
 * Please enter b: -3
 * Please enter c: -4
 * There are two roots: 4.0 and -1.0
 * Please enter a: 2
 * Please enter b: 4
 * Please enter c: 6
 * There are no real roots
 */


package com.shpp.p2p.cs.vkravchenko.assignment2;

import com.shpp.cs.a.console.TextProgram;

public class Assignment2Part1 extends TextProgram {
    /*
     * solution of the quadratic equation via the discriminant
     * */
    public void run() {
        /*get from user 3 param a, b, c */
        double a = readDouble("Please enter a:");
        double b = readDouble("Please enter b:");
        double c = readDouble("Please enter c:");
        double x1, x2;

        double d = (b * b) - (4 * a * c);                 // Discriminant

        if (d < 0) {                                      // no root
            println("There ar not real root");

        } else if (d == 0) {                              // 1 root
            x1 = -(b / (2 * a));
            println("There ar one root: " + x1);
        } else {                                        // 2 roots
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            println("There ar two roots: " + x1 + " and " + x2);
        }

    }

}
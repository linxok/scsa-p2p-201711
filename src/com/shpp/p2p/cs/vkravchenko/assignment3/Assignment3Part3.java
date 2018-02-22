/**
 * Часть 3 — Возведение в степень
 * Ваша задача — написать метод:
 * <p>
 * private double raiseToPower(double base, int exponent)
 * <p>
 * Этот метод будет принимать два параметра и вычислять значение первого параметра, вознесённого в степень параметра 2.
 * т.е. raiseToPower(2.0, 3) даст 2^3 = 8
 * Второй параметр может быть не только положительным, но и отрицательным.
 * Например 0.5 в степени -2 это 4.
 * Для упрощения вашей жизни будем считать, что всё, что возводится в степень 0, станет 1, т.е. 0 в степени 0 будет 1 :)
 * <p>
 * Т.к. double не умеет хранить в себе бесконечно длинные дробные числа (как мы обсуждали), то при манипуляции с даблами
 * возможны всяческие мелкие погрешности. Это ок.
 * <p>
 * Также, вам не позволено в этой подзадаче использовать Math.pow, Math.exp, Math.log и другие удобные методы из Math,
 * иначе в чем тогда смысл, в написании одного метода, что ли? :)
 */

package com.shpp.p2p.cs.vkravchenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {
    public static final double BASE = -2.0;
    public static final int EXPONENT = 3;

    public void run() {

        double res = raiseToPower(BASE, EXPONENT);

        println("Resultat: " + BASE + "^" + EXPONENT + " = " + res);

    }

    /**
     * @param base     - base number +-(maxDouble)
     * @param exponent - exponent (  in (MinINT) to (MaxINT) )
     * @return double resultat
     * calculate base^+-exponent
     */
    private double raiseToPower(double base, int exponent) {
        double res;
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            exponent *= -1;
            res = 1.0 / mePow(base, exponent);

        } else {
            res = mePow(base, exponent);
        }
        return res;
    }

    /**
     * @param base     - base number +-(maxDouble)
     * @param exponent - exponent (  in 1 to (MaxINT) )
     * @return double resultat
     * calculate base^+exponent
     */
    private double mePow(double base, int exponent) {

        double res = base;
        for (int i = 1; i < exponent; i++) {
            res = res * base;
        }
        return res;
    }

}
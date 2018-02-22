/**
 * Возможно, вы знаете подобную оптическую иллюзию:
 * <p>
 * drawing25
 * <p>
 * Ваша задача — создать такое:
 * Белый прямоугольник, накладывающийся на четыре круга.
 * Программа должна быть гибкой и советуем воспользоваться константами для лёгкого регулирования размера шариков.
 * <p>
 * Рядом с методом run() стоит также поместить такое:
 * <p>
 * public static final int APPLICATION_WIDTH = 300;
 * public static final int APPLICATION_HEIGHT = 300;
 * ... эти директивы позволят вам конфигурировать изначальный приблизительный размер программы, хотя это
 * не отменяет использование getWidth() и getHeight() при её работе.
 */

package com.shpp.p2p.cs.vkravchenko.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram {
    /* This size windows */
    public static final int APPLICATION_WIDTH = 350;
    public static final int APPLICATION_HEIGHT = 350;
    /* Diameter segment */
    public static final double DIAMETER = 100;

    public void run() {
        /* set windows size */
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        double x = getWidth();
        double y = getHeight();

        /* plot oval*/
        ovalPaint(0, 0, DIAMETER);
        ovalPaint(x - DIAMETER, 0, DIAMETER);
        ovalPaint(x - DIAMETER, y - DIAMETER, DIAMETER);
        ovalPaint(0, y - DIAMETER, DIAMETER);

        /* plot rect */
        rectPaint(DIAMETER / 2, DIAMETER / 2, x - DIAMETER, y - DIAMETER);

    }

    /**
     * @param x - upper left x
     * @param y - upper left y
     * @param Width - Width
     * @param Height - Height
     */
    private void rectPaint(double x, double y, double Width, double Height) {
        GRect myRect = new GRect(x, y, Width, Height);
        myRect.setFillColor(Color.WHITE);
        myRect.setFilled(true);
        add(myRect);
    }

    /**
     * @param x - upper left x
     * @param y - upper left y
     * @param diameter - diameter
     */
    private void ovalPaint(double x, double y, double diameter) {
        GOval myOval = new GOval(x, y, diameter, diameter);
        myOval.setFilled(true);
        myOval.setFillColor(Color.BLACK);
        add(myOval);
    }
}


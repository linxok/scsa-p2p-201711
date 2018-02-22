/**
 * Воспользуйтесь GOval и нарисуйте самую фееричную гусеницу в мире. Овалы должны накладываться друг на друга в
 * правильном порядке, иначе будет каша.
 * <p>
 * В этой задаче не нужно пытаться сделать так, чтобы гусеница была отцентрирована в окне или занимала всё его
 * пространство. С другой стороны, вам придётся самим задуматься о константах. И не забудьте прокомментировать их назначение!
 * <p>
 * Цвет кружка должен отличаться от цвета бордюрчика этого кружка. Должна быть возможность легко менять количество сегментов гусеницы.
 * Ну а так — свободное творчество!
 */
package com.shpp.p2p.cs.vkravchenko.assignment2;


import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
/*
 *  This program plot Caterpillar
 */

public class Assignment2Part6 extends WindowProgram {
    /* This size windows */
    private static final int WINDOWS_WIDTH = 500;
    private static final int WINDOWS_HEIGHT = 300;
    /* This number segment  */
    private static final int SEGMENT_CATERPILLAR = 8;
    /* Diameter segment */
    private static final int DIAMETER_SEGMENT = 200;


    public void run() {
        /* set title */
        setTitle("Caterpillar");
        /* set windows size */
        setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);

        boolean countSegment = true;    // switcher

        int y, x;

        for (int i = 0; i < SEGMENT_CATERPILLAR; i++) {

            x = i * (DIAMETER_SEGMENT / 2);

            if (countSegment) {
                y = ((WINDOWS_HEIGHT - DIAMETER_SEGMENT) / 2) + (DIAMETER_SEGMENT / 6) - 35; // offset Y according to the switch
            } else
                y = ((WINDOWS_HEIGHT - DIAMETER_SEGMENT) / 2) - (DIAMETER_SEGMENT / 6) - 35; // 35 is offset up

            countSegment = !countSegment; // switch according upp or down

            paintSegment(x, y);
        }
    }

    /**
     * @param x  real x coordinate
     * @param y  real y coordinate
     */
    private void paintSegment(int x, int y) {
        GOval meOval = new GOval(x, y, DIAMETER_SEGMENT, DIAMETER_SEGMENT);
        meOval.setFilled(true);
        meOval.setFillColor(Color.GREEN);
        meOval.setColor(Color.RED);
        add(meOval);
    }
}



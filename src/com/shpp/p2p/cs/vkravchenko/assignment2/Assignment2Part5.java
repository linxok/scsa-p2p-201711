/**
 * Ну и вот очередная иллюзия.
 * <p>
 * Нужно нарисовать матрицу из чёрных боксов, разделённых "улицами".
 * <p>
 * Вам может казаться, что на перекрёстках есть точечки, но их там нет. Не забудьте отцентрировать рисунок!
 */
package com.shpp.p2p.cs.vkravchenko.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {
    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLS = 9;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The border size of X */
    private static final double BORDER_X_SIZE = 40;

    /* The border size of Y */
    private static final double BORDER_Y_SIZE = 20;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;


    public void run() {
        setTitle("BoxesIllusion");

        /* The set size window tu round all box if possible   */
        setSize((int) (BORDER_X_SIZE * 2 + (NUM_COLS * (BOX_SIZE + BOX_SPACING))),
                (int) (35 + BORDER_Y_SIZE * 2 + (NUM_ROWS * (BOX_SIZE + BOX_SPACING))));


        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {

                paintBox(i, j);
            }
        }

    }

    /**
     * @param i number box in row
     * @param j number box in col
     */
    private void paintBox(int i, int j) {
        /* calculate X, Y in the constant and position box row and col */
        double x = BORDER_X_SIZE + (i * (BOX_SIZE + BOX_SPACING));
        double y = BORDER_Y_SIZE + (j * (BOX_SIZE + BOX_SPACING));

        GRect box = new GRect(x, y, BOX_SIZE, BOX_SIZE);
        box.setFilled(true);
        box.setFillColor(Color.BLACK);
        add(box);
    }
}

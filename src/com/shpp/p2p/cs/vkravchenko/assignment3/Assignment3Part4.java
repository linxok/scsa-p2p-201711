
package com.shpp.p2p.cs.vkravchenko.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part4 extends WindowProgram {

    private static final int BRICK_HEIGHT = 30;
    private static final int BRICK_WIDTH = 30;
    private static final int BRICKS_IN_BASE =8;
    private static final int SET_WINDOWS_WIDTH = (BRICK_WIDTH * BRICKS_IN_BASE + BRICK_WIDTH);
    private static final int SET_WINDOWS_HEIGHT = (BRICK_HEIGHT * BRICKS_IN_BASE + BRICK_HEIGHT);

    public void run() {
        setSize(SET_WINDOWS_WIDTH, SET_WINDOWS_HEIGHT +35);

        buildPiramid();
    }
/**
 * build same piramid
 */
    private void buildPiramid() {

        for (int i = BRICKS_IN_BASE; i >=0 ; i--){          //  calculate line in piramid
            buildLineBlock(i);
        }
    }

    /**
     * @param i  -  how mach block in line
     *           build line of block
     */
    private void buildLineBlock(int i) {
        int yStart = (getHeight() - ((BRICKS_IN_BASE - i) * BRICK_HEIGHT)  );
        int xStart = (getWidth() - (i * BRICK_WIDTH) - BRICK_WIDTH) / 2;
        for (int j = 0; j<= i; j++){                        // calculate number of block
            buildBlock(xStart, yStart, j);
        }
    }

    /**
     * @param xStart - start position of x to build first block
     * @param yStart - start position of y to build line block
     * @param j      - position block in line
     *               build block j position in line
     */
    private void buildBlock(int xStart, int yStart, int j) {
        int x = xStart + (j * BRICK_WIDTH);

        GRect blockInPiramid = new GRect(x,yStart,BRICK_WIDTH,BRICK_HEIGHT);
        blockInPiramid.setFilled(true);
        blockInPiramid.setFillColor(Color.WHITE);
        add(blockInPiramid);
        pause(60);
    }
}
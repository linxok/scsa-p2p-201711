/**
 * Много стран содержат такие вот флаги, которые просто состоят из трех разноцветных полос одинакового размера
 * (горизонтальных или вертикальных). Среди них: Армения, Австрия, Бельгия, Болгария, Чад, Франция, Габон, Германия,
 * Гвинея, Ирлания, Австрия, Италия, Литва, Люксембург, Мали, Нидерланды, Нигерия, Перу, Румыния, Россия, Йемен, ну,
 * и Украина, конечно... шучу :)
 * ... плюс немного других, но в общем, не важно!
 * <p>
 * Ваша задача: написать программу, которая рисует такие флаги. Размеры флага регулируются константами, он должен
 * быть отцентрован посредине окна.
 * Справа внизу должна быть также надпись "Flag of ...". В книге Art and Science of Java вы, возможно, найдете
 * подсказки, как вычислить размер текста, чтобы правильно спозиционировать GLabel.
 */

package com.shpp.p2p.cs.vkravchenko.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {
    /* set windows size */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 600;

    public static final double BORDER = 100;  // Size upp on border

    public void run() {
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);  // set size window


        boolean flagType = true;            // true - vertical arrangement / false -  horizontal location
        String flagName = "France";         // name country of flag
        // upper to down or left to right
        Color flagColor1 = Color.BLUE;      // 1 line color
        Color flagColor2 = Color.WHITE;     // 2 line color
        Color flagColor3 = Color.RED;       // 3 line color

        flagPaint(flagType, flagName, flagColor1, flagColor2, flagColor3);
    }

    /**
     * @param flagType  true - vertical arrangement / false -  horizontal arrangement
     * @param flagName String type of name country
     * @param flagColor1 color 1 line
     * @param flagColor2 color 2 line
     * @param flagColor3 color 3 line
     */
    private void flagPaint(boolean flagType, String flagName, Color flagColor1, Color flagColor2, Color flagColor3) {
        double x = getWidth();
        double y = getHeight();

        double flagSizeX = x - BORDER * 2;  // size same flag
        double flagSizeY = y - BORDER * 2;

        double flagLineSizeX = flagSizeX / 3;  // size line of flag
        double flagLineSizeY = flagSizeY / 3;

        if (flagType) { // true - vertical.

            // draw 1 line of flag
            flagLine(BORDER, BORDER, flagLineSizeX, flagSizeY, flagColor1);
            // draw 2 line of flag
            flagLine(BORDER + flagLineSizeX, BORDER, flagLineSizeX, flagSizeY, flagColor2);
            // draw 3 line of flag
            flagLine(BORDER + flagLineSizeX * 2, BORDER, flagLineSizeX, flagSizeY, flagColor3);

        } else {  // false - horizontal
            // draw 1 line of flag
            flagLine(BORDER, BORDER, flagSizeX, flagLineSizeY, flagColor1);
            // draw 2 line of flag
            flagLine(BORDER, BORDER + flagLineSizeY, flagSizeX, flagLineSizeY, flagColor2);
            // draw 3 line of flag
            flagLine(BORDER, BORDER + flagLineSizeY * 2, flagSizeX, flagLineSizeY, flagColor3);

        }

        GLabel label = new GLabel("Flag of " + flagName); // Set name flag and add ander "Flag of "
        label.setFont("Times-22");  // type of fonts
        label.setLocation(x - label.getWidth(), y - 5); // Set start locations of label
        label.setVisible(true);
        add(label);
    }

    /**
     * @param x real x coordinate upper left
     * @param y real y coordinate upper left
     * @param Width Width
     * @param Height Height
     * @param flagLineColor  Color of one line
     */
    private void flagLine(double x, double y, double Width, double Height, Color flagLineColor) {
        GRect flag = new GRect(x, y, Width, Height);
        flag.setFilled(true);
        flag.setFillColor(flagLineColor);
        add(flag);

    }
}




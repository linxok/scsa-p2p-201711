
package mytemp.arrayList.others;


import acm.graphics.GOval;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part6buble extends WindowProgram {


    private static final int SET_WINDOWS_WIDTH = 880;
    private static final int SET_WINDOWS_HEIGHT = 500;
    private static final int BUBBLE_IN_LINE = 1;
    private static final int MAX_BUBBLE_DIAMETR = 155;
    private static final int PAUSE_TIME  = 1100/48;
    private static final Color BUBBLE_COLOR = Color.BLUE;


    public void run() {

        setSize(SET_WINDOWS_WIDTH, SET_WINDOWS_HEIGHT);

        paintBublePina();
    }

    private void paintBublePina() {
        int xMax = getWidth();
        int yMax = getHeight();

        for (int i = yMax; i >0; i-- )
            for (int j = 0; j <= BUBBLE_IN_LINE; j++){
                paintBubble(i, xMax);
                pause(PAUSE_TIME);
            }
    }

    private void paintBubble(int i , int xMax) {
        RandomGenerator rand = new RandomGenerator();
        double diameter = rand.nextDouble(0, MAX_BUBBLE_DIAMETR);
        GOval myGOval = new GOval(rand.nextDouble(0, xMax ), i, diameter, diameter);
        myGOval.setFilled(true);
        myGOval.setFillColor(Color.WHITE);
        myGOval.setColor(BUBBLE_COLOR);
        myGOval.sendBackward();
        add(myGOval);
    }

}
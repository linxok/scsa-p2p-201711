/**
 * Часть 6 — Пять секунд славы
 * Мы, возможно, еще не рассматривали анимации, но скоро рассмотрим.
 * Ну, а пока что вам задача: написать программу, которая выводит на экран целых 5 секунд какой-либо анимации (не взятой откуда-то, а собственноручно созданной). Это может быть любая анимация на ваш выбор с любым сценарием.
 * <p>
 * пять секунд, не больше и не меньше. В конце нашего курса мы объединим все ваши творения в один клёвый ролик.
 * анимация должна содержать 50 фреймов по крайней мере. Если же у вас 24 фрейма в секунду, то вообще хорошо.
 * Проявите свою креативность!) это — всё, что мы просим.
 */


package com.shpp.p2p.cs.vkravchenko.assignment3;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part6 extends WindowProgram {

    private static final int SET_WINDOWS_WIDTH = 400;   // windows Width
    private static final int SET_WINDOWS_HEIGHT = 400;  // Windows Height
    private static final long LONG_TIME = 5;            // time to work program in second
    private static final double BALL_SIZE = 50;         // Size ball pix.
    private static final double xSpeed = 29;            // speed bal for X
    private static final double ySpeed = 6;             // speed bal for Y
    private static final double PAUSE = 1000 / 25;      // FPS
    private static final Color COLOR_BALL = Color.PINK; // color ball

    // This program paint move ball others time and FPS
    public void run() {

        long startTime = System.currentTimeMillis();  // Time to start this program

        setSize(SET_WINDOWS_WIDTH, SET_WINDOWS_HEIGHT);

        GOval ball = makeBall();                        // create object  ball
        add(ball);                                      // add him to windows
        playBall(ball, startTime);                      // start move ball


    }

    /**
     * @param ball    -  object ball
     * @param startTime - this time to start program
     *                  program move ball and calculate frame and time to run
     */
    private void playBall(GOval ball, long startTime) {
        int frame = 0;                          // calculate frames
        GLabel label = addLabel();              // create label inform FPS, frame and time to run
        add(label);

        // sound beep
        Toolkit tk = Toolkit.getDefaultToolkit();

        double dx = xSpeed;
        double dy = ySpeed;
        long previousTime;
        // run while not end time limit
        while ((System.currentTimeMillis() - startTime) <= LONG_TIME * 1000) {
            previousTime = System.currentTimeMillis();
            pause(PAUSE);  // FPS useless
            // set information label
            label.setLabel("FPS: " + (int) (1000 / ((System.currentTimeMillis() - previousTime))) +
                    "\t  /Frame: " + frame +
                    "\t\t /Time (s): " + ((System.currentTimeMillis() - startTime) / 1000.0));

            ball.move(dx, dy);  // move ball

            frame++;  // calculate frame

            // if ball out in windows range then inverse vector of move
            if (ballInWinX(ball)) {
                dx *= -1;
                tk.beep();      // play sound beep in reverse move
            }
            if (ballInWinY(ball)) {
                dy *= -1;
                tk.beep();      // play sound beep in reverse move
            }
        }
    }

    //    return true if ball out in range windovs for Y
    private boolean ballInWinY(GOval ball) {
        return (((ball.getY() + ball.getHeight()) > getHeight()) || (ball.getY() < 1));
    }
    //    return true if ball out in range windovs for X
    private boolean ballInWinX(GOval ball) {
        return (((ball.getX() + ball.getWidth()) > getWidth()) || (ball.getX() < 1));
    }

    // create label and this position
    private GLabel addLabel() {

        GLabel label = new GLabel("");
        label.setFont("Times-14");
        label.setLocation(5, label.getHeight() + 5);
        label.setVisible(true);

        return label;
    }

    //create object ball
    private GOval makeBall() {
        GOval ball = new GOval(0, 0, BALL_SIZE, BALL_SIZE);
        ball.setFilled(true);
        ball.setColor(COLOR_BALL);
        return ball;
    }
}
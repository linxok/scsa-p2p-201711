package com.shpp.p2p.cs.vkravchenko.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This program is a game whose goal is to knock out blocks with a ball controlled by the mouse
 */
public class Assignment4Part1 extends WindowProgram {
//* Width and height of application window in pixels

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

//* Dimensions of game board (usually the same)

    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

//* Dimensions of the paddle

    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

//* Offset of the paddle up from the bottom

    private static final int PADDLE_Y_OFFSET = 30;

//* Number of bricks per row

    private static final int NBRICKS_PER_ROW = 10;

//* Number of rows of bricks

    private static final int NBRICK_ROWS = 10;

//* Separation between bricks

    private static final int BRICK_SEP = 4;

//* Width of a brick

    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

//* Height of a brick

    private static final int BRICK_HEIGHT = 8;

//* Radius of the ball in pixels

    private static final int BALL_RADIUS = 10;

//* Offset of the top brick row from the top

    private static final int BRICK_Y_OFFSET = 70;

//* Number of turns

    private static final int NTURNS = 3;

    //    Pause bal move
    private static final int FPS_BALL = 1000 / 100;


    @Override
    public void mouseMoved(MouseEvent e) {
//* while mouse move on windows , paddle move too on center position of mouse

        if ((e.getX() < getWidth() - PADDLE_WIDTH / 2) && (e.getX() > PADDLE_WIDTH / 2)) {
            paddle.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
        }
    }

    /**
     * This global variables but need asses in other places
     */
    private GRect paddle = null;
    private GOval ball = null;

    private int brickCounter = NBRICK_ROWS * NBRICKS_PER_ROW; // starting block number
    private double vx = 3, vy = 3;  // delta move

    @Override
    public void run() {
        addMouseListeners();
        drawPaddle();
        drawBall();
        drawBricks();

        for (int i = 0; i < NTURNS; i++) {

            waitForClick();
            getBallVelocity();
            if (playGame()) {
                ball.setVisible(false);
                printWiner();
                break;
            }
        }
        if (brickCounter > 0) printGameOver();
    }

    // print on window "GAME OVER!"
    private void printGameOver() {
        GLabel label = new GLabel("GAME OVER!");
        label.setLocation(getWidth() / 2 - label.getWidth() / 2, getHeight() / 2);
        label.setColor(Color.RED);
        add(label);
    }

    // print on window "YOU Winner!"
    private void printWiner() {
        GLabel label = new GLabel("YOU Winner!");
        label.setLocation(getWidth() / 2 - label.getWidth() / 2, getHeight() / 2);
        label.setColor(Color.GREEN);
        add(label);
    }

    // start move ball and return true if all brick end or false if ball out
    private boolean playGame() {
        while (moveBall()) {
            if (brickCounter <= 0) {
                return true;
            }
        }
        return false;
    }

    //  draw bricks on window for row col and color
    private void drawBricks() {
        double centerX = getWidth() / 2;
        for (int row = 0; row < NBRICK_ROWS; row++) {

            for (int column = 0; column < NBRICKS_PER_ROW; column++) {

                double x = centerX - (NBRICKS_PER_ROW * BRICK_WIDTH) / 2 - ((NBRICKS_PER_ROW - 1) * BRICK_SEP) / 2 +
                        column * BRICK_WIDTH + column * BRICK_SEP;
                double y = BRICK_Y_OFFSET + row * BRICK_HEIGHT + row * BRICK_SEP;

                GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
                add(brick);
                brick.setFilled(true);

                switch (row % 10) {    // color bricks
                    case 0:
                    case 1:
                        brick.setColor(Color.RED);
                        break;

                    case 2:
                    case 3:
                        brick.setColor(Color.ORANGE);
                        break;

                    case 4:
                    case 5:
                        brick.setColor(Color.YELLOW);
                        break;

                    case 6:
                    case 7:
                        brick.setColor(Color.GREEN);
                        break;

                    case 8:
                    case 9:
                        brick.setColor(Color.CYAN);
                        break;

                }
            }
        }
    }

    //  set velocity ball  centre of paddle
    private void getBallVelocity() {

        if (ball != null) {
            ball.setLocation(paddle.getX() + PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS * 2);
            RandomGenerator rand = new RandomGenerator();
            vx = rand.nextDouble(1, 3);
            if (rand.nextBoolean(0.5)) {
                vx *= -1;
            }
            ball.setVisible(true);

        }
    }

    /*  move ball and check out of range or collide other
    //    false - if out of range
    //    true - other
    //    decrement brickCount if collide him
    //    if collide wall or paddle then change direction*/
    private boolean moveBall() {

        GObject collider = getCollidingObject();

        ball.move(vx, vy);
        if (ball.getX() < 0 || ball.getX() > (APPLICATION_WIDTH - BALL_RADIUS * 2)) {
            vx *= -1;
        }
        if (ball.getY() < 0) {
            vy *= -1;
        }
        if (collider == paddle) {
            if (vy > 0) vy *= -1;
        } else if (collider != null) {
            remove(collider);
            brickCounter--;
//            println("brick: " + brickCounter);
            vy = -vy;
        }

        pause(FPS_BALL);

        return !(ball.getY() > (APPLICATION_HEIGHT - BALL_RADIUS * 2));

    }

    // return object if ball colliding him else null
    private GObject getCollidingObject() {
        GObject object;
        if ((object = getElementAt(ball.getX(), ball.getY())) != null) {
            return object;
        } else if ((object = getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY())) != null) {
            return object;
        } else if ((object = getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2)) != null) {
            return object;
        } else if ((object = getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2)) != null) {
            return object;
        }

        return null;
    }

    // create GOval ball set start parameters
    private void drawBall() {
        ball = new GOval(APPLICATION_WIDTH / 2, APPLICATION_HEIGHT / 2, BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        ball.setFillColor(Color.BLACK);
        add(ball);
        ball.setVisible(false);
    }

    // create GRect paddle, set start parameters
    private void drawPaddle() {
        paddle = new GRect(APPLICATION_WIDTH / 2, (APPLICATION_HEIGHT - (PADDLE_Y_OFFSET + PADDLE_HEIGHT)),
                PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        add(paddle);

    }


}

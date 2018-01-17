/**
 * Проблема 4: Шахматная доска
 * В этой задаче Карелу поручили создать "шахматную доску" с помощью биперов в прямоугольном (не квадратном!) мире (финальное положение и направление Карела не важно)
 * <p>
 * Вам явно нужно будет убедиться, что ваш код решает задачи с мирами отличными от 8х8, например, 3х5 и т.д.
 * Важно, чтобы один из поставленных биперов находился в юго-западном углу карты.
 * <p>
 * Карел начинает всегда с юго-западного угла, смотря на восток, + также предполагается, что мир чист от биперов и стен.
 * <p>
 * Не забывайте, что уровни также могут быть 1 квадратик в ширину или наоборот: всего 1 квадратик в высоту.
 * Эту задачу можно решать различными способами, и одни существенно легче чем другие.
 * <p>
 * В принципе, нет ничего страшного в том, что Карел будет ходить по тем дорожкам, где уже ходил — не пытайтесь выдумать какой-то "оптимизированный" алгоритм.
 */


package com.shpp.p2p.cs.vkravchenko;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {

// main run

    public void run() throws Exception {

        buildChesLair();

    }

    //  checks for the last line and starts the process of filling the line and switching to a new one
    private void buildChesLair() throws Exception {

        turnNorth();
        do {

            pickLineBeeper();
            turnNextLine();
        }
        while (frontIsClear());

    }

    //  fills the current line Beepers
    private void pickLineBeeper() throws Exception {
        turnLine();

        while (frontIsClear()) {
            if (beepersPresent()) {
                move();
                if (frontIsClear()) {
                    move();
                    putBeeper();
                }
            } else {
                putBeeper();
                move();
                if (frontIsClear()) {
                    move();
                    putBeeper();
                }
            }
        }


    }

    //  moves to a new line by setting the starting position Karel and Beeper
    private void turnNextLine() throws Exception {
        turnNorth();
        if (frontIsClear()) {

            if (beepersPresent()) {
                move();
                turnLine();
                move();
            } else {

                move();
                putBeeper();
                turnLine();
            }

        }

    }

    //  determines the initial direction of motion
    private void turnLine() throws Exception {
        turnNorth();
        if (leftIsBlocked()) {
            turnRight();
        } else turnLeft();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    private void turnNorth() throws Exception {
        while (notFacingNorth()) {
            turnLeft();
        }
    }

}
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


package com.shpp.p2p.cs.vkravchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    // Precondition: Karel stands on the first street and
    //               the first avenue looking east.
    // Postcondition: Karel created a chessboard and stands
    //                at the last street and the first avenue
    //                looking east.

    public void run() throws Exception {
        while (leftIsClear()){
            putBeeperInLine();
            moveBeck();
            nextLine();
        }
        putBeeperInLine();

    }

    private void nextLine() throws Exception {
        turnRight();
        if (beepersPresent()){
            moveIfClean();
            turnRight();
            moveIfClean();
        } else {
            moveIfClean();
            putBeeper();
            turnRight();
        }
    }

    private void moveBeck() throws Exception {
        turnAround();
        while (frontIsClear()){
            move();
        }
    }

    private void putBeeperInLine() throws Exception {

        while (frontIsClear()){
            if (beepersPresent()){
                moveIfClean();
                moveIfClean();
//                putBeeper();

            } else {
                putBeeper();
                moveIfClean();
                moveIfClean();
                putBeeper();

            }
        }
    }

    private void moveIfClean() throws Exception {
        if (frontIsClear())
            move();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();

    }
}


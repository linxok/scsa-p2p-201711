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

public class BatteryRepair extends KarelTheRobot {

// main run

    public void run() throws Exception {

        while (frontIsClear()){

            cheekAndRepair();

        }
        cheekAndRepair();
        turnRight();
        move();
        turnLeft();

    }

    private void runInLine() throws Exception {
        if (frontIsClear()) {
           move();
        }
    }

    private void beckToLine() throws Exception {
        turnRight();
        move();
        turnLeft();
    }

    private void cheekAndRepair() throws Exception {
        if (noBeepersPresent()){
            if (rightIsClear()) {

                turnRight();
                move();
                repairBlock();
                turnAround();
                move();
                move();
                repairBlock();
                turnRight();
                beckToLine();
            }

        }
        runInLine();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void repairBlock() throws Exception {
        while (beepersPresent()){
            pickBeeper();
        }
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

}
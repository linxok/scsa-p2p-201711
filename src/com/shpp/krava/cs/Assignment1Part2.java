/**
 * Проблема 2 — Ряды камушков
 * Карел был нанят, чтобы выстроить стройные ряды камушков.
 *
 * | xxx xxx xxx |
 * |xx xxx xxx xx|
 * |x   x   x   x|
 * |1       1   1|
 * |1   1        |
 * |        1   1|
 * |    1        |
 * |>   1       1|
 * ...каждый "столб" должен стать цельным и содержать пять(в данном случае) камушков (биперов).
 * Вам стоит учесть, что финальное положение и направление взгляда Карела не важно, но тем не менее, нужно учитывать следующее:
 * 
 * Карел стартует в юго-западном углу и смотрит на восток, и у него полно биперов в рюкзаке;
 * колонны находятся на 1й, 5й, 9й строке и т.д., последняя колонна будет впритык к краю уровня;
 * колонн может быть много, а не 4 как в примере. Может, например, быть всего одна колонна (мир размером 1х8);
 * верх колонны отмечен стеной, но не стоит рассчитывать, что все колонны имеют высоту пять, и не стоит думать, что все колонны имеют одинаковую высоту;
 * нельзя класть биперы там, где они уже лежат.
 */


package com.shpp.krava.cs;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {


    public void run() throws Exception {
        do {

            buildColumn();
            goBeck();
            goNextColumn();
        } while (frontIsClear());
        buildColumn();
    }

    private void goNextColumn() throws Exception {

        move();
        move();
        move();
        move();

    }

    private void goBeck() throws Exception {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    private void buildColumn() throws Exception {
        turnLeft();

        while (frontIsClear()) {
            ifBeepersNotPresentPutIt();
            move();
        }
        ifBeepersNotPresentPutIt();

    }

    private void ifBeepersNotPresentPutIt() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }


}




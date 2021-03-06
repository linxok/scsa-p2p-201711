/**
 * Проблема 2 — Ряды камушков
 * Карел был нанят, чтобы выстроить стройные ряды камушков.
 * <p>
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
 * <p>
 * Карел стартует в юго-западном углу и смотрит на восток, и у него полно биперов в рюкзаке;
 * колонны находятся на 1й, 5й, 9й строке и т.д., последняя колонна будет впритык к краю уровня;
 * колонн может быть много, а не 4 как в примере. Может, например, быть всего одна колонна (мир размером 1х8);
 * верх колонны отмечен стеной, но не стоит рассчитывать, что все колонны имеют высоту пять, и не стоит думать, что все колонны имеют одинаковую высоту;
 * нельзя класть биперы там, где они уже лежат.
 */


package com.shpp.p2p.cs.vkravchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {

    // Precondition: Karel stands on the first street and the
    //               first avenue facing east.
    // Postcondition: Karel has repaired the columns and stands
    //                at the bottom of the last column looking east.

    public void run() throws Exception {

        do {

            moveAndBuildColumn();
        } while (frontIsClear());
        moveAndBuildColumn();

    }

    /*
        decomposition : build column
                        move to the root column
                        move to the next column
     */
    private void moveAndBuildColumn() throws Exception {

        buildColumn();
        moveToTheRootColumn();
        moveToTheNextColumn();


    }

    /*
    move to the next column  if front is clear
     */
    private void moveToTheNextColumn() throws Exception {
        if (frontIsClear()) {
            move();
            move();
            move();
            move();
        }
    }

    /*
    turn around and go to the root column and turn left
     */
    private void moveToTheRootColumn() throws Exception {
        turnLeft();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

    /*
    move in the column and put beeper if it no present
     */
    private void buildColumn() throws Exception {

        turnLeft();
        while (frontIsClear()) {
            ifNoBeepersPutInThis();
            move();
        }
        ifNoBeepersPutInThis();

    }
    /*if beeper not present put it this
    * */
    private void ifNoBeepersPutInThis() throws Exception {
        if (noBeepersPresent())
            putBeeper();
    }
}

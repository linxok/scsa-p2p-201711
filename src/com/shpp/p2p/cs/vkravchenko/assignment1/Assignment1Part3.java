/**
 * Проблема 3 — Нахождение середины
 * Задача на решение алгоритмических проблем: запрограммируйте, пожалуйста, Карела на поиск центра южной полосы (он на ней появляется в самом начале)
 * <p>
 * |     |
 * |     |
 * |     |
 * |     |
 * |> 1  |
 * ... тут единицей отмечено место, куда Карелу нужно будет поставить бипер.
 * Финальный вид уровня должен быть с единственным бипером по центру южной полосы. Карелу можно раскидывать дополнительные биперы, но ему нужно подобрать их перед тем, как он посчитает, что задача решена.
 * В решении проблемы стоит рассчитывать на такие факты про мир:
 * <p>
 * Карел начинает в юго-западном углу и смотрит на восток, у него полно биперов в рюкзаке;
 * в мире нет ни биперов ни стен;
 * мир может не быть квадратным, но он, по крайней мере, настолько высок, насколько широк.
 * Ваша программа, в принципе, может допускать следующее:
 * <p>
 * Если ширина мира нечётная, то Карелу нужно положить бипер в центральную ячейку, иначе же нужно положить в одну из двух центральных ячеек;
 * не важно, куда будет смотреть Карел после того, как он закончит свой забег.
 * Интересный момент задачи: существует дофигища алгоритмов решения этой проблемы, так что советуем вам быть изобретательными и получать удовольствие!
 */


package com.shpp.p2p.cs.vkravchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {


    public void run() throws Exception {

        roadOfBeeper();
        removeBeepers();

    }

    /*
    set Beepers in line
     */
    private void roadOfBeeper() throws Exception {
        while (frontIsClear()) {
            if (noBeepersPresent()) {

                putBeeper();
            }
            move();
        }
        if (noBeepersPresent()) {

            putBeeper();
        }
    }

    /*

     */
    private void removeBeepers() throws Exception {

        firstAndLastBeeperPick();
        nextBeeperPick();


    }

    /*
    find firs and last Beepers and pick it
     */
    private void firstAndLastBeeperPick() throws Exception {

        for (int i = 0; i < 2; i++) {
            turnAround();
            while (frontIsClear()) {
                move();
            }
            pickBeeper();

        }
    }

    private void nextBeeperPick() throws Exception {
        turnAround();
        while (noBeepersPresent()) {
            beeperPicker();
        }

    }

    /*
    move from line Beepers, find last and pick him, if Beeper cancel then put Beeper.
     */
    private void beeperPicker() throws Exception {
        move();
        while (beepersPresent()) {
            move();
        }
        turnAround();
        move();
        if (beepersPresent()) {
            pickBeeper();
        } else {
            putBeeper();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
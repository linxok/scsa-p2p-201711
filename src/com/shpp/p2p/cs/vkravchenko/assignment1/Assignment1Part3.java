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

// Precondition: Karel begins in the south-west corner
//               and looks to the east.
// Postcondition: Karel put a single beeper in the center of the southern street,
//                took one step forward and looks to the west.

public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {

        recursionFindCenter();          // recursion method
        putBeeper();                    // end step put beeper
    }

    // Precondition: Karel stands in the south-west corner
    //               of the street and looks to the east.
    // Postcondition: Karel stands in the center of the street.
    // We use recursion for this method.
    // The condition for the end of recursion: changing true
    // to false in the "if" condition.
    private void recursionFindCenter() throws Exception {
        if (frontIsClear())             //
            if (facingEast()) {         // while Karol face lock in East and front clean

                moveIfClean();          // It is necessary to make exactly half of
                moveIfClean();          // the displacement when you leave the recursion
                if (frontIsBlocked()) {
                    turnAround();       // turn around in the end line
                }

                recursionFindCenter();  // recursion
                moveIfClean();          // After the recursion, make exactly half the displacement
            }
    }

    //    move if front is clean
    private void moveIfClean() throws Exception {
        if (frontIsClear())
            move();
    }

    //  turn Karel around
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
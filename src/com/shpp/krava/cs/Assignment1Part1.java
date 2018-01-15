/**
 *
 *Проблема 1 — Подобрать газетку
 Допустим, Карел живёт в квадратном доме.
 Карел начинает в северо-западном углу своего дома, и ему нужно подобрать газетку, которая лежит на пороге его дома (как в фильмах, ага). Газетка, как и всё в мире Карела — это бипер.
 После подбора газетки нужно вернуться в изначальное положение.

 |         |
 |  xxxxx  |
 |  x>  x  |
 |  x    1 |
 |  x   x  |
 |  xxxxx  |
 |         |
 Эта задача поразительно проста и создана просто, чтобы вы как-то начали что-то делать.
 Вам будет полезно знать, что каждая часть мира выглядит прям как на диаграмме.
 Точно такой размер дома, дверь в той же позиции и бипер прямо за дверью.
 Итак, что вам нужно-то:

 двинуться к газетке
 подобрать её
 вернуться в точку старта
 Даже не смотря на то, что каждая задача — это пара строк, все же стоит немного попрактиковаться в декомпозиции... в вашем решении, метод run должен будет состоять из 3х методов, соответствующих каждому этапу.

 Советуем закончить это задание настолько раньше, насколько это возможно.
 В этом случае, если вы не осилите настройку вашей IDE, у вас будет время это как-то победить (с нашей помощью, например).
 *
 *
 *
 */


package com.shpp.krava.cs;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    /*
    the main logic is to go to the newspaper, take the newspaper, come back.
     */
    public void run() throws Exception {

        goToTheNewspaper();
        takeTheNewspaper();
        backToTheStart();

    }

    /*
    Go to the newspaper
     */
    private void goToTheNewspaper() throws Exception {
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
    }

    /*
    take the newspaper.
     */
    private void takeTheNewspaper() throws Exception {
        pickBeeper();
    }
    /*
    come back.
     */
    private void backToTheStart() throws Exception {
        turnAround();
        move();
        move();
        move();
        move();
        turnRight();
        move();
    }

    /*
    turn in the opposite direction
     */
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*
    Turn the right.
    */
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();

    }





}




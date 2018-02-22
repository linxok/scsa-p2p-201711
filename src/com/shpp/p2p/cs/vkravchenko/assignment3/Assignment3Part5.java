/**
 * Часть 5 — Санкт-Петербургская игра
 * Это гипотетическая игра для казино с простой идеологией.
 * Играют два человека: счастливчик и потеющий.
 * Игра заканчивается, когда первый зарабатывает $20 или больше.
 * Потеющий ложит $1 на стол, а счастливчик начинает подкидывать монетку.
 * Если орёл — то потеющий докладывает к сумме на столе точно такую же сумму.
 * Если решка — всё, что на столе, переходит к счастливчику.
 * Если у счастливчика в итоге меньше $20, то игра повторяется.
 * <p>
 * Теоретически, даже первая игра может привести к тому, что счастливчику вместо 20 привалит сразу $32, $64, ... в зависимости от того, насколько ему будет везти с орлами.
 * <p>
 * Т.е., теоретически, на одной глобальной итерации можно заработать бесконечное количество денег.
 * С другой стороны, может оказаться, что будут часто выпадать решка, и сумма всех побед составит те самые $20 (или около того).
 * <p>
 * Программа должна имитировать подобную игру и выводить на экран следующее:
 * <p>
 * This game, you earned $1
 * Your total is $1
 * This game, you earned $1
 * Your total is $2
 * This game, you earned $1
 * Your total is $3
 * This game, you earned $128
 * Your total is $131
 * It took 4 games to earn $20
 * Впрочем, это нужно быть очень везучим, чтобы добраться до суммы хотя бы $10000 ...
 */

package com.shpp.p2p.cs.vkravchenko.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part5 extends TextProgram {

    private static final int START_BET = 1;
    private static final int SUM_TO_WIN = 20;

/**
 * run method runGame
 * */
    public void run() {

        runGame();
    }

    /**
     * this method start method nextGame and calculate resultat */
    private void runGame() {
        int bank =0;
        int game = 0;
        while (bank < SUM_TO_WIN){
            bank = bank + nextGame(START_BET);
            game++;
            println("Your total is $" + bank);
        }
        println("It took "+ game + " games to earn $"+ SUM_TO_WIN);
    }

    /**
     * @param bet - start bet
     * @return - result local game
     * this method calculate game end return and print result
     */
    private int nextGame(int bet) {

        RandomGenerator random = new RandomGenerator();

        while (random.nextBoolean() ){
            bet += bet;
        }
        println("This game, you earned $"+bet);
        return bet;
    }
}
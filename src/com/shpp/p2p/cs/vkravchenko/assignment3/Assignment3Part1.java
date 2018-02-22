/**
 * Медики рекомендуют 30 минут занятий аэробики пять дней в неделю (тут было написано: с пн по пт, но в общем мой план
 * провалился) для поддержания своего кардиоваскулярного здоровья. Более того, хотя бы 40 минут три раза в неделю для
 * поддержания низкого кровяного давления. Ваша задача: написать программу, которая спрашивает у пользователя количество
 * минут, потраченных последние семь дней на упражнения, и соответственно, репортит следующее:
 * <p>
 * было ли достаточно времени уделено упражнениям для кардиоваскулярного здоровья, и, если нет, выводит: сколько дней
 * правильной жизни (с занятиями больше 30 минут) не хватает для рекомендуемого графика.
 * было ли достаточно упражнений для уменьшения кровяного давления и холестерина, и, если нет, выводит: сколько дней они
 * недотянули с занятиями по 40 минут в день.
 */

package com.shpp.p2p.cs.vkravchenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part1 extends TextProgram {

    private static final int CARDIOVACULAR_HEALT_MIN = 30;   // minimum minuts for cardiovacular healt
    private static final int CARDIOVACULAR_HEALT_DO = 5;     // minimum days of weak for cardiovacular healt
    private static final int BLOOD_PRESSURE_MIN = 40;        // minimum minuts for blood pressure
    private static final int BLOOD_PRESSURE_DO = 3;          // minimum days of weak for blood pressure

    /**
     * this program ask how meny minets did you du on day and calculate
     * done enough exercise to keep blood and cardio train
     */
    public void run() {
        try {               // catch exception input error

            int cardio = 0;
            int blood = 0;

            for (int i = 1; i <= 7; i++) {
                int minutsDo = readInt("How many minutes did you do on day " + i + "? ");
                if (minutsDo >= BLOOD_PRESSURE_MIN) {
                    blood++;
                }
                if (minutsDo >= CARDIOVACULAR_HEALT_MIN) {
                    cardio++;
                }
            }
            cardioAndBlood(blood, cardio);   // analise done enough or needed to train hard ...

        } catch (Exception e) {
            println("Enter number. Exception - " + e);
        }
    }

    /**
     * @param blood  - how mani day full train blood
     * @param cardio - how mani day full train cardio
     *               <p>
     *               analise done enough or needed to train hard ...
     */
    private void cardioAndBlood(int blood, int cardio) {

        println("\nCardiovacular health:");

        if (CARDIOVACULAR_HEALT_DO <= cardio) {
            println("\tGreat job! You've done enough exercise for cardiovacular health.");
        } else {
            println("\tYou needed to train hard for at least " + (CARDIOVACULAR_HEALT_DO - cardio) + " more day(s) a week!");
        }

        println("Blood pressure:");
        if (blood >= BLOOD_PRESSURE_DO) {
            println("\tGreat job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println("\tYou needed to train hard for at least " + (BLOOD_PRESSURE_DO - blood) + " more day(s) a week!");
        }
    }
}
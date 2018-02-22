package com.shpp.cs.a.lectures.lec09;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class BirthdaysParadox extends TextProgram {

    @Override
    public void run() {
        RandomGenerator r = RandomGenerator.getInstance();
        int count =0;
        for (int i =0;i < 100000; i++) {

            int[] days = new int[365];

            int skolko = 0;

            boolean found = false;
            while (!found) {
                int day = r.nextInt(365);
                skolko++;
                if (days[day] != 2) {
                    days[day]++;
                } else {
                    found = true;
                }
            }
            println("skolko? haha: "+skolko);
            count= count +skolko;
        }

        println("skolko? haha: "+count / 100000);

    }


}

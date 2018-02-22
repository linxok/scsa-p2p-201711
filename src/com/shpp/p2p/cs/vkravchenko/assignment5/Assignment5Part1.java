package com.shpp.p2p.cs.vkravchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part1 extends TextProgram {

    private static final String VOWELS = "aeiouy";

    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
              println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesIn(String word) {

        word = word.toLowerCase();                          // transform word in lower case
        int syllables = 0;                                   // count of syllable
        for (int i = 0; i < word.length(); i++) {

            if (findSyllables(word.charAt(i))) {
                if (i > 0 && findSyllables(word.charAt(i - 1))) {   // if previous char is vowels
                    continue;
                }
                syllables++;
            }
        }

        if ((word.charAt(word.length() - 1) == 'e') && !findSyllables(word.charAt(word.length() - 2))) {  // if end char 'e' but not previous char vowels
            syllables--;
        }
        if (syllables <= 0) syllables = 1;    // minimum syllables is 1

        return syllables;
    }

    /**
     * return true if char c vowels
     */
    private boolean findSyllables(char c) {

        return (VOWELS.indexOf(c) > -1);
    }
}

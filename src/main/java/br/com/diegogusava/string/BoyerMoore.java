package br.com.diegogusava.string;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

    public static int search(String pattern, String text) {
        Map<Character, Integer> table = new HashMap<>();


        int lenPattern = pattern.length();
        int lenText = text.length();

        for (int i = 0; i < pattern.length(); i++) {
            final char c = pattern.charAt(i);
            int maxShift = Math.max(1, lenPattern - i - 1);
            table.put(c, maxShift);
        }

        int numSkips = 0;

        for (int i = 0; i <= lenText - lenPattern; i+= numSkips) {

            numSkips = 0;

            for(int j = lenPattern - 1; j>= 0; j--) {

                if (pattern.charAt(j) != text.charAt(i + j)) {

                    final Integer skipsPattern = table.get(pattern.charAt(j));

                    if (skipsPattern != null) {
                        numSkips = skipsPattern;
                        break;
                    } else {
                        numSkips = lenPattern;
                        break;
                    }

                }

            }

            if (numSkips == 0) {
                return i;
            }

        }


        return lenText;
    }

}

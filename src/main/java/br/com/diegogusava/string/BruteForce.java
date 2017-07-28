package br.com.diegogusava.string;

public class BruteForce {

    public static int search(String pattern, String text) {

        int lenPattern = pattern.length();
        int lenText = pattern.length();

        for (int i = 0; i < lenText - lenPattern; i++) {

            int j;

            for (j = 0; j <= lenPattern; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == lenPattern) {
                return i;
            }

        }

        return lenText;


    }

}

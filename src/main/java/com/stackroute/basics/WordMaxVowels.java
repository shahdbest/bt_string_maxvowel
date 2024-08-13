package com.stackroute.basics;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WordMaxVowels {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        WordMaxVowels wordMaxVowels = new WordMaxVowels();

        String input = wordMaxVowels.getInput();

        int result = wordMaxVowels.getMaximumVowelsCount(input);

        wordMaxVowels.displayResult(result);

        wordMaxVowels.closeScanner();
    }


    public String getInput() {
        return scanner.nextLine().trim();
    }

    public void displayResult(int result) {
        if (result == -1) {
            System.out.println("Empty or null string");
        } else if (result == 0) {
            System.out.println("No vowels");
        } else {
            System.out.println("Maximum number of vowels:" + result);
        }
    }

    public int getMaximumVowelsCount(String input) {

        /*
        Return -1 if the string is empty or null
         */
        if (input == null || input.equals("")) {
            return -1;
        }

        int i = 0;
        StringTokenizer tokens = new StringTokenizer(input, " ");
        int length = 0;
        int count = 0;
        int maxCount = 0;

        while (tokens.hasMoreTokens()) {
            String testString = tokens.nextToken();
            length = testString.length();
            count = 0;
            for (i = 0; i < length; i++) {
                if (testString.charAt(i) == 'a' || testString.charAt(i) == 'e' || testString.charAt(i) == 'i' || testString.charAt(i) == 'o' || testString.charAt(i) == 'u'
                        || testString.charAt(i) == 'A' || testString.charAt(i) == 'E' || testString.charAt(i) == 'I' || testString.charAt(i) == 'O' || testString.charAt(i) == 'U')
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public void closeScanner() {
        scanner.close();
    }
}

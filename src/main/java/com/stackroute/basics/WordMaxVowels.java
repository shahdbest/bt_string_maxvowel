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

    }

    public void displayResult(int result) {
 }

    public int getMaximumVowelsCount(String input) {
        return 0;
    }

    public void closeScanner() {
	
    }
}

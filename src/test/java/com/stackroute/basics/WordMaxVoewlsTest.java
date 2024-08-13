package com.stackroute.basics;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;
public class WordMaxVoewlsTest {


    // Test for the method getMaximumVowelsCount with various inputs
    @Test
    void testGetMaximumVowelsCountWithValidInput() {
        WordMaxVowels wordMaxVowels = new WordMaxVowels();

        assertEquals(-1, wordMaxVowels.getMaximumVowelsCount(null));
        assertEquals(-1, wordMaxVowels.getMaximumVowelsCount(""));
        assertEquals(3, wordMaxVowels.getMaximumVowelsCount("hello world"));
        assertEquals(4, wordMaxVowels.getMaximumVowelsCount("aeiou AEIOU"));
        assertEquals(2, wordMaxVowels.getMaximumVowelsCount("word beep"));
        assertEquals(2, wordMaxVowels.getMaximumVowelsCount("look at the moon"));
        assertEquals(0, wordMaxVowels.getMaximumVowelsCount("bcd fgh"));
    }

    // Test for the method displayResult to capture printed output
    @Test
    void testDisplayResult() {
        WordMaxVowels wordMaxVowels = new WordMaxVowels();

        // Capture the output of displayResult method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        wordMaxVowels.displayResult(-1);
        assertEquals("Empty or null string\n", outputStream.toString());

        outputStream.reset();
        wordMaxVowels.displayResult(0);
        assertEquals("No vowels\n", outputStream.toString());

        outputStream.reset();
        wordMaxVowels.displayResult(3);
        assertEquals("Maximum number of vowels:3\n", outputStream.toString());

        // Reset System.out
        System.setOut(originalOut);
    }

    // Test for the method closeScanner to ensure it does not throw exceptions
    @Test
    void testCloseScanner() {
        WordMaxVowels wordMaxVowels = new WordMaxVowels();
        assertDoesNotThrow(wordMaxVowels::closeScanner);
    }

    // Testing the main method indirectly
    @Test
    void testMain() {
        // Mocking the System.in to simulate user input
        String input = "hello world";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture the output of the main method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        WordMaxVowels.main(new String[]{});

        // Validate the output
        String expectedOutput = "Maximum number of vowels:3\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out and System.in
        System.setOut(originalOut);
        System.setIn(System.in);
    }
}

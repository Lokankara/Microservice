package com.stack.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(LoggerExtension.class)
class TesterTest {

    @RegisterExtension
    public LoggerExtension loggerExtension = new LoggerExtension();
    private final Tester tester = new Tester();
    private List<String> messages;

    @BeforeEach
    public void setup() {
        messages = loggerExtension.getFormattedMessages();
    }

    @Test
    void testPrintCommonElement() {
        int[] array1 = {2, 2, 3, 4, 5};
        int[] array2 = {2, -3, 0, 5, 5, 5};
        int[] array = {2, 5};
        tester.printCommonElements(array1, array2);
        List<String> messages = loggerExtension.getFormattedMessages();
        IntStream.range(0, messages.size()).forEach(
                i -> assertEquals(String.valueOf(array[i]), messages.get(i)));
    }

    @Test
    void testVerifyEqualsString() {
        tester.verifyEquals("hello", "hello");
        tester.verifyEquals("hello", "world");
        messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains("Passed"));
        assertTrue(messages.get(1).contains("Failed"));
    }

    @Test
    void testVerifyEqualsInt() {
        tester.verifyEquals(5, 5);
        tester.verifyEquals(5, 3);
        messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains("Passed"));
        assertTrue(messages.get(1).contains("Failed"));
    }

    @Test
    void testVerifyEqualsDouble() {
        tester.verifyEquals(3.14, 3.14);
        tester.verifyEquals(3.14, 2.71);
        messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains("Passed"));
        assertTrue(messages.get(1).contains("Failed"));
    }

    @Test
    void testVerifyEqualsStringArray() {
        tester.verifyEquals(new String[]{"a", "b", "c"},
                            new String[]{"a", "b", "c"});
        tester.verifyEquals(new String[]{"a", "b", "c"},
                            new String[]{"x", "y", "z"});
        messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains("Passed"));
        assertTrue(messages.get(1).contains("Failed"));
    }

    @Test
    void testVerifyEqualsDoubleArray() {
        double[] expectedResult = {1.1, 2.2, 3.3};
        double[] actualResult = {1.1, 2.2, 3.3};
        tester.verifyEquals(actualResult, expectedResult);
        List<String> messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.contains("double[]: Passed"));
    }

    @Test
    void testPrintPositiveNumber() {
        int number = 90;
        tester.printPositiveNumbers(number);
        List<String> messages = loggerExtension.getFormattedMessages();
        for (int i = number; i <= 100; i++) {
            assertTrue(messages.get(0).contains(String.valueOf(i)));
        }
    }

    @Test
    void testPrintNumbersInRanges() {
        int number1 = 2;
        int number2 = 5;
        int[] expectedResult = {2, 3, 4, 5};
        tester.printNumbersInRange(number1, number2);
        List<String> messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains(Arrays.toString(expectedResult)));
    }

    @Test
    void testPrintNumberSequences() {
        tester.printNumberSequence();
        List<String> messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains("number 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10"));
    }

    @Test
    void testPrintMultiplicationTables() {
        int number = 4;
        String expectedMessage = "4 * 1 = 4, 4 * 2 = 8, 4 * 3 = 12, 4 * 4 = 16, 4 * 5 = 20, 4 * 6 = 24, 4 * 7 = 28, 4 * 8 = 32, 4 * 9 = 36, 4 * 10 = 40";
        tester.printMultiplicationTable(number);
        String[] messages = loggerExtension.getFormattedMessages()
                                           .toArray(new String[0]);
        String[] expectedExpressions = expectedMessage.split(", ");
        assertEquals(Arrays.toString(expectedExpressions),
                     Arrays.toString(messages));
    }

    @Test
    void testPrintArrayStatuses() {
        int[] array = {2, -3, 0, 5};
        tester.printArrayStatus(array);
        List<String> messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.contains("Positive"));
        assertTrue(messages.contains("Negative"));
        assertTrue(messages.contains("Zero"));
    }

    @Test
    void testPrintCommonElements() {
        int[] array1 = {2, 3, 4, 5};
        int[] array2 = {2, -3, 0, 5};
        String[] expectedResult = {"2", "5"};
        tester.printCommonElements(array1, array2);
        String[] messages = loggerExtension.getFormattedMessages()
                                           .toArray(new String[0]);
        assertArrayEquals(expectedResult, messages);
    }

    @Test
    void testVerifyEqualsIntArray() {
        int[] expectedResult = {1, 2, 3};
        int[] actualResult = {1, 2, 3};
        tester.verifyEquals(actualResult, expectedResult);
        List<String> messages = loggerExtension.getFormattedMessages();
        assertTrue(messages.get(0).contains("int[]: Passed"));
    }
}

package com.stack.oop;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Tester {

    public void verifyEquals(
            int actualResult,
            int expectedResult) {
        String result = actualResult == expectedResult
                        ? "int: Passed"
                        : "int: Failed";
        log.info(result);
    }

    public void verifyEquals(
            String actualResult,
            String expectedResult) {
        String result = actualResult.equals(expectedResult)
                        ? "String: Passed"
                        : "String: Failed";
        log.info(result);
    }

    public void verifyEquals(
            double actualResult,
            double expectedResult) {
        String result = Double.compare(actualResult, expectedResult) == 0
                        ? "double: Passed"
                        : "double: Failed";
        log.info(result);
    }

    public void verifyEquals(
            String[] actualResult,
            String[] expectedResult) {
        String result = Arrays.equals(actualResult, expectedResult)
                        ? "String[]: Passed"
                        : "String[]: Failed";
        log.info(result);
    }

    public void verifyEquals(
            int[] actualResult,
            int[] expectedResult) {
        String result = Arrays.equals(actualResult, expectedResult)
                        ? "int[]: Passed"
                        : "int[]: Failed";
        log.info(result);
    }

    public void verifyEquals(
            double[] actualResult,
            double[] expectedResult) {
        String result = Arrays.equals(actualResult, expectedResult)
                        ? "double[]: Passed"
                        : "double[]: Failed";
        log.info(result);
    }

    public void printPositiveNumbers(int number) {
        int size = 101 - number;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int num = i + number;
            if (0 < num) {
                result[i] = num;
            }
        }
        log.info(Arrays.toString(result));
    }


    public void printNumbersInRange(
            int number1,
            int number2) {
        int[] numbers = new int[number2 - number1 + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = number1 + i;
        }
        log.info(Arrays.toString(numbers));
    }

    public void printNumberSequence() {
        StringBuilder sequence = new StringBuilder("number ");
        for (int i = 0; i <= 10; i++) {
            sequence.append(i);
            if (i != 10) {
                sequence.append(", ");
            }
        }
        log.info(sequence.toString());
    }

    public void printMultiplicationTable(int number) {
        for (int i = 1; i <= 10; i++) {
            log.info("{} * {} = {}", number, i, number * i);
        }
    }

    public void printArrayStatus(int[] array) {
        for (int value : array) {
            if (value > 0) {
                log.info("Positive");
            } else if (value < 0) {
                log.info("Negative");
            } else {
                log.info("Zero");
            }
        }
    }

    public void printCommonElements(int[] array1, int[] array2) {
        for (int row : array1) {
            for (int col = 0; col < array2.length; col++) {
                if (row == array2[col]) {
                    log.info(String.valueOf(row));
                    array2[col] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }
}

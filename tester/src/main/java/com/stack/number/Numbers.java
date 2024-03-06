package com.stack.number;

import java.util.Arrays;

public class Numbers {

    private Numbers() {
    }

    private static void isValid(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
    }

    public static double findMedian(int[] numbers) {
        isValid(numbers);
        Arrays.sort(numbers);
        int n = numbers.length;
        return n % 2 == 0
                 ? (numbers[n / 2] + numbers[n / 2 - 1]) / 2.0
                 : numbers[n / 2];
    }
}

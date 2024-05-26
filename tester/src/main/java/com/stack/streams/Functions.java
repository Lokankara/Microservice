package com.stack.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Functions {

    public double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .parallel()
                      .mapToDouble(Integer::doubleValue)
                      .average()
                      .orElse(0);
    }

    public List<String> convertToUpperCase(List<String> strings) {
        return strings.stream()
                      .map(String::toUpperCase)
                      .toList();
    }

    public int sumOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(num -> num % 2 != 0)
                      .mapToInt(i -> i)
                      .sum();
    }

    public List<String> sortStringsReverse(
            List<String> strings) {
        return strings.stream()
                      .sorted(Comparator.reverseOrder())
                      .toList();
    }

    public Integer findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                      .sorted(Comparator.reverseOrder())
                      .skip(1)
                      .findFirst()
                      .orElse(null);
    }

    public int findMinimum(List<Integer> numbers) {
        return numbers.stream()
                      .min(Integer::compareTo)
                      .orElse(0);
    }

    public int findMaximum(List<Integer> numbers) {
        return numbers.stream()
                      .max(Integer::compareTo)
                      .orElse(0);
    }

    public int findSum(List<Integer> numbers) {
        return numbers.stream()
                      .mapToInt(Integer::intValue)
                      .sum();
    }

    public IntSummaryStatistics findStatistics(
            List<Integer> numbers) {
        return numbers.stream()
                      .mapToInt(Integer::intValue)
                      .summaryStatistics();
    }

    public int[] duplicateArray(int[] input) {
        return Arrays.stream(input)
                     .flatMap(num -> IntStream.of(num, num))
                     .toArray();
    }

    public List<Integer> filterZero(List<Integer> digits) {
        return digits.stream()
                     .filter(digit -> digit == 0)
                     .toList();
    }
}

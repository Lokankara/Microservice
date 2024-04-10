package com.stack.streams;

import java.util.Comparator;
import java.util.List;

public class Digits {

    public double findAverage(List<Integer> numbers) {
        return numbers.stream()
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
                      .mapToInt(Integer::intValue)
                      .sum();
    }

    public List<String> sortReverse(List<String> strings) {
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

    public double findAverage2(List<Integer> numbers) {
        return numbers.stream()
                      .mapToDouble(Integer::doubleValue)
                      .average()
                      .orElse(0);
    }
}

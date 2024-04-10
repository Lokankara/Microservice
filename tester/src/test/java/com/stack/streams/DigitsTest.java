package com.stack.streams;

import com.stack.streams.providers.Average2ArgumentsProvider;
import com.stack.streams.providers.AverageArgumentsProvider;
import com.stack.streams.providers.MaximumArgumentsProvider;
import com.stack.streams.providers.MinimumArgumentsProvider;
import com.stack.streams.providers.SecondLargestArgumentsProvider;
import com.stack.streams.providers.SortReverseArgumentsProvider;
import com.stack.streams.providers.SumArgumentsProvider;
import com.stack.streams.providers.SumOfOddNumbersArgumentsProvider;
import com.stack.streams.providers.UpperCaseArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitsTest {

    private Digits digits;

    @BeforeEach
    public void setup() {
        digits = new Digits();
    }

    @ParameterizedTest
    @ArgumentsSource(AverageArgumentsProvider.class)
    void testFindAverage(List<Integer> numbers, double expected) {
        assertEquals(expected, digits.findAverage(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(UpperCaseArgumentsProvider.class)
    void testConvertToUpperCase(List<String> strings, List<String> expected) {
        assertEquals(expected, digits.convertToUpperCase(strings));
    }

    @ParameterizedTest
    @ArgumentsSource(SumOfOddNumbersArgumentsProvider.class)
    void testSumOfOddNumbers(List<Integer> numbers, int expected) {
        assertEquals(expected, digits.sumOfOddNumbers(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(SortReverseArgumentsProvider.class)
    void testSortReverse(List<String> strings, List<String> expected) {
        assertEquals(expected, digits.sortReverse(strings));
    }

    @ParameterizedTest
    @ArgumentsSource(SecondLargestArgumentsProvider.class)
    void testFindSecondLargest(List<Integer> numbers, int expected) {
        assertEquals(expected, digits.findSecondLargest(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(MinimumArgumentsProvider.class)
    void testFindMinimum(List<Integer> numbers, int expected) {
        assertEquals(expected, digits.findMinimum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(MaximumArgumentsProvider.class)
    void testFindMaximum(List<Integer> numbers, int expected) {
        assertEquals(expected, digits.findMaximum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(SumArgumentsProvider.class)
    void testFindSum(List<Integer> numbers, int expected) {
        assertEquals(expected, digits.findSum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(Average2ArgumentsProvider.class)
    void testFindAverage2(List<Integer> numbers, double expected) {
        assertEquals(expected, digits.findAverage2(numbers));
    }
}

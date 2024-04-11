package com.stack.streams;

import com.stack.streams.providers.AverageArgumentsProvider;
import com.stack.streams.providers.DuplicateArrayProvider;
import com.stack.streams.providers.MaximumArgumentsProvider;
import com.stack.streams.providers.MinimumArgumentsProvider;
import com.stack.streams.providers.SecondLargestArgumentsProvider;
import com.stack.streams.providers.SortReverseArgumentsProvider;
import com.stack.streams.providers.StatisticsArgumentsProvider;
import com.stack.streams.providers.SumArgumentsProvider;
import com.stack.streams.providers.SumOfOddNumbersArgumentsProvider;
import com.stack.streams.providers.UpperCaseArgumentsProvider;
import com.stack.streams.providers.ZeroDigitsArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTest {

    private Functions functions;

    @BeforeEach
    public void setup() {
        functions = new Functions();
    }

    @ParameterizedTest
    @ArgumentsSource(AverageArgumentsProvider.class)
    void testFindAverage(List<Integer> numbers, double expected) {
        assertEquals(expected, functions.findAverage(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(UpperCaseArgumentsProvider.class)
    void testConvertToUpperCase(List<String> strings, List<String> expected) {
        assertEquals(expected, functions.convertToUpperCase(strings));
    }

    @ParameterizedTest
    @ArgumentsSource(SumOfOddNumbersArgumentsProvider.class)
    void testSumOfOddNumbers(List<Integer> numbers, int expected) {
        assertEquals(expected, functions.sumOfOddNumbers(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(SortReverseArgumentsProvider.class)
    void testSortReverse(List<String> strings, List<String> expected) {
        assertEquals(expected, functions.sortStringsReverse(strings));
    }

    @ParameterizedTest
    @ArgumentsSource(SecondLargestArgumentsProvider.class)
    void testFindSecondLargest(List<Integer> numbers, int expected) {
        assertEquals(expected, functions.findSecondLargest(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(MinimumArgumentsProvider.class)
    void testFindMinimum(List<Integer> numbers, int expected) {
        assertEquals(expected, functions.findMinimum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(MaximumArgumentsProvider.class)
    void testFindMaximum(List<Integer> numbers, int expected) {
        assertEquals(expected, functions.findMaximum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(SumArgumentsProvider.class)
    void testFindSum(List<Integer> numbers, int expected) {
        assertEquals(expected, functions.findSum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(StatisticsArgumentsProvider.class)
    void testFindArgMinMax(
            List<Integer> numbers, double expectedAvg,
            int expectedMin, int expectedMax) {
        assertEquals(expectedAvg, functions.findAverage(numbers));
        assertEquals(expectedMin, functions.findMinimum(numbers));
        assertEquals(expectedMax, functions.findMaximum(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(StatisticsArgumentsProvider.class)
    void testFindStatistics(
            List<Integer> numbers, double expectedAvg,
            int expectedMin, int expectedMax) {
        double averageActual = functions.findStatistics(numbers).getAverage();
        int maxActual = functions.findStatistics(numbers).getMax();
        int minActual = functions.findStatistics(numbers).getMin();
        assertEquals(expectedAvg, averageActual);
        assertEquals(expectedMin, minActual);
        assertEquals(expectedMax, maxActual);
    }

    @ParameterizedTest
    @ArgumentsSource(DuplicateArrayProvider.class)
    void testDuplicateArray(int[] inputArray, int[] expectedArray) {
        int[] duplicatedArray = functions.duplicateArray(inputArray);
        assertArrayEquals(expectedArray, duplicatedArray);
    }

    @ParameterizedTest
    @ArgumentsSource(ZeroDigitsArgumentsProvider.class)
    void testFilterZero(List<Integer> inputDigits, List<Integer> expectedFiltered) {
        List<Integer> filteredSet = functions.filterZero(inputDigits);
        assertEquals(expectedFiltered, filteredSet);
    }
}

package com.stack.kata;

import com.stack.kata.provider.BuildArrayFromPermutation;
import com.stack.kata.provider.ConcatenationArrayProvider;
import com.stack.kata.provider.SmallerNumbersThanCurrentArrayProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationTest {

    private Permutation permutation;

    @BeforeEach
    public void setup() {
        permutation = new Permutation();
    }

    @AfterEach
    public void tearDown() {
        permutation = null;
    }

    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    @DisplayName("Test Build Array from Permutation")
    @ArgumentsSource(BuildArrayFromPermutation.class)
    void testBuildArrayFromPermutation(int[] nums, int[] expected) {
        assertArrayEquals(expected, permutation.buildArray(nums));
    }

    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    @DisplayName("Test Concatenation of Array")
    @ArgumentsSource(ConcatenationArrayProvider.class)
    void testConcatenationArray(int[] nums, int[] expected) {
        int[] actual = permutation.concatenateArray(nums);
        assertArrayEquals(expected, actual);
        assertEquals(nums.length * 2, actual.length);
    }

    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    @DisplayName("Test smallerNumbersThanCurrent of Array")
    @ArgumentsSource(SmallerNumbersThanCurrentArrayProvider.class)
    void testSmallerNumbersThanCurrent(int[] nums, int[] expected) {
        assertArrayEquals(expected, permutation.smallerNumbersThanCurrent(nums));
    }
}

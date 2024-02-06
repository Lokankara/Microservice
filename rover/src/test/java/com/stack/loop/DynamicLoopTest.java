package com.stack.loop;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DynamicLoopTest {

    @ParameterizedTest(name = "start:{0}, end:{1}, step:{2}, expected:{3}")
    @ArgumentsSource(MultiArguments.class)
    void testMultiplicity(int start, int end, int step, String[] expected) {
        String[] actual = new DynamicLoop().multiplicityTask(start, end, step);
        checkArrays(expected, actual);
    }

    @ParameterizedTest(name = "start:{0}, end:{1}, step:{2}, expected:{3}")
    @ArgumentsSource(MultiArguments.class)
    void testHomeworkMultiplicity(int start, int end, int step, String[] expected) {
        String[] actual = new DynamicLoop().multiplicity(start, end, step);
        checkArrays(expected, actual);
    }

    private void checkArrays(
            String[] expected,
            String[] actual) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(String.format(
                    "Arrays differ: expected %s but was %s",
                    Arrays.toString(expected),
                    Arrays.toString(actual)));
        } else {
            assertArrayEquals(actual, expected);
        }
    }
}

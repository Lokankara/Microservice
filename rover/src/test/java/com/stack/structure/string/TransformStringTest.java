package com.stack.structure.string;

import com.stack.structure.string.provider.CharExtractorArgumentsProvider;
import com.stack.structure.string.provider.LetterCounterArgumentsProvider;
import com.stack.structure.string.provider.SubstringIndexFinderArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TransformStringTest {
    TransformString transform;
    @BeforeEach
    public void setUp() {
        transform = new TransformString();
    }

    @ParameterizedTest
    @ArgumentsSource(CharExtractorArgumentsProvider.class)
    void testPermutation(char c, String input, String expected) {
        String actual = transform.permutation(input, c);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(LetterCounterArgumentsProvider.class)
    void testCountLetter(char letter, String input, int expectedCount) {
        assertEquals(expectedCount, transform.countLetters(input, letter));
    }

    @ParameterizedTest
    @ArgumentsSource(SubstringIndexFinderArgumentsProvider.class)
    void testFindIndexes(String input, String substring, int[] expectedIndexes) {
        assertArrayEquals(expectedIndexes, transform.findIndexes(input, substring));
    }
}

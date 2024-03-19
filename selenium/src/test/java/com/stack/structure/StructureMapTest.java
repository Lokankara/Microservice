package com.stack.structure;

import com.stack.e2e.WordsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StructureMapTest {

    @ParameterizedTest
    @ArgumentsSource(WordsProvider.class)
    void testGetLongestWordsByLetters(
            List<String> words, Map<Character, String> expected) {
        Map<Character, String> result = StructureMap.getLongestWordsByLetters(words);
        assertEquals(expected, result);
    }
}

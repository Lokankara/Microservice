package com.stack.structure.map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterMapTest {

    @ParameterizedTest
    @ArgumentsSource(LetterCountArgumentsProvider.class)
    void testCountLetters(String sentence, Map<Character, Integer> expected) {
        assertEquals(CounterMap.countLetters(sentence), expected);
    }

}

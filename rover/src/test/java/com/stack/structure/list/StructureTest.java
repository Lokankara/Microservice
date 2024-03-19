package com.stack.structure.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StructureTest {
    private Structure structure;
    @BeforeEach
    void setUp() {
        structure = new Structure();
    }

    @ParameterizedTest
    @ArgumentsSource(ColorsWithLProvider.class)
    void testRemoveColorsWithoutLetterL(List<String> colors, List<String> expected){
    List<String> result = structure.removeColorsWithLetter('L', colors);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ArgumentsSource(ColorsWithoutLProvider.class)
    void testRemoveColorsWithoutLetter(List<String> colors) {
        List<String> result = structure.removeColorsWithLetter('L', colors);
        assertEquals(colors, result);
    }

    @Test
    void testFillListFrom100To1000(){
        List<Integer> numbers = structure.fillListFrom100To1000();
        List<Integer> integers = structure.removeEvenNumbers(numbers);
        assertEquals(901, numbers.size());
        assertEquals(450, integers.size());
    }
}

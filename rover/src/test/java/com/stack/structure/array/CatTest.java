package com.stack.structure.array;

import com.stack.combinatoric.Cat;
import com.stack.structure.array.provider.CatNamesProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CatTest {

    @ParameterizedTest(name = "{0}, sum:{1}")
    @ArgumentsSource(CatNamesProvider.class)
    void testFindBy(String[] cats, char[] letters, String[] expected) {
        String[] result = new Cat().findBy(cats, letters);
        assertArrayEquals(expected, result);
    }
}

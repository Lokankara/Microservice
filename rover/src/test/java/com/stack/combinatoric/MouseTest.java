package com.stack.combinatoric;

import com.stack.combinatoric.prodiver.MouseArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MouseTest {

    @ParameterizedTest(name = "input: {0}, result:{1}")
    @ArgumentsSource(MouseArgumentsProvider.class)
    void testCount(String input, String expected) {
        assertEquals(expected, new Mouse().count(input));
    }
}

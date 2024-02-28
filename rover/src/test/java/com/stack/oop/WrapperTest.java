package com.stack.oop;

import com.stack.oop.provider.ArrayInfoArgumentsProvider;
import com.stack.oop.provider.CompareArgumentsProvider;
import com.stack.oop.provider.PriceArgumentsProvider;
import com.stack.oop.provider.PriceErrorArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WrapperTest {
    private Wrapper wrapper;

    @BeforeEach
    public void before() {
        wrapper = new Wrapper();
    }

    @ParameterizedTest
    @ArgumentsSource(PriceArgumentsProvider.class)
    void testGetPrice(String coin, String expected) {
        String actual = wrapper.getPrice(coin);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @ArgumentsSource(PriceErrorArgumentsProvider.class)
    void testGetPriceWithThrowsException(String coin) {
        assertThrows(Exception.class, () -> wrapper.getPrice(coin));
    }

    @ParameterizedTest
    @ArgumentsSource(ArrayInfoArgumentsProvider.class)
    void testGetArrayInfo(String[] array, String expected) {
        String actual = wrapper.getArrayInfo(array);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CompareArgumentsProvider.class)
     <T extends Comparable<T>> void testCompare(T a, T b, int expected){
        int actual = wrapper.compare(a, b);
        assertEquals(Integer.signum(expected), Integer.signum(actual));
    }
}

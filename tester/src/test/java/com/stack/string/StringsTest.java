package com.stack.string;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.springframework.util.StringUtils.removeDuplicateStrings;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class StringsTest {

    @DataProvider
    public static Object[][] testData() {
        return new Object[][]{
                {new String[]{"apple", "banana", "apple"}, new String[]{"apple", "banana"}},
                {new String[]{"orange", "orange", "orange"}, new String[]{"orange"}},
                {new String[]{"kiwi", "mango", "kiwi", "mango"}, new String[]{"kiwi", "mango"}},
                {new String[]{}, new String[]{}}
        };
    }

    @DataProvider
    public static Object[][] testInvalidData() {
        return new Object[][]{
                {new String[]{}, new String[]{}},
                {null, null},
                {new String[]{"apple", null, "apple"}, new String[]{"apple", null}}
        };
    }

    @Test(dataProvider = "testData")
    public void removeDuplicateStringsTest(
            String[] input, String[] expected) {
        assertArrayEquals(removeDuplicateStrings(input), expected);
    }

    @Test(dataProvider = "testInvalidData")
    public void removeDuplicateStringsInvalidDataTest(
            String[] input, String[] expected){
        assertArrayEquals(removeDuplicateStrings(input), expected);
    }
}

package com.stack.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UniqueCountTest {

    @DataProvider(name = "words")
    public Object[][] wordsDataProvider() {
        return new Object[][] {
                {"абракадабра", 5},
                {"hello", 4},
                {"banana", 3},
                {"programming", 8},
                {"unique", 6}
        };
    }

    @DataProvider(name = "invalidWords")
    public Object[][] invalidWordsDataProvider() {
        return new Object[][] {
                {"", 0},
                {null, -1}
        };
    }

    @DataProvider(name = "textData")
    public Object[][] textData() {
        return new Object[][] {
                {null, -1},
                {"", 0},
                {"Привет, мир!", 9},
                {"Как дела?", 7},
                {"Hello, world!", 0},
                {"1234567890", 0},
                {"Тестирование", 12}
        };
    }

    @Test(dataProvider = "textData")
    public void testCountCyrillicCharacters(String text, int expectedCount) {
        int actualCount = UniqueCount.countCyrillicCharacters(text);
        assertEquals(actualCount, expectedCount);
    }

    @Test(dataProvider = "words")
    public void testCountUniqueLetters(String word, int expected) {
        int actual = UniqueCount.countUniqueLetters(word);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "invalidWords")
    public void testCountUniqueLettersInvalidWords(String word, int expected) {
        int actual = UniqueCount.countUniqueLetters(word);
        assertEquals(actual, expected);
    }
}

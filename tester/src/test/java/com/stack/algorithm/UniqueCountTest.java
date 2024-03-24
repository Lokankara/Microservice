package com.stack.algorithm;

import org.testng.Assert;
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
                {"unique", 5}
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


    @DataProvider(name = "happyPathTestData")
    public Object[][] happyPathTestData() {
        return new Object[][] {
                {"абракадабра", 5},
                {"АбРакадабра", 7},
                {"aбpакадабра", 7},
                {"1ая", 2},
                {"пол-литра", 7},
                {" ", 0}
        };
    }

    @DataProvider(name = "negativeTestData")
    public Object[][] negativeTestData() {
        return new Object[][] {
                {null, -1},
                {"", 0}
        };
    }

    @Test(dataProvider = "happyPathTestData")
    public void testCountUniqueLettersHappyPath(String word, int expectedResult) {
        int actualResult = UniqueCount.countUniqueLetters(word);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "negativeTestData")
    public void testCountUniqueLettersNegative(String word, int expectedResult) {
        int actualResult = UniqueCount.countUniqueLetters(word);
        Assert.assertEquals(actualResult, expectedResult);
    }
}

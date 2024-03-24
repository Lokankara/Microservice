package com.stack.e2e;

import com.stack.structure.StructureMap;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringsTest {
    @Test
    void testCapitalize(){
        String expectedResult = "My mother told me.";
        String actual = Strings.capitalizeSentence(SeleniumTest.sentence);
        Assert.assertEquals(actual, expectedResult);
    }

    @Test(dataProvider = "textData")
    public void testCountCyrillicCharacters(String data, int actual) {
        int actualCount = StructureMap.countCyrillicCharacters(data);
        Assert.assertEquals(actualCount, actual);
    }

    @DataProvider(name = "textData")
    public Object[][] textData() {
        return new Object[][] {
                {null, -1},
                {"", 0},
                {"Как дела?", 7},
                {"1234567890", 0},
                {"Привет, мир!", 9},
                {"Тестирование", 12},
                {"Hello, world!", 0}
        };
    }
}

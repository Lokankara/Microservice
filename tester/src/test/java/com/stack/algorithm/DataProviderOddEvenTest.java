package com.stack.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DataProviderOddEvenTest {
        @DataProvider(name = "numberProvider")
        public Object[][] numberProvider() {
            return new Object[][] {
                    {"2", "Even"},
                    {"3", "Odd"},
                    {"0", "Even"},
                    {"-2", "Even"},
                    {"-3", "Odd"},
                    {"", "Empty number. Please input valid number."},
                    {"21474836488456", "Out of range Data. Please input valid number."},
                    {"214748a", "Non-numeric data. Please input valid number."},
                    {null, "We have problems on our side. Try again later..."}
            };
        }

        @Test(dataProvider = "numberProvider")
        public void testOddEven(String number, String expected) {
            String actualResult = new OddEven().oddEven(number);
            assertEquals(actualResult, expected);
        }
}

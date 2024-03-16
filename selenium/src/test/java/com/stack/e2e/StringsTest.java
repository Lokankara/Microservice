package com.stack.e2e;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringsTest {
    @Test
    void testCapitalize(){
        String expectedResult = "My mother told me.";
        String actual = Strings.capitalizeSentence(SeleniumTest.sentence);
        Assert.assertEquals(actual, expectedResult);
    }
}

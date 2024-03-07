package com.stack.algorithm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AlgebraTest {

    @DataProvider(name = "fermatData")
    public Object[][] fermatData() {
        return new Object[][] {
                {2, 5, true},
                {3, 7, true},
                {10, 7, false},
                {6, 13, true},
                {10, 4, false},
                {10, -7, false},
                {10, 13, true},
                {6, 17, true},
                {10, 19, true},
                {10, 0, false}
        };
    }

    @Test(dataProvider = "fermatData")
    public void testCheckFermat(int a, int p, boolean expectedResult) {
        assertEquals(Algebra.checkFermat(a, p), expectedResult);
    }
}

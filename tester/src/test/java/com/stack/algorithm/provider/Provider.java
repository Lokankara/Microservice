package com.stack.algorithm.provider;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class Provider {
    @DataProvider(name = "gcdTestData")
    public static Object[][] gcdTestData() {
        return new Object[][] {
                {10, 5, 5},
                {17, 23, 1},
                {24, 36, 12},
                {0, 5, 5},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "primeNumbers")
    public static Object[][] primeNumbersDataProvider() {
        int start = 10;
        int end = 199;
        int count = end - start + 1;
        Object[][] data = new Object[count][1];
        for (int i = 0; i < count; i++) {
            data[i][0] = start + i;
        }
        return data;
    }

    @DataProvider(name = "primeFactorsTestData")
    public static Object[][] primeFactorsTestData() {
        return new Object[][] {
                {10, new Integer[]{2, 5}},
                {24, new Integer[]{2, 2, 2, 3}},
                {17, new Integer[]{17}},
                {1, new Integer[]{}},
                {2, new Integer[]{2}},
                {100, new Integer[]{2, 2, 5, 5}},
                {7919, new Integer[]{7919}},
                {1000000, new Integer[]{2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5}},
                {999983, new Integer[]{999983}},
                {2147483647, new Integer[]{2147483647}},
                {97, new Integer[]{97}},
                {89, new Integer[]{89}},
                {83, new Integer[]{83}},
                {79, new Integer[]{79}},
                {2147483647, new Integer[]{2147483647}},
                {0, new Integer[]{}}
        };
    }

    @DataProvider(name = "divisorData")
    public Object[][] divisorData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 2},
                {4, 3},
                {5, 2},
                {6, 4},
                {7, 2},
                {8, 4},
                {9, 3},
                {10, 4},
                {11, 2},
                {12, 6},
                {13, 2},
                {14, 4},
                {15, 4}
        };
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {15, Arrays.asList(3, 5)},
                {21, Arrays.asList(3, 7)},
                {35, Arrays.asList(5, 7)},
                {77, Arrays.asList(7, 11)},
                {121, Arrays.asList(11, 11)},
                {143, Arrays.asList(11, 13)},
                {187, Arrays.asList(11, 17)},
                {253, Arrays.asList(11, 23)},
                {289, Arrays.asList(17, 17)},
                {323, Arrays.asList(17, 19)},
                {391, Arrays.asList(17, 23)},
                {437, Arrays.asList(19, 23)},
                {667, Arrays.asList(23, 29)},
                {841, Arrays.asList(29, 29)},
                {5959, Arrays.asList(59, 101)},
                {899, Arrays.asList(29, 31)}
        };
    }
}

package com.stack.algorithm;

import org.testng.annotations.Test;
public class NamesTest {

    @Test
    public void testName()  {
        String[] popularNames = new Names().getPopularNames("names.json");
        String[] realNames = new Names().getRealNamesByYear("names.json", 1880);
        System.out.println("Popular Names: " + String.join(", ", popularNames));
        System.out.println("Real Names: " + String.join(", ", realNames));
    }
}

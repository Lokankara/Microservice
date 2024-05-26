package com.stack.automation.opencart.tests;

import com.stack.automation.opencart.tools.LoggerUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppJUnit5Test {

    @BeforeAll
    public static void setup() {
        LoggerUtils.logInfo("@BeforeAll setup()");
    }

    @AfterAll
    public static void tear() {
        LoggerUtils.logInfo("AfterAll tear()");
    }

    @BeforeEach
    public void setupThis() {
        LoggerUtils.logInfo("\tBeforeEach setupThis()");
    }

    @AfterEach
    public void tearThis() {
        LoggerUtils.logInfo("\tAfterEach tearThis()");
    }

    @Test
    void testExpectedException() {
        LoggerUtils.logInfo("\t\tTest testExpectedException()");
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    int i = 0;
                    i = 10 / (i + 0);
                });
        LoggerUtils.logInfo("\t\tMessage = " + thrown.getMessage());
        Assertions.assertEquals("/ by zero", thrown.getMessage());
    }

    @Test
    void testDemo() {
        LoggerUtils.logInfo("\t\tTest testDemo()");
        Assertions.assertEquals(5, 3 + 2);
    }
}

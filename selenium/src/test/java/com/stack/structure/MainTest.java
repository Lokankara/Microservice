package com.stack.structure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MainTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void testName() {
        WebDriverManager.firefoxdriver().setup();
        driver.quit();
    }
}

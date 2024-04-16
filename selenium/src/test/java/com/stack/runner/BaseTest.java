package com.stack.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod(Method method) {
        ChromeOptions chromeOptions = new ChromeOptions();
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected void afterMethod(Method method) {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }


    protected boolean isElementPresent(By by){
        try {
            this.driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
}

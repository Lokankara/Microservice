package com.stack.automation.waits.runner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class BaseTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

    private WebDriver driver;

    @BeforeEach
    protected void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-error");
        chromeOptions.addArguments("--window-size=1500,900");
        chromeOptions.addArguments("--disable-cache");
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
    }

    @AfterEach
    protected void afterMethod() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }
}


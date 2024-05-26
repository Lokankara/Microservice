package com.stack.automation.waits.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private final WebDriver driver;

    private final Wait<WebDriver> wait;

    private static final Long EXPLICITLY_WAIT_SECONDS = 2L;

    protected BasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(getDriver(),
                Duration.ofSeconds(EXPLICITLY_WAIT_SECONDS));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Wait<WebDriver> getWait() {
        return wait;
    }
}

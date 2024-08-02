package com.stack.automation.opencart.tests;

import com.stack.automation.waits.runner.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class OpenCartTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(OpenCartTest.class);
    private static final String BASE_URL = "https://demo.opencart.com/";
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static final boolean isFullScreen = false;
    private static boolean isTestSuccessful = false;

    @BeforeEach
    void setUp() {
        logger.info("Opened site " + BASE_URL);
        getDriver().get(BASE_URL);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (!isTestSuccessful) {
            presentationSleep(2);
            takeShot(testInfo.getDisplayName());
            takePageSource(testInfo.getDisplayName());
        }
        logger.info("Executed after method");
    }

//    @Test
    void testDesktopMacScenario() {
        final String expectedMain = "Your Store";
        final String expectedCurrency = "€";
        final String expectedName = "Mac";
        final String expectedDesc = "iMac";
        final String expectedPrice = "111.04€";
        final String expectedMacUrl = BASE_URL + "index.php?route=product/category&language=en-gb&path=20_27";

        if(isFullScreen){
            getDriver().manage().window().maximize();
        }

        assertUrl(BASE_URL);
        assertTitle(expectedMain);

        clickOn(By.cssSelector(".dropdown-toggle > strong ~ span ~ i.fas.fa-caret-down"));
        clickOn(By.cssSelector("a[href='EUR']"));

        verifyElement(By.xpath("//a[@class='dropdown-toggle']/strong"), expectedCurrency);
        isVisibleAndClick(By.cssSelector("button.navbar-toggler > i.fas.fa-bars"));

        WebElement nav = getDriver().findElement(By.cssSelector("div.dropdown-menu.show"));
        scrollView(nav);
        WebElement navMac = nav.findElement(By.xpath("//a[contains(text(),'Mac')][@class='nav-link']"));

        navMac.click();

        By header = By.xpath("//div[@id='content' and @class='col']//h2[text()='Mac']");
        By description = By.xpath("//h4/a");
        By price = By.xpath("//div[@class='price']/span[@class='price-new']");

        verifyElement(header, expectedName);
        verifyElement(description, expectedDesc);
        verifyElement(price, expectedPrice);

        List<WebElement> cards = getDriver().findElements(By.cssSelector("form[data-oc-target='#header-cart']"));

        if (!cards.isEmpty()) {
            cards.stream().map(card -> getText(card.findElement(By.cssSelector(".content")))).forEach(logger::info);
            assertUrl(expectedMacUrl);
            assertTitle(expectedName);
            isTestSuccessful = true;
            logger.info("Was found element Mac");
        } else {
            logger.error("There is no such item as 'Mac'.");
            isTestSuccessful = false;
        }
        Assertions.assertTrue(isTestSuccessful, "The test is successful.");
    }

    private void isVisibleAndClick(By locator) {
        try {
            if (isDisplayed(getDriver().findElement(locator))) {
                clickOn(locator);
            }
        } catch (Exception e) {
            logger.error("Small width");
        }
        clickOn(By.linkText("Desktops"));
        presentationSleep(1);
    }

    private void takeShot(String fileName) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String pathName = String.format("./target/report/%s_%s_screenshot.png", currentTime, fileName);

        try {
            FileUtils.copyFile(scrFile, new File(pathName));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void takePageSource(String fileName) {
        byte[] bytes = getDriver().getPageSource().getBytes();
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String sourceHtml = String.format("./report/%s_%s_source.html", currentTime, fileName);
        Path path = Paths.get(sourceHtml);
        try {
            Files.write(path, bytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void scrollView(WebElement element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    private void verifyElement(By locator, String expected) {
        assertElement(getDriver().findElement(locator), expected);
    }

    private void assertUrl(String expectedUrl) {
        Assertions.assertEquals(expectedUrl, getDriver().getCurrentUrl(),
                "URL does not match the page");
    }

    private void assertElement(WebElement element, String expected) {
        Assertions.assertTrue(isDisplayed(element),
                "The element is not present on the page");
        Assertions.assertEquals(expected, getText(element),
                "The element text does not match");
    }

    private void assertTitle(String expected) {
        Assertions.assertEquals(expected, getDriver().getTitle(),
                "Incorrect title on the page");
    }

    private String getText(WebElement element) {
        return element.getText();
    }

    private boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    private void clickOn(By locator) {
        getDriver().findElement(locator).click();
    }
}

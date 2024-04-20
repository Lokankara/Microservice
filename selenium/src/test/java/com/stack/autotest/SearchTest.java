package com.stack.autotest;

import com.stack.runner.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseTest {

    private static final String BASE_URL = "https";
    private static WebDriver driver;
    private static boolean isTestSuccessful = false;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    @BeforeMethod
    public void setUp() {
        presentationSleep(1);
        driver.get(BASE_URL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @AfterMethod
    public void tearDown(TestInfo testInfo) {
        presentationSleep(1);
        System.out.println(testInfo.getDisplayName());
        if (!isTestSuccessful){
            takeShot(testInfo.getDisplayName());
            takePageSource(testInfo.getDisplayName());
            System.err.println(testInfo.getDisplayName());
        }
        System.out.println("executed");
    }

    @Test
    public void testSearch() {
        WebElement currencyUSD = driver.findElement(By.cssSelector("a[href='USD']"));
        System.out.println(currencyUSD.isDisplayed());

        WebElement shevron = driver.findElement(By.cssSelector("data[href='USD']"));

        isTestSuccessful = true;
    }

    private void takeShot(String displayName) {

    }

    private void takePageSource(String displayName) {

    }

    private void presentationSleep(int seconds) {

//        Thread.sleep(seconds * 1000);
    }

}

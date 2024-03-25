package com.stack.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.stack.model.StepLocator.listId;

public class GiftShopPageTest {
    private WebDriver driver;

    private static final String url = "https://gift-store-certificate.netlify.app/";

    @BeforeClass
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testLogin() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("alice", "alice");

        By id = By.id("user-span");
        WebElement userSpan = getWebElementWithDelay(id, 5000);
        String text = userSpan.getText();
        Assert.assertEquals(text, "Alice  |");
    }

    @Test(priority = 2)
    public void testGiftShopFilterHolidayByDay() {
        int expected = 2;
        String value = "Book";

        GiftShopPage giftShopPage = new GiftShopPage(driver);
        giftShopPage.setSearchInput(value);

        By id = By.id(listId);
        getWebElementWithDelay(id, 2000);

        giftShopPage.clickDropdown();
        giftShopPage.clickHoliday();

        List<WebElement> certificates = giftShopPage.getCertificates();

        Assert.assertEquals(certificates.size(), expected);

        for (WebElement certificate : certificates) {
            Assert.assertTrue(certificate.getText().contains(value));
        }
    }

    private WebElement getWebElementWithDelay(By id, int millis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(id));
    }
}

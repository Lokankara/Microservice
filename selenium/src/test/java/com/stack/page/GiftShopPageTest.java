package com.stack.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GiftShopPageTest {
    private static final String url = "https://gift-store-certificate.netlify.app/";

    @Test
    public void testGiftShopFilterHolidayByDay()
            throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        GiftShopPage giftShopPage = new GiftShopPage(driver);
        giftShopPage.setSearchInput("Book");

        Thread.sleep(2000);

        giftShopPage.clickDropdown();
        giftShopPage.clickHoliday();

        List<WebElement> certificates = giftShopPage.getCertificates();

        int expected = 2;
        Assert.assertEquals(certificates.size(), expected);

        for (WebElement certificate : certificates) {
            Assert.assertTrue(certificate.getText().contains("Book"));
        }

        driver.quit();
    }


}

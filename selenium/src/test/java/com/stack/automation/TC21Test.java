package com.stack.automation;

import com.stack.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.stack.automation.Helper.BASE_URL;

public class TC21Test extends BaseTest {

    @Test
    public void testAddReviewOnProductHP() throws InterruptedException {
        final String expectedResult = "ALL PRODUCTS";
        WebDriver driver = getDriver();

        driver.get(BASE_URL);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Helper.skipAd(getDriver());

        String text = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();

        Assert.assertEquals(text, expectedResult);
    }
}

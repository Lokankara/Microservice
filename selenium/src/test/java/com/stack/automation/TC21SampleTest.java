package com.stack.automation;

import com.stack.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.stack.automation.Helper.BASE_URL;

public class TC21SampleTest extends BaseTest {

    @Test
    public void testAddReviewOnProductHappyPath() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        Thread.sleep(3000);

        if (driver.findElement(By.xpath("//iframe[contains(@style, 'overflow: visible')]")).isDisplayed()) {
            System.out.println("Advertisement");
            driver.findElement(By.xpath("//a[@href='/products']")).click();

            Thread.sleep(3000);
            System.out.println("Products isDisplayed");

            driver.findElement(By.xpath("//a[@href='/products']")).click();
            System.out.println("click products");

            Helper.skipAd(getDriver());
        }

        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(text);
        driver.quit();
    }
}

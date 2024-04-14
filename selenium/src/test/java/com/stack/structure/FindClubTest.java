package com.stack.structure;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class FindClubTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void findClub() {
        driver.findElement(By.linkText("Гуртки")).click();
        driver.findElement(By.id("rc_select_1")).sendKeys("Dream Team");
        waitFor(1100);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        WebElement element = driver.findElement(By.cssSelector("#root > div > div.ant-layout.css-13m256z > main > div > div.ant-layout.club-list.css-13m256z > main > div > div:nth-child(2)"));
        wait.until(ExpectedConditions.stalenessOf(element));

        driver.findElement(By.cssSelector(".title > .name")).click();
        waitFor(1500);
        String actual = driver.findElement(By.cssSelector(".club-name")).getText().trim();
        assertThat(actual, is("Школа танців Dream Team"));
    }

    private static void waitFor(int millis) {
        await().atMost(millis, MILLISECONDS).until(() -> true);
    }
}

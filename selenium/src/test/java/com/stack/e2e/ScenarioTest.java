package com.stack.e2e;

import com.stack.model.StepExecution;
import com.stack.model.StepTuple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.stack.model.StepLocator.aHoliday;
import static com.stack.model.StepLocator.certificateCard;
import static com.stack.model.StepLocator.dropId;
import static com.stack.model.StepLocator.h2Tag;
import static com.stack.model.StepLocator.listId;
import static com.stack.model.StepLocator.searchPlaceholder;

public class ScenarioTest {

    private WebDriver driver;

    private static final String url = "https://gift-store-certificate.netlify.app/";

    @BeforeClass
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGiftShopFilterHolidayByDay() {
        driver.manage().window().maximize();
        driver.get(url);

        int expected = 2;
        String value = "Book";
        String millis = String.valueOf(2000) ;
        By dropdown = By.id(dropId);
        By holiday = By.xpath(aHoliday);
        By input = By.xpath(searchPlaceholder);

        Queue<StepTuple> tuples = new LinkedList<>();

        tuples.add(new StepTuple(driver.findElement(input), StepExecution.SEND, value));
        tuples.add(new StepTuple(driver.findElement(input), StepExecution.SLEEP, millis));
        tuples.add(new StepTuple(driver.findElement(dropdown), StepExecution.CLICK, value));
        tuples.add(new StepTuple(driver.findElement(holiday), StepExecution.CLICK, value));

        StepExecution.executeScenario(tuples);

        List<WebElement> certificates = getWebElements();
        Assert.assertEquals(certificates.size(), expected);

        for (WebElement certificate : certificates) {
            assertContainsText(certificate, value);
        }
    }

    private static void assertContainsText(
            WebElement certificate, String value) {
        String h2Text = certificate.findElement(By.tagName(h2Tag)).getText();
        Assert.assertTrue(h2Text.contains(value));
    }

    private List<WebElement> getWebElements() {
        WebElement list = driver.findElement(By.id(listId));
        return list.findElements(By.xpath(certificateCard));
    }
}

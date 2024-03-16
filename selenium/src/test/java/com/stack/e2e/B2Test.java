package com.stack.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class B2Test {
    private WebDriver driver;

    private final String[] answers = {
            "Will you have retired",
            "'ll be studying",
            "will be starting",
            "will have gone",
            "won't be working",
            "won't have finished",
            "will have fixed",
            "'ll be having"
    };
    @BeforeClass
    public void setUp() {
        String url = "https://elt.oup.com/student/solutions/int3rdedition/grammar/grammar_05_022e?cc=ua&selLanguage=uk";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1936, 1096));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void b2Test()  {

        for (int i = 0; i < answers.length; i++) {
            sendKeys(answers[i], getElement(i));
        }

        driver.findElement(By.name("button")).click();
        assertThat(driver.switchTo().alert().getText(),
                   is("Your score is 8/8"));

        driver.switchTo().alert().accept();

        for (int i = 0; i < answers.length; i++) {
            assertValue(answers[i], getElement(i));
        }
    }

    private WebElement getElement(int i) {
        return driver.findElement(By.name("ans" + (i + 1)));
    }

    private void assertValue(String expected, WebElement element) {
        String value = element.getAttribute("value");
        assertThat(value, is(expected));
    }

    private void sendKeys(String value, WebElement element) {
        element.click();
        element.sendKeys(value);
    }
}

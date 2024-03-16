package com.stack.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.stack.e2e.StepFactory.performStep;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumTest {
    private static final String url = "https://capitalizemytitle.com/";
    public static final String sentence = "my mother told me.";
    private WebDriver driver;
    JavascriptExecutor js;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        js = (JavascriptExecutor) driver;
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1000() {
        String expectedResult = "My mother told me.";
        driver.get(url);
        driver.manage().window().maximize();

//        By mainInput = By.xpath("//textarea[@id='main_input']");
//        mainInput = By.cssSelector("textarea#main_input");
//        By byName = By.name("main_input");
//      By acceptAll = By.xpath("//span[text()='Accept All']");
        By mainInput = By.id("main_input");
        By sentenceInput = By.id("sentencecase");
        By selector = By.cssSelector(".tab-content");

        Queue<StepTuple> tuples = new LinkedList<>();

        tuples.add(new StepTuple(mainInput, StepExecution.CLICK));
        tuples.add(new StepTuple(mainInput, StepExecution.SEND));
        tuples.add(new StepTuple(sentenceInput, StepExecution.CLICK));
        tuples.add(new StepTuple(selector, StepExecution.CLICK));
        tuples.add(new StepTuple(mainInput, StepExecution.ATTRIBUTE));
        String actual = Strings.capitalizeSentence(sentence);
        Assert.assertEquals(actual, expectedResult);

        String result;

        while (!tuples.isEmpty()) {
            StepTuple tuple = tuples.poll();
            result = performStep(driver.findElement(tuple.getBy()), tuple.getStep(), actual);
            if (result != null) {
                assertThat(result, is(expectedResult));
            }
        }
    }
}

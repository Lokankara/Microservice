package com.stack.e2e;

import com.stack.e2e.model.StepExecution;
import com.stack.e2e.model.StepTuple;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.stack.e2e.StepFactory.execute;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class SeleniumTest {
    private static final String url = "https://capitalizemytitle.com/";
    public static final String sentence = "my mother told me.";
    private WebDriver driver;

    public static final String data = "Это мой Текст из русских слов и слова dot";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void testCapitalize() {
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
            result = execute(driver.findElement(tuple.by()), tuple.step(), actual);
            if (result != null) {
                assertThat(result, is(expectedResult));
            }
        }
    }

    @Test
    public void testNeironica() {
        driver.get("https://training.neironica.com/login");
        driver.manage()
              .window()
              .maximize();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("email@email.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
    }

    @Test
    public void testJackets()
            throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");
        driver.manage()
              .window()
              .maximize();
        By xpath = By.xpath("//span[text()='Women']");
        WebElement element = driver.findElement(xpath);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(1500);

        By tops = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women.html']//span[text()='Tops']");
        WebElement elementTop = driver.findElement(tops);
        actions.moveToElement(elementTop).perform();
        Thread.sleep(1000);

        By jacket = By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']//span[text()='Jackets']");
        WebElement elementJacket = driver.findElement(jacket);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(elementJacket));
        actions.moveToElement(elementJacket).perform();
        Thread.sleep(1000);

        elementJacket.click();

        By baseJacket = By.xpath("//span[@class='base']");
        WebElement jackets = driver.findElement(baseJacket);
        Assert.assertEquals(jackets.getText(), "Jackets");
    }

    @Test
    public void testBottles() {
        driver.get("https://www.99-bottles-of-beer.net");
        driver.manage()
              .window()
              .maximize();

//        By lyric = By.xpath("//ul[@id='submenu']//a[@href='lyrics.html']");

        By lyric = By.linkText("Song Lyrics");
        driver.findElement(lyric).click();

        By main = By.id("main");
        By pTag = By.tagName("p");

//        WebElement element = driver.findElement(main);
//        List<WebElement> elements = element.findElements(pTag);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id" + "='main']//p"));

        List<String> pValues = new ArrayList<>();
        for (WebElement p : elements) {
            pValues.add(p.getText());
        }

        assertEquals(100, pValues.size());
        System.out.println(pValues);
    }

    @Test
    @Ignore
    public void testCount() {
        driver.get("https://involta.ru/tools/length-chars/");
        driver.manage()
              .window()
              .maximize();

        String expected = String.valueOf(30);

        By input = By.xpath("//textarea[@id='input']");
        By submit = By.xpath("//button[@type='submit']");
        By selector = By.cssSelector("div:nth-child(2) > .lenght-chars_spanResult__3U-85");

        WebElement textarea = driver.findElement(input);
        textarea.sendKeys(data);

        WebElement button = driver.findElement(submit);
        button.click();

        WebElement spanElement = driver.findElement(selector);
        String value = spanElement.getText();

        int actualCount = countCyrillicCharacters(data);

        Assert.assertEquals(expected, value);
        Assert.assertEquals(String.valueOf(actualCount), value);
        Assert.assertEquals(expected, String.valueOf(actualCount));
    }

    @Test(dataProvider = "textData")
    public void testCountCyrillicCharacters(String data, int actual) {
        int actualCount = countCyrillicCharacters(data);
        Assert.assertEquals(actualCount, actual);
    }

    public static int countCyrillicCharacters(String text) {
        if (text == null){
            return -1;
        }

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 1040 && ch <= 1103) {
                count++;
            }
        }
        return count;
    }

    @DataProvider(name = "textData")
    public Object[][] textData() {
        return new Object[][] {
                {null, -1},
                {"", 0},
                {"Как дела?", 7},
                {"1234567890", 0},
                {"Привет, мир!", 9},
                {"Тестирование", 12},
                {"Hello, world!", 0}
        };
    }
}

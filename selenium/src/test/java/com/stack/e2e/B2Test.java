package com.stack.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class B2Test {
    private WebDriver driver;

    String url = "https://elt.oup.com/student/solutions/int3rdedition/grammar/grammar_05_022e?cc=ua&selLanguage=uk";

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
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1936, 1096));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Web form");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        textBox.sendKeys("Selenium");
        submitButton.click();
        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        Assert.assertEquals(value, "Received!");
        driver.quit();
    }

    @Test
    public void b2Test()  {
        driver.get(url);
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

    @Test
    public void ssTest() {
        A a = new B();
        B b = new B();
        System.out.println(a.getI());
        System.out.println(b.getJ());
        a.m1();
        b.m1();
    }

    @Test
    public void basicTest(){
        int number = 123;
        int digit1 = number / 100;
        int digit2 = (number / 10) % 10;
        int digit3 = number % 10;
        System.out.println((digit1 + digit2 + digit3));
        System.out.println(sumOfDigits(number));

    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isLeapYear(int year) {
        boolean by4 = year % 4 == 0;
        boolean by100 = year % 100 != 0;
        boolean by400 = year % 400 == 0;
        return (by4 && by100) || by400;
    }
}

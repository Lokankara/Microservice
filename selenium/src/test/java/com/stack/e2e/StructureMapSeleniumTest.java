package com.stack.e2e;

import com.stack.structure.StructureMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StructureMapSeleniumTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://randomwordgenerator.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Ignore
    void testRandomWordGenerator() {
        driver.manage().window().maximize();

        By qty = By.id("qty");
        By result = By.id("result");
        By tagName = By.tagName("li");
        By category = By.id("category");
        By option = By.xpath("//option[. = 'Nouns']");
        By submit = By.cssSelector("input[type='submit'][name='submit'][value='Generate Random Words']");

        WebElement dropdown = driver.findElement(category);
        dropdown.findElement(option).click();

        WebElement qtyInput = driver.findElement(qty);
        qtyInput.clear();
        qtyInput.sendKeys("50");

        WebElement submitButton = driver.findElement(submit);
        submitButton.click();

        WebElement ul = driver.findElement(result);
        List<WebElement> liElements = ul.findElements(tagName);

        List<String> liValues = new ArrayList<>();
        for (WebElement li : liElements) {
            liValues.add(li.getText());
        }
        assertEquals(50, liValues.size());

        Map<Character, String> words = StructureMap.getLongestWordsByLetters(liValues);
        StructureMap.printMap(words);

    }
}

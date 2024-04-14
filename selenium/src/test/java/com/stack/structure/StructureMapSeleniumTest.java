package com.stack.structure;

import com.stack.structure.StructureMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.stack.structure.StructureMap.countUniqueLetters;

public class StructureMapSeleniumTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRandomWordGenerator() {
        driver.manage().window().maximize();
        driver.get("https://randomwordgenerator.com/");
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
        qtyInput.sendKeys("30");

        WebElement submitButton = driver.findElement(submit);
        submitButton.click();

        WebElement ul = driver.findElement(result);
        List<WebElement> liElements = ul.findElements(tagName);

        List<String> liValues = new ArrayList<>();
        for (WebElement li : liElements) {
            liValues.add(li.getText());
        }
        Assert.assertEquals(liValues.size(), 30);

        Map<Character, String> words = StructureMap.getLongestWordsByLetters(liValues);
        StructureMap.printMap(words);

    }

    @Test
    public void testYandex(){
        int expectedSize = 7;

        By inputLocator = By.xpath("//input[@placeholder='finds everything']");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("абракадабрa");
        input.submit();

        //"//b[contains (text(),'абракадабрa')]"
        By textLocator = By.xpath("//b[text()='абракадабрa']");
        WebElement b = driver.findElement(textLocator);
        String actualText = b.getText();
        int actualSize = countUniqueLetters(actualText);

        Assert.assertEquals(expectedSize, actualSize);
    }
}

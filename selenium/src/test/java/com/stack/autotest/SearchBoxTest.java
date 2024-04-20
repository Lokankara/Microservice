package com.stack.autotest;

import com.stack.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchBoxTest extends BaseTest {

    @Test
    public void testFindBackPack() {
        getDriver().get("https://magento.softwaretestingboard.com");
        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("back");
    }
}

package com.stack.automation;

import com.stack.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.stack.automation.Helper.BASE_URL;

public class TC07VerifyTestCasesPageTest
        extends BaseTest {

    @Test
    public void testVerifyTestCasesPage() {

        final String expectedTitleHome = "Automation Exercise";
        final String expectedTitleTestCases = "Automation Practice Website for UI Testing - Test Cases";

        getDriver().get(BASE_URL);
        Assert.assertEquals(getDriver().getTitle(), expectedTitleHome);

        getDriver().findElement(By.xpath("//a[@href='/test_cases']/i[@class]")).click();
        Assert.assertEquals(getDriver().getTitle(), expectedTitleTestCases);
    }
}

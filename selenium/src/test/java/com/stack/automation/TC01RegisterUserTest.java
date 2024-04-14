package com.stack.automation;

import com.stack.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Random;

import static com.stack.automation.Helper.BASE_URL;

public class TC01RegisterUserTest extends BaseTest {

    @Test
    public void testSignUpAndDeleteAccount() {

        final String expectedResultName = "Alice";
        final String expectedResult = "New User Signup!";
        final String expectedCreated = "ACCOUNT CREATED!";
        final String expectedDeleted = "ACCOUNT DELETED!";
        final String expectedResultAccount = "ENTER ACCOUNT INFORMATION";

        getDriver().manage().window().maximize();
        getDriver().get(BASE_URL);

        getDriver().findElement(By.linkText("Signup / Login")).click();

        WebElement signupHeader = getDriver().findElement(By.xpath("//div[@class='signup-form']//h2"));
        Helper.verify(signupHeader, expectedResult);

        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Alice");
        getDriver().findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("alice%d@gmail.com".formatted(new Random().nextInt(10000)));
        getDriver().findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        WebElement accountInfo = getDriver().findElement(By.xpath("//h2[@class='title text-center']"));
        Helper.verify(accountInfo, expectedResultAccount);

        getDriver().findElement(By.id("newsletter")).click();
        getDriver().findElement(By.id("id_gender1")).click();
        getDriver().findElement(By.id("password")).sendKeys("passwordInput");
        getDriver().findElement(By.id("first_name")).sendKeys("Pashu");
        getDriver().findElement(By.id("last_name")).sendKeys("Pati");
        getDriver().findElement(By.id("company")).sendKeys("MB");
        getDriver().findElement(By.id("address1")).sendKeys("Che");
        getDriver().findElement(By.id("address2")).sendKeys("Bukovina");
        getDriver().findElement(By.id("country")).sendKeys("Canada");
        getDriver().findElement(By.id("state")).sendKeys("Iowa");
        getDriver().findElement(By.id("city")).sendKeys("Che");
        getDriver().findElement(By.id("zipcode")).sendKeys("12345");
        getDriver().findElement(By.id("mobile_number")).sendKeys("+380990909999");

        WebElement createAccount = getDriver().findElement(By.cssSelector("button[data-qa='create-account']"));
        Helper.scrollToIntoView(getDriver(), createAccount);
        createAccount.click();

        WebElement accountCreated = getDriver().findElement(By.cssSelector("b"));
        Helper.verify(accountCreated, expectedCreated);

        getDriver().findElement(By.linkText("Continue")).click();
        Helper.skipAd(getDriver());

        WebElement loginName = getDriver().findElement(By.xpath("//li/a/b"));
        Helper.verify(loginName, expectedResultName);

        getDriver().findElement(By.linkText("Delete Account")).click();

        WebElement accountDeleted = getDriver().findElement(By.cssSelector("b"));
        Helper.verify(accountDeleted, expectedDeleted);

        getDriver().findElement(By.linkText("Continue")).click();
    }
}

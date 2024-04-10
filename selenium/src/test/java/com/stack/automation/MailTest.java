package com.stack.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MailTest extends BaseTest{

    @Test(priority = 2)
    void testCreateGreenNewAccount()
            throws InterruptedException {
        getDriver().get("https://tempmail.email/");
        String email = getEmail();
        System.out.println("Email: " + email + " YourPassword123!@#");

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("window.open()");
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get("https://www.greencity.social/#/ubs");

        signUp(email);
        getDriver().switchTo().window(tabs.get(0));

        WebElement refreshButton = getDriver().findElement(By.xpath("(//div[@class='header-items__refresh header-items__size'])[1]"));
        refreshButton.click();

        Thread.sleep(2000);
        WebElement emailContent = getDriver().findElement(By.xpath("//div[@class='receivedMail-content__wrapper message--container-bold']"));
        emailContent.click();
        WebElement button = getDriver().findElement(By.xpath("//a[contains(text(), 'Verify me!')]"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(button).perform();
        Thread.sleep(1000);
        button.click();
        Thread.sleep(2000);
        WebElement emailInput = getDriver().findElement(By.id("email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = getDriver().findElement(By.id("password"));
        passwordInput.sendKeys("YourPassword123!@#");

        WebElement signInButton = getDriver().findElement(By.xpath(
                "//button[contains(text(), 'Sign in')]"));
        signInButton.click();
    }

    private void signUp(String email)
            throws InterruptedException {
        Thread.sleep(3000);
        WebElement signUpButton = getDriver().findElement(By.xpath("//div[@class='main-content app-container']//div[@class='ubs-header_sign-up-btn']"));
        signUpButton.click();

        WebElement emailField = getDriver().findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement userNameField =
                getDriver().findElement(By.id("firstName"));
        userNameField.sendKeys("Alice");

        WebElement passwordField = getDriver()
                .findElement(By.id("password"));
        passwordField.sendKeys("YourPassword123!@#");

        WebElement confirmPasswordField =
                getDriver().findElement(By.id("repeatPassword"));
        confirmPasswordField.sendKeys("YourPassword123!@#");

        getDriver().findElement(By.cssSelector("button[role='link']")).click();
    }


    private String getEmail()
            throws InterruptedException {
        WebElement deleteButton = getDriver().findElement(By.id("js-btn-deleteEmail"));
        deleteButton.click();
        Thread.sleep(1000);
        WebElement emailDiv = getDriver().findElement(By.className("email-block__genEmail"));
        return emailDiv.getText();

    }
}

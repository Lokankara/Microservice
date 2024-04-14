package com.stack.autotest;

import com.stack.page.GiftShopPage;
import com.stack.page.LoginPage;
import com.stack.page.MenuPage;
import com.stack.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.stack.model.StepLocator.listId;

public class GiftShopPageTest extends BaseTest {

    private static final String url = "https://gift-store-certificate.netlify.app/";

    @Test(priority = 1)
    public void testLogin() {
        getDriver().get(url);
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("alice", "alice");

        By id = By.id("user-span");
        WebElement userSpan = getWebElementWithDelay(id, 5000);
        String text = userSpan.getText();
        Assert.assertEquals(text, "Alice  |");

        int expected = 2;
        String value = "Book";

        GiftShopPage giftShopPage = new GiftShopPage(getDriver());
        giftShopPage.setSearchInput(value);

        getWebElementWithDelay(By.id(listId), 2000);

        giftShopPage.clickDropdown();
        giftShopPage.clickHoliday();

        List<WebElement> certificates = giftShopPage.getCertificates();

        Assert.assertEquals(certificates.size(), expected);

        for (WebElement certificate : certificates) {
            Assert.assertTrue(certificate.getText().contains(value));
        }
    }

    private WebElement getWebElementWithDelay(By id, int millis) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(id));
    }
}

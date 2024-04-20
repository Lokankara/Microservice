package com.stack.luma.selenium;

import com.stack.luma.model.User;
import com.stack.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {

    @BeforeMethod
    public void beforeClass() {
        getPage().close();
        mainPage = new MainPage(getDriver());
    }

    private MainPage mainPage;

    @Test
    void testSignInUser() {
        final String expectedText = "Thank you for registering with Main Website Store.";

        User user = new User();
        mainPage.openPage();
        mainPage.clickCreateAnAccountButton()
                .enterFirstName(user.getFirstname())
                .enterLastName(user.getLastname())
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .enterConfirmPassword(user.getPassword())
                .clickCreateAccountButton();

        String actualUser = mainPage.getContactInformation();
        Assert.assertTrue(actualUser.contains(user.getFirstname()), "Text does not contain first name: " + user.getFirstname());
        Assert.assertTrue(actualUser.contains(user.getLastname()), "Text does not contain last name: " + user.getLastname());
        Assert.assertTrue(actualUser.contains(user.getEmail()), "Text does not contain email: " + user.getEmail());
        Assert.assertEquals(mainPage.confirmMessage(), expectedText, "Text does not match expected");

        if (mainPage.clickShevron().isLoggedIn()) {
            mainPage.clickLogoutAccount().verifyLogOut();
        }
    }
}

package com.stack.automation.opencart.tests;

import com.stack.automation.opencart.pages.HomePage;
import com.stack.automation.opencart.runner.TestRunnerFirst;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShoppingCartEmptyPageTest extends TestRunnerFirst {

//    @Test
    void testShoppingCartEmptyPage() {

        HomePage homePage = loadApplication()
                .gotoShoppingCart()
                .checkShoppingCartPage()
                .checkShoppingCartEmptyMessage()
                .clickContinueButton()
                .checkHomePage();

        Assertions.assertTrue(homePage.isLoaded());
        isTestSuccessful = true;
    }
}

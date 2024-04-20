package com.stack.autotest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.stack.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SignInTest.class);

    @Test
    public void testSingInPW() throws InterruptedException {
        logger.info("Navigating to the website");
        getPage().navigate("https://magento.softwaretestingboard.com/");

        String consentButtonSelector = "body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button > p";
        logger.info("Checking for visibility of consent button");

        if (getPage().isVisible(consentButtonSelector)) {
            handleOverlays(getPage());
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("\n" +
                    "Sign In ")).click();
            logger.info("Consent overlay handled and 'Sign In' clicked");
        } else {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("\n" +
                    "Sign In ")).click();
            logger.info("'Sign In' clicked without overlay");
        }

        getPage().getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).click();
        getPage().getByLabel("Email", new Page.GetByLabelOptions().setExact(true)).fill("tester1234@gmail.com");
        getPage().getByLabel("Password").click();
        getPage().getByLabel("Password").fill("tester1234!");
        getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
        Thread.sleep(3000);
        getPage().locator(" span.not-logged-in")
                .getByText("Click “Write for us” link in the footer to submit a guest post").isVisible();
        logger.info("Form submitted with provided credentials");

        logPageInfo(getPage());

        Locator titleElement = getPage().locator("h1");
        boolean isVisible = titleElement.isVisible();

        if (isVisible) {
            logger.info("First element is visible");
            String titleText = titleElement.innerText();
            Assert.assertEquals(titleText, "Home Page");
        } else {
            Locator secondLocator = getPage().locator(".logged-in").first().getByText("Welcome, tester3 tester3!");
            boolean isSecondVisible = secondLocator.isVisible();
            if (isSecondVisible) {
                logger.info("Second element is visible");
                String secondText = secondLocator.innerText();
                Assert.assertEquals(secondText, "Welcome, tester3 tester3!");
            } else {
                String welcome = "Welcome, tester3 tester3!";
                String notVisible = "Element is not visible";
                String getText = getPage().getByText("Welcome, tester3 tester3!").first().isVisible() ? welcome : notVisible;
                Assert.assertEquals(getText, "Welcome, tester3 tester3!");
            }
        }
    }

    private void handleOverlays(Page page) {
        String consentButtonSelector = "body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button > p";
        page.waitForSelector(consentButtonSelector);

        if (!page.isVisible(consentButtonSelector)) {
            return;
        }
        page.click(consentButtonSelector);
    }

    private void logPageInfo(Page page) {
        logger.info("URL: " + page.url());
        logger.info("Title: " + page.title());
        logger.info("Content: " + page.content());
    }
}


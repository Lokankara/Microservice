package com.stack.luma.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.stack.runner.BaseTest;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationPlaywrightPageTest extends BaseTest {

    String url = "https://magento.softwaretestingboard.com";

    @Test
    void testNavigateToMenuItems() {
        getDriver().quit();
        Page page = getPage();
        page.navigate(url);

        Object[] menuItems = {"What's New", "Women", Pattern.compile("Men"), "Gear", "Training", "Sale"};
        String[] pageTitles = {"What's New", "Women", "Men", "Gear", "Training", "Sale"};
        String[] pageURLs = {
                "https://magento.softwaretestingboard.com/what-is-new.html",
                "https://magento.softwaretestingboard.com/women.html",
                "https://magento.softwaretestingboard.com/men.html",
                "https://magento.softwaretestingboard.com/gear.html",
                "https://magento.softwaretestingboard.com/training.html",
                "https://magento.softwaretestingboard.com/sale.html"
        };

        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] instanceof String) {
                page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName((String) menuItems[i])).click();
            } else if (menuItems[i] instanceof Pattern) {
                page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName((Pattern) menuItems[i])).click();
            }
            assertThat(page).hasTitle(pageTitles[i]);
            assertThat(page).hasURL(pageURLs[i]);
            page.goBack();
        }
    }
}

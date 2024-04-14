package com.stack.luma.page;

import com.stack.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest
        extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage(getDriver());
    }

    @Test
    public void testMainPageElements() {
        mainPage.checkHref();
        Assert.assertTrue(mainPage.isStoreLogoDisplayed(), "Logo is not displayed");
        Assert.assertTrue(mainPage.isAddToCartButtonPresent(), "Add to cart button is not present");
        Assert.assertTrue(mainPage.isPromoSectionDisplayed(), "Promo section is not displayed");
        Assert.assertTrue(mainPage.areTrendingProductsDisplayed(), "Trending products are not displayed");
        Assert.assertTrue(mainPage.isSearchFieldPresent(), "Search field is not present");
        Assert.assertTrue(mainPage.isYogaCollectionPromoDisplayed(), "Yoga Collection promo is not displayed");
        Assert.assertTrue(mainPage.isPantsPromoDisplayed(), "Pants promo is not displayed");
        Assert.assertTrue(mainPage.isTShirtsPromoDisplayed(), "T-Shirts promo is not displayed");
        Assert.assertTrue(mainPage.isErinRecommendsPromoDisplayed(), "Erin Recommends promo is not displayed");
        Assert.assertTrue(mainPage.isPerformancePromoDisplayed(), "Performance promo is not displayed");
        Assert.assertTrue(mainPage.isEcoFriendlyPromoDisplayed(), "Eco-Friendly promo is not displayed");
    }
}

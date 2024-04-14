package com.stack.luma.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainPage {

    private static final String URL =
            "https://magento.softwaretestingboard.com/";

    @FindBy(xpath = "//a[@class='logo']")
    private WebElement storeLogo;

    @FindBy(css = ".block-promo.home-main")
    private WebElement yogaCollectionPromo;

    @FindBy(css = ".block-promo.home-pants")
    private WebElement pantsPromo;

    @FindBy(css = ".block-promo.home-t-shirts")
    private WebElement tShirtsPromo;

    @FindBy(css = ".block-promo.home-erin")
    private WebElement erinRecommendsPromo;

    @FindBy(css = ".block-promo.home-performance")
    private WebElement performancePromo;

    @FindBy(css = ".block-promo.home-eco")
    private WebElement ecoFriendlyPromo;

    @FindBy(css = ".blocks-promo")
    private WebElement promoSection;

    @FindBy(linkText = "Catalog")
    private WebElement catalogLink;

    @FindBy(linkText = "Search Terms")
    private WebElement searchTermsLink;

    @FindBy(linkText = "Privacy and Cookie Policy")
    private WebElement privacyPolicyLink;

    @FindBy(linkText = "Advanced Search")
    private WebElement advancedSearchLink;

    @FindBy(linkText = "Orders and Returns")
    private WebElement ordersReturnsLink;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(css = "a[href='/search']")
    private WebElement searchLink;

    @FindBy(css = "a[href='/privacy']")
    private WebElement privacyLink;

    @FindBy(css = "a[href='/orders']")
    private WebElement ordersLink;

    @FindBy(css = ".product-item")
    private List<WebElement> trendingProducts;

    @FindBy(css = ".action.tocart.primary")
    private WebElement addToCartButton;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(URL);
    }

    public boolean isStoreLogoDisplayed() {
        return storeLogo.isDisplayed();
    }

    public boolean isEcoFriendlyPromoDisplayed() {
        return ecoFriendlyPromo.isDisplayed();
    }

    public boolean isPerformancePromoDisplayed() {
        return performancePromo.isDisplayed();
    }

    public boolean isErinRecommendsPromoDisplayed() {
        return erinRecommendsPromo.isDisplayed();
    }

    public boolean isTShirtsPromoDisplayed() {
        return tShirtsPromo.isDisplayed();
    }

    public boolean isYogaCollectionPromoDisplayed() {
        return yogaCollectionPromo.isDisplayed();
    }

    public boolean isPantsPromoDisplayed() {
        return pantsPromo.isDisplayed();
    }

    public boolean isSearchFieldPresent() {
        return searchField.isDisplayed();
    }

    public boolean areTrendingProductsDisplayed() {
        return !trendingProducts.isEmpty();
    }

    public boolean isPromoSectionDisplayed() {
        return promoSection.isDisplayed();
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isDisplayed();
    }

    public void checkHref() {
        Assert.assertEquals(yogaCollectionPromo.getAttribute("href"),
                            URL + "collections/yoga-new.html");
        Assert.assertEquals(pantsPromo.getAttribute("href"),
                            URL + "promotions/pants-all.html");
        Assert.assertEquals(tShirtsPromo.getAttribute("href"),
                            URL + "promotions/tees-all.html");
        Assert.assertEquals(erinRecommendsPromo.getAttribute("href"),
                            URL + "collections/erin-recommends.html");
        Assert.assertEquals(performancePromo.getAttribute("href"),
                            URL + "collections/performance-fabrics.html");
        Assert.assertEquals(ecoFriendlyPromo.getAttribute("href"),
                            URL + "collections/eco-friendly.html");
    }
}

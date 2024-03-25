package com.stack.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.stack.model.StepLocator.aHoliday;
import static com.stack.model.StepLocator.certificateCard;
import static com.stack.model.StepLocator.dropId;
import static com.stack.model.StepLocator.listId;
import static com.stack.model.StepLocator.searchPlaceholder;

public class GiftShopPage extends BasePage {

    @FindBy(xpath = searchPlaceholder)
    private WebElement searchInput;

    @FindBy(id = dropId)
    private WebElement dropdown;

    @FindBy(xpath = aHoliday)
    private WebElement holiday;

    public GiftShopPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown() {
        this.dropdown.click();
    }

    public void clickHoliday() {
        this.holiday.click();
    }

    public List<WebElement> getCertificates() {
        WebElement list = super.driver.findElement(By.id(listId));
        return list.findElements(By.xpath(certificateCard));
    }

    public void setSearchInput(String value) {
        this.searchInput.sendKeys(value);
    }
}

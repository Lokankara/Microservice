package com.stack.luma.selenium;

import com.stack.luma.model.AddressBook;
import com.stack.luma.model.User;
import com.stack.runner.BaseTest;
import org.testng.annotations.Test;

public class AddressBookPageTest extends BaseTest {

    @Test
    public void testAddressBookPage() {
        User user = new User();
        AddressBook addressBook = new AddressBook();
        MainPage mainPage = new MainPage(getDriver());

        mainPage.openPage();
        mainPage.clickCreateAnAccountButton()
                .enterFirstName(user.getFirstname())
                .enterLastName(user.getLastname())
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .enterConfirmPassword(user.getPassword())
                .clickCreateAccountButton();

        AddressBookPage bookPage = mainPage.gotoAddressBook();
        bookPage.isVisibleHeader();
        bookPage.isVisibleContactInformation();
        bookPage.isVisibleAddress();
        bookPage.changeFirstName(addressBook.getFirstName())
                .changeLastName(addressBook.getLastName())
                .fillCompanyName(addressBook.getCompanyName())
                .changePhoneNumber(addressBook.getPhoneNumber())
                .changeStreetAddress(addressBook.getStreetAddress())
                .changeCity(addressBook.getCity())
                .changeZipPostalCode(addressBook.getZipPostalCode())
                .fillStreetAddress2(addressBook.getStreetAddress())
                .fillStreetAddress3(addressBook.getStreetAddress())
                .changeCity(addressBook.getCity())
                .changeZipPostalCode(addressBook.getZipPostalCode())
                .selectCountryByName("Australia") //Alaska
                .selectRegionByValue("569")
                .saveAddress();
        bookPage.isVisibleMessage();

        if (mainPage.clickShevron().isLoggedIn()) {
            mainPage.clickLogoutAccount().verifyLogOut();
        }
    }
}

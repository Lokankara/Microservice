package com.stack.automation.waits.page;

import com.stack.automation.waits.runner.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

class FilteringTableTest extends BaseTest {

    private static final String url = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";

    @BeforeEach
    void setUp() {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    @Test
    void testCityFilterByLetter() {
        final String letter = "L";

        RowPage rowPage = new RowPage(getDriver());
        TablePage table = new TablePage(getDriver());

        Assertions.assertTrue(table.isUncontrolledMode(), "Uncontrolled mode is not found");

        CellPage cellPage = table
                .waitVisibilityOfElement()
                .scrollToTable()
                .switchToIframe()
                .filterCityByLetter(letter);

        List<WebElement> cityCells = rowPage.getCityCells();
        List<String> cityNames = cellPage.getTextFromCells(cityCells);

        Assertions.assertTrue(cityNames.contains("Las Vegas"), "Las Vegas is not found in the City column.");
        Assertions.assertTrue(cityNames.contains("London"), "London is not found in the City column.");
    }
}

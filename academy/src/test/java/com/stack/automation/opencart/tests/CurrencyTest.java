package com.stack.automation.opencart.tests;

import com.stack.automation.opencart.data.Currencies;
import com.stack.automation.opencart.pages.HomePage;
import com.stack.automation.opencart.runner.TestRunnerFirst;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CurrencyTest extends TestRunnerFirst {

    public static Object[][] searchCurrencies() {
        return new Object[][] { 
            { Currencies.EURO },
            { Currencies.US_DOLLAR },
            { Currencies.POUND_STERLING },
            { Currencies.US_DOLLAR }
        };
    }

    @ParameterizedTest
    @MethodSource("searchCurrencies")
    void checkFirst(Currencies currency) {
        HomePage homePage = loadApplication().chooseCurrency(currency);

        Assertions.assertTrue(homePage.getCurrencyText().contains(currency.getSymbol()));
        isTestSuccessful = true;
        RequestBody body = RequestBody.create("{...}", MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("http://localhost:8080/")
                .post(body)
                .build();


    }
}

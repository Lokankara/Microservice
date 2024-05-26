package com.stack.automation.opencart.runner;

import com.stack.automation.opencart.pages.HomePage;
import com.stack.automation.opencart.tools.LoggerUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestRunnerFirst {
    private static final String BASE_URL = "https://demo.opencart.com/index.php";
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    @Getter
    private static WebDriver driver;
    protected boolean isTestSuccessful = true;

    private void takeScreenShot(String name) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pathName = String.format("./report/%s_%s_screenshot.png", currentTime, name);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(pathName));
        } catch (IOException e) {
            LoggerUtils.logError(e.getMessage());
        }
    }

    private void takePageSource(String name) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        byte[] bytes = driver.getPageSource().getBytes();
        Path path = Paths.get(String.format("./report/%s_%s_source.html", currentTime, name));

        try {
            Files.write(path, bytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            LoggerUtils.logError(e.getMessage());
        }
    }

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        LoggerUtils.logInfo("WebDriver is created");
    }

    @AfterAll
    public static void tear() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        LoggerUtils.logInfo("Browser is closed");
    }

    @BeforeEach
    public void setupThis() {
        isTestSuccessful = false;
        driver.get(BASE_URL);
        LoggerUtils.logInfo("Loaded a new web page in the current browser window");
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) {
        if (!isTestSuccessful) {
            takeScreenShot(testInfo.getDisplayName());
            takePageSource(testInfo.getDisplayName());
            LoggerUtils.logError("AfterEach, ERROR name = " + testInfo.getDisplayName());
        } else {
            LoggerUtils.logInfo("AfterEach executed, name = " + testInfo.getDisplayName());
        }
    }

    protected HomePage loadApplication() {

        return new HomePage(driver);
    }
}

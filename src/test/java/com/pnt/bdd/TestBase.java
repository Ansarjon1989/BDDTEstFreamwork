package com.pnt.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestBase {

    public static WebDriver driver;

    public static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void validateCurrentURL(String expectedURL) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


}
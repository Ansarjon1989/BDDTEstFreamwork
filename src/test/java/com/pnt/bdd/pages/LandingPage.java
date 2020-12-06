package com.pnt.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage {

    @FindBy(xpath = "//img[@class='fb_logo _8ilh img']")
    private WebElement fbLogo;

    @FindBy(linkText = "Log In")
    private WebElement logInBtn;

    public void validateFBLogIsDisplayed() {
        Assert.assertTrue(fbLogo.isDisplayed());
    }

    public void clickOnLogInButton() {
        logInBtn.click();
    }
}

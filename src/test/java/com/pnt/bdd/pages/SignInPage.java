package com.pnt.bdd.pages;

import com.pnt.bdd.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInPage {

    @FindBy(xpath = "//img[@class='_97vu img']")
    private WebElement fbLogo;

    public void validateFbLogoIsDisplayOnSignInPage() {
        Assert.assertTrue(fbLogo.isDisplayed());

    }

    public void validateSignInPageURL(){
        TestBase.validateCurrentURL("https://www.facebook.com/signin/");
    }
}

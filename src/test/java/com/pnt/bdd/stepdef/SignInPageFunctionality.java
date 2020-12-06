package com.pnt.bdd.stepdef;


import com.pnt.bdd.TestBase;
import com.pnt.bdd.pages.SignInPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class SignInPageFunctionality {

    @Then("^user can see the login page is displayed$")
    public void user_can_see_the_login_page_is_displayed() {
        SignInPage signInPage = PageFactory.initElements(TestBase.driver, SignInPage.class);
        TestBase.sleepFor(5);
        signInPage.validateFbLogoIsDisplayedOnSignInPage();
    }
}

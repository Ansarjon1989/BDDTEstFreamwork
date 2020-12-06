package com.pnt.bdd.stepdef;

import com.pnt.bdd.TestBase;
import com.pnt.bdd.pages.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LandingPageFunctionality {
    private LandingPage landingPage;

    @Given("^user opens the browser and navigate to facebook\\.com$")
    public void user_opens_the_browser_and_navigate_to_facebook_com() {
        TestBase.setupBrowser();
        TestBase.driver.get("https://www.facebook.com");
        TestBase.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @When("^user see the facebook logo is displayed$")
    public void user_see_the_facebook_logo_is_displayed() {
        landingPage = PageFactory.initElements(TestBase.driver, LandingPage.class);
        landingPage.validateFBLogIsDisplayed();
    }

    @Then("^user clicks on the login button from the footer$")
    public void user_clicks_on_the_login_button_from_the_footer() {
        landingPage.clickOnLoginButtonFromFooter();
    }

    @Then("^user closes the browser$")
    public void user_closes_the_browser() {
        TestBase.driver.close();
    }


    @Then("^user provides (.*) and (.*) in the desired field$")
    public void user_provides_username_and_password_in_the_desired_field(String username, String password) {
        landingPage.fillUserNameAndPasswordField(username, password);
    }

    @Then("^user clicks on the login button$")
    public void user_clicks_on_the_login_button() {
        landingPage.clickOnLoginButton();
    }

    @Then("^user can see error message$")
    public void user_can_see_error_message() {
        landingPage.validateErrorLoginMessage();
    }

}
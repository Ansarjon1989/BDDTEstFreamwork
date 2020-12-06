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

    @Given("^user opens the browser and navigates to facebook.com$")
    public void user_opens_the_browser_and_navigates_to_facebook_com() {
        TestBase.setupBrowser();
        TestBase.driver.get("https://www.facebook.com");
        TestBase.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @When("^user see the facebook logo is displaying$")
    public void user_see_the_facebook_logo_is_displaying() {
        landingPage = PageFactory.initElements(TestBase.driver,LandingPage.class);
        landingPage.validateFBLogIsDisplayed();

    }

    @Then("^user clicks on login button from the footer$")
    public void user_clicks_on_login_button_from_the_footer() {
        landingPage.clickOnLogInButton();
    }

    @Then("^user closes the browser$")
    public void user_closes_the_browser(){
        TestBase.driver.close();
    }

}

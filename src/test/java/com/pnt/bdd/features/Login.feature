Feature: login functionality features

  Scenario: user being able to click on login button from the footer of the landing
    Given user opens the browser and navigates to facebook.com
    When user see the facebook logo is displaying
    Then user clicks on login button from the footer
    And user can see the login page is displayed
    Then user closes the browser

  #Scenario: user being able to click on signup button from the footer of the landing
    #Given user opens the browser and navigates to facebook.com
    #When user see the facebook logo is displaying
    #Then user clicks on signup button from the footer
    #And user can see the signup page is displayed
Feature: registration | As a user I should be able to sign up with new account

  Scenario: as a user I should sign up with valid credentials
    Given User can open the Chrome Browser
    And User can navigate to home page
    And User click on the register link
    When User Enter valid Your Personal Details
    And User Enter valid Password
    And User clicks on register button
    Then Success message is displayed
    And User quits driver

# Login feature review the behavior in this feature
Feature: Login

  Scenario: Home page is displayed once set credential in login page
    Given 'SSI Application' page is loaded
    And set "Admin" credentials on 'Login' page

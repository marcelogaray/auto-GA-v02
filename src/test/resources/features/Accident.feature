# Accident feature review the behavior in this feature
Feature: Accident

  Scenario: AC-01 Verify that an accident is created with required fields
    Given 'SSI Application' page is loaded
    And set "Admin" credentials on 'Login' page
    When go to accident Page
    And get list of accidents
    And go to create accident page
    And fill all required fields
      | Reagan Hatfield |
      | Gerencia General |
      | accident descript |
      | accident sev |
      | accident state |
      | accident used |
      | accident employee |
      | accident other employee |
      | 04/08/2017 |
    Then verify that one accident is added

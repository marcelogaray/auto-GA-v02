# Incident feature review the behavior in this feature
Feature: Incident

  Scenario: IN-01 Verify that an incident is created with required fields
    Given 'SSI Application' page is loaded
    And set "Admin" credentials on 'Login' page
    When go to incident Page
    And get list of incidents
    And go to create incident page
    And fill all required fields for Incident
      | Reagan Hatfield |
      | Gerencia General |
      | description |
      | severity |
      | material |
      | other |
      | 08/06/2018 |
    Then verify that one incident is added

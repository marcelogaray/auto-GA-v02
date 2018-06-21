# Accident feature review the behavior in this feature
Feature: Accident

  Scenario: AC-01 Verify that an accident is created with required fields
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When go to accident Page
    And go to create accident page
    And create an accident
      | enployee    | Reagan Hatfield         |
      | deparment   | Direccion de obra       |
      | description | accident descript       |
      | severity    | accident sev            |
      | state       | accident state          |
      | material    | accident used           |
      | senority    | accident employee       |
      | other       | accident other employee |
      | date        | 04/08/2017              |
    Then verify that new accident is added 1 in the list

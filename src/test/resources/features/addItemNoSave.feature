#Edit ItemType feature
Feature: Add Item page has 'Save' button disabled

  Scenario: RON007 TC - Ronald Tucuman - 07 - Verify 'Save' button is disabled when 'Add Item' page is opened
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Anadir Item' submenu option
    Then Verify 'Save' button status is "disabled" in 'Anadir Item' page

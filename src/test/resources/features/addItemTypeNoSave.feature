#Edit ItemType feature
Feature: Add Item Type page has 'Save' button disabled

  Scenario: RON005 TC - Ronald Tucuman - 05 - Add Item Type page has 'Save' button disabled when opened
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Anadir Tipo' submenu option
    Then Verify 'Save' button status is "disabled"

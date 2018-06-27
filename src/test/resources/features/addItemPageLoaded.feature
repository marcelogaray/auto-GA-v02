#Edit ItemType feature
Feature: Edit ItemType

  Scenario: RON006 TC - Ronald Tucuman - 06 - Verify that 'Add Item' page is loaded
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Anadir Item' submenu option
    Then Verify "Añadir Item" is the title of the Page

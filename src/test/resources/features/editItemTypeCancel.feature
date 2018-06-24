#Edit ItemType feature
Feature: Cancel Edit Item Type

  Scenario: AA02-Verify that Cancel edit Item Item Type does not change Item Type name
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    And Click 'Lista de Tipos' submenu option
    And Click 'Anadir Tipo de Item' button
    And Enter "Item Type for Testing 1" in Name input field
    And Click 'Save' button
    And Verify "Item Type for Testing 1" is in the list
    And Click 'Edit' button of "Item Type for Testing 1" row
    And Enter "Item Type for Testing 1 Updated" in Name input field
    When Click 'Cancel' button in Edit Item Type page
    Then Verify that "Item Type for Testing 1 Updated" does not exist in the list


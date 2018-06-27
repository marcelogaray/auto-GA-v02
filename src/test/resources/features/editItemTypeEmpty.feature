#Edit ItemType feature
Feature: EditItemType

  Scenario: RON002 TC - Ronald Tucuman - 02 - Verify that an Item Type can be deleted
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
    When Click 'Delete' button of "Item Type for Testing 1" row
    Then Verify that "Item Type for Testing 1" does not exist in the list


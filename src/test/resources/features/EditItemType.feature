#Edit ItemType feature
Feature: EditItemType
  Scenario: AA02-Verify that an Item Type can be edited
    Given Open web browser and enter the url of the application
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Main menu
    And Click 'Lista de Tipos' submenu option
    And Click 'Edit' button of the first element in the list
    And Set "New Item Type Name Test 1" as the new name for the item type
  When Click on 'Save' button
    Then Check first Item Type name is "New Item Type Name Test 1"


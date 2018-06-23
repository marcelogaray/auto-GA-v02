#Edit ItemType feature
Feature: EditItemType

  Scenario: AA02-Verify that an Item Type can be edited
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    And Click 'Lista de Tipos' submenu option
    And Click 'Edit' button of the row "1" in the list
    And Set "New Item Type Name Test 1" as the new name for the item type
    When Click 'Save' button
    Then Verify row "1" has "New Item Type Name Test 1" as name in Item Type list page

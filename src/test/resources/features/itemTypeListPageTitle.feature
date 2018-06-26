#Edit ItemType feature
Feature: EditItemType

  Scenario: AA02-Verify that an Item Type can be deleted
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Lista de Tipos' submenu option
    Then Verify that "Lista de Tipo de Item" is the title of the loaded page


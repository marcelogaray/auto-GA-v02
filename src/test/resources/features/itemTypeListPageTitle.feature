#Edit ItemType feature
Feature: EditItemType

  Scenario: RON003 TC - Ronald Tucuman - 03 - Verify that an Item Type List page can be  reached
    Given 'SSI Application' page is loaded
    And Click 'Login' button on Page Header
    And Enter Username
    And Enter Password
    And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Lista de Tipos' submenu option
    Then Verify that "Lista de Tipo de Item" is the title of the loaded page


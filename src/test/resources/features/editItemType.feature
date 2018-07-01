#Edit ItemType feature
Feature: EditItemType

  Scenario: RON001 TC - Ronald Tucuman - 01 - Verify that an Item Type can be edited
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
    And Click 'Edit' button of the row "1" in the list
    And Set "First Item Type" as the new name for the item type
    When Click 'Save' button


  Scenario: RON002 TC - Ronald Tucuman - 02 - Verify that an Item Type can be deleted
    Given 'SSI Application' page is loaded
    #And Click 'Login' button on Page Header
    #And Enter Username
    #And Enter Password
    #And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    And Click 'Lista de Tipos' submenu option
    And Click 'Anadir Tipo de Item' button
    And Enter "Item Type for Testing 2" in Name input field
    And Click 'Save' button
    And Verify "Item Type for Testing 2" is in the list
    When Click 'Delete' button of "Item Type for Testing 2" row
    Then Verify that "Item Type for Testing 2" does not exist in the list


  Scenario: RON003 TC - Ronald Tucuman - 03 - Verify that an Item Type List page can be  reached
    Given 'SSI Application' page is loaded
    #And Click 'Login' button on Page Header
    #And Enter Username
    #And Enter Password
    #And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Lista de Tipos' submenu option
    Then Verify that "Lista de Tipo de Item" is the title of the loaded page


  Scenario: RON004 TC - Ronald Tucuman - 04 - Verify that Cancel edit Item Item Type does not change Item Type name
    Given 'SSI Application' page is loaded
    #And Click 'Login' button on Page Header
    #And Enter Username
    #And Enter Password
    #And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    And Click 'Lista de Tipos' submenu option
    And Click 'Anadir Tipo de Item' button
    And Enter "Item Type for Testing 3" in Name input field
    And Click 'Save' button
    And Verify "Item Type for Testing 3" is in the list
    And Click 'Edit' button of "Item Type for Testing 3" row
    And Enter "Item Type for Testing 3 Updated" in Name input field
    When Click 'Cancel' button in Edit Item Type page
    Then Verify that "Item Type for Testing 3 Updated" does not exist in the list
    And Click 'Delete' button of "Item Type for Testing 3" name


  Scenario: RON005 TC - Ronald Tucuman - 05 - Add Item Type page has 'Save' button disabled when opened
    Given 'SSI Application' page is loaded
    #And Click 'Login' button on Page Header
    #And Enter Username
    #And Enter Password
    #And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Anadir Tipo' submenu option
    Then Verify 'Save' button status is "disabled"


  Scenario: RON006 TC - Ronald Tucuman - 06 - Verify that 'Add Item' page is loaded
    Given 'SSI Application' page is loaded
    #And Click 'Login' button on Page Header
    #And Enter Username
    #And Enter Password
    #And Click 'Login' button to accept credentials
    And Click 'Activos' menu in Navigation bar
    When Click 'Anadir Item' submenu option
    Then Verify "Añadir Item" is the title of the Page


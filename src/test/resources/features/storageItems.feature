Feature: ItemsOfStorage

  Scenario: S-04 Verify that the page of the list of items is displayed
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Almacenes' menu button on 'Navigation Bar' top menu
    When Click 'Ver activos' button of storage selected
    Then 'SSI' page with storage assets is loaded
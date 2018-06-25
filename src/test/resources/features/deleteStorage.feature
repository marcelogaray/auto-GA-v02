Feature: DeleteStorage

  Scenario: S-03 Verify that a store can be eliminated
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Almacenes' menu button on 'Navigation Bar' top menu
    When Click 'Eliminar' button
    Then The page the list of Storages ya no containing the Storage removed
Feature: Button Cancel

  Scenario: S-05 Verify that the cancel button allows you to return to the list of storages
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Almacenes' menu button on 'Navigation Bar' top menu
    And Click 'Agregar Nuevo Almacen' button
    When Click 'Cancelar' button
    Then The 'SSI' page with the storage list should be loaded
Feature: CreateStorage

  Scenario: S-01 Verify that a store can be added to the required fields
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Almacenes' menu button on 'Navigation Bar' top menu
    And Click 'Agregar Nuevo Almacen' button
    And Enter a store name in the "Nombre de Almacen" field
    When Click 'Guardar' button
    Then The page should redirect to the list of Storages containing the new Storage
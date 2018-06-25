Feature: EditStorage

  Scenario: S-01 Verify that a store can be edited
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Almacenes' menu button on 'Navigation Bar' top menu
    And Click 'Editar' button
    And Enter a store new name in the "Nombre de Almacen" field
    When Click in 'Guardar' button
    Then The page should redirect to the list of Storages containing the new Storage Edited
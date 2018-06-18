Feature: CreateStorage

  Scenario: S-01 Verify that storage can be created with required fields
    Given 'SSI' page is loaded
    And Click on "Almacenes" menu button
    And Click on "Agregar Nuevo Almacen" Button
    And Write the name of a storage in the "Nombre de almacen" field
    When Click on "Guardar" button to save the Storage
    Then The Storage should be added and the number of Storage increased
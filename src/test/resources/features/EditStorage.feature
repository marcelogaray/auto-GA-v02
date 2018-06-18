Feature: EditStorage

  Scenario: S-01 Verify that storage can be edited with required fields
    Given 'SSI' page is loaded correctly
    And Click on list "Almacenes" menu button
    And Click on "Editar" Button of Storage selected
    And Write the new name of a storage in the "Nombre de almacen" field
    When Click on "Guardar" button to save the Storage with the new values
    Then The Storage should be edited
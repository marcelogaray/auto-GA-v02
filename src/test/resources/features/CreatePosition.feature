Feature: CreatePosition

  Scenario: EO-10 Verify that a position cannot be created without required fields
    Given 'SSI' page is loaded
    And User is authenticated
    And I click on "Estructura Organizacional" menu button
    And I click on "Cargos" option
    And I click on "Agregar Nueva Position" Button
    When I click on "Guardar" button without fill required fields
    Then The page title should be the same

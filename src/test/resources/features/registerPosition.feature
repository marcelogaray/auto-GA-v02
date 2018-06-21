Feature: registerPosition
#Verificar que una posicion no puede ser creada si los campos requeridos no son llenados
  Scenario: Verify that a position cannot be created if all the required fields are not filled
    Given 'SSI' page is loaded
    And Click on 'Estructura Organizacional' menu button
    And Click on 'Cargos' option from list menu
    And Click on 'Agregar Nueva Position' Button in list position page
    When Click on 'Guardar' button without required fields filled
    Then The page title should be "Registrar Posiciones en la Empresa"
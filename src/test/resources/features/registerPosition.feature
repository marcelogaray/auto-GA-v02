Feature: registerPosition
#Verificar que una posicion no puede ser creada si los campos requeridos no son llenados
  Scenario: Verify that a position cannot be created if the required fields are not filled
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And Click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    And Click 'Agregar Nueva Position' button on 'Lista de Posiciones' page
    When Click 'Guardar' button without required fields filled on 'Registrar Posicion en la empresa' page
    Then The page title should be "Registrar Posiciones en la Empresa"
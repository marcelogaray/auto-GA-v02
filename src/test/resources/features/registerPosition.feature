Feature: registerPosition
#Verificar que una posicion no puede ser creada si los campos requeridos no son llenados
  Scenario: EO-10 - Ines Baina - Verificar que una posicion no puede ser creada si los campos requeridos no son llenados
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    And click 'Agregar Nueva Position' button on 'Lista de Posiciones' page
    And click 'Guardar' button without required fields filled on 'Registrar Posicion en la empresa' page
    Then the page title should be "Registrar Posiciones en la Empresa"

Feature: updatePosition
#Verificar que despues de seleccionar "Editar" una position la pagina de modificar es cargada
  Scenario: EO-13 - Ines Baina - Verificar que despues de seleccionar "Editar" una position la pagina de modificar es cargada
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    And click 'Editar' option from Position list on 'Lista de Posiciones' page of element 1
    Then the 'Actualizar Posiciones en la Empresa' page should contain the "Guardar" button

Feature: listPosition
#Verificar que la pagina de la lista de posiciones es mostrada
  Scenario: EO-14 - Ines Baina - Verificar que la pagina de la lista de posiciones es mostrada
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    When click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    Then the page loaded should contains the "Posicion del empleado de la empresa" title
Feature: deletePosition
#Verificar que una Posicion puede ser eliminada
  Scenario: EO-12 TC - InesBaina - 03
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    When click 'Eliminar' button on 'Lista de Posiciones' page of element 1
    Then the page should not display the element removed on 'Lista de Posiciones' page

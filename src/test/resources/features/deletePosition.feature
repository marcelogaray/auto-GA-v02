Feature: deletePosition
#Verificar que una Posicion asignada a un departamento no puede ser eliminada
  Scenario: EO-12 TC - InesBaina - 03
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    When click 'Eliminar' button on 'Lista de Posiciones' page of element 1
    Then after delete a position the same number of elements should be displayed

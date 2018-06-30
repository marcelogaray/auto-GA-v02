Feature: deletePosition
#Verificar que una Posicion al ser eliminada la 'Lis de posiciones' es mostrada
  Scenario: EO-12 TC - InesBaina - 03
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Cargos' option from list menu on 'Estructura Organizacional' submenu
    When click 'Eliminar' button on 'Lista de Posiciones' page of element 1
    Then the page should display the same "Posicion del empleado de la empresa" page

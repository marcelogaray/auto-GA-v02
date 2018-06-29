Feature: unassignItem
#Verificar que la opcion "Devolver" es mostrada en la lista de activos asignados
  Scenario:  AA21 TC - InesBaina - 06
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    When click 'Detail' button of an active employee in 'Employees List' page
    Then the 'Devolver' button should be displayed in 'Activos Asignados' section of Employee Detail page
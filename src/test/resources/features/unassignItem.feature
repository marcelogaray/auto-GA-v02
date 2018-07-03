Feature: unassignItem
#Verificar que la opcion "Devolver" es mostrada en la lista de activos asignados
  Scenario:  AA21 - Ines Baina - Verificar que la opcion "Devolver" es mostrada en la lista de activos asignados
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    Then the 'Devolver' button should be displayed in 'Activos Asignados' section of Employee Detail page
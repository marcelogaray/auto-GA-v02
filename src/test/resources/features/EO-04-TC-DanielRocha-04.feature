Feature: EO-04-Employee List

  Scenario: EO-04 Verificar que se muestre la lista de empleados
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    Then 'Lista de Empleados' Title should be showed on 'Employee List' page

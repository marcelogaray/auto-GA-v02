Feature: Edit Employee

  Scenario: EO-03 Verificar si se puede actualizar los datos de un empleado
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'editar empleado' button in 'Employees List' page
    When 'Employee Form' page is edited with new employee data
    Then 'Actualizar' button should be clicked

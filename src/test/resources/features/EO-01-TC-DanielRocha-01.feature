Feature: New Employee

  Scenario: EO-01 Verificar si un empleado fue creado proporcionando los campos requeridos
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'agregar empleado' button in 'Employees List' page
    When 'Employee Form' page is fill with new employee data
    Then 'Registrar' button should be clicked

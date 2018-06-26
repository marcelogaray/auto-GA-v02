Feature: EO-02-Drop Employee

  Scenario: EO-02 Verificar que un empleado seleccionado fue eliminado
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    When an 'Employee' is selected to be deleted on 'Employee List' page
    Then 'delete employee' button should be clicked

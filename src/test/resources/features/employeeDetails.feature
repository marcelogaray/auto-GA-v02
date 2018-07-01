Feature: employeeDetails
#Verificar que Employee Details page displays the "Activos Asignados" section
  Scenario:  AA22 Verificar que Employee Details page displays the "Activos Asignados" section
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    When click 'Detail' button of an active employee in 'Employees List' page
    Then the "Activos Asignados" section should be displayed in 'Employee Detail' page

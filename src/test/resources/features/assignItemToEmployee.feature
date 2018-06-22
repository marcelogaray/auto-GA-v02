Feature: AssignItemToEmployee

  Scenario: AA-13 Verify that an item cannot be assigned to an employee if the required fields are not filled
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar' button on 'Employee Detail' page
    Then 'Asignar' button should be disabled
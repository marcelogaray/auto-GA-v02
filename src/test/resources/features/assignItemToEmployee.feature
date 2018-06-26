Feature: AssignItemToEmployee

  Scenario: AA-13 TC-DiegoMaiz-01
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Asignar' button should be disabled in the modal displayed

  Scenario: AA-18 TC-DiegoMaiz-08
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    When click 'Detail' button of an active employee in 'Employees List' page
    Then 'Asignar Activo' button should exist in 'Employee Detail' page
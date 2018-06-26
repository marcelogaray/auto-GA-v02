Feature: AssignItemToEmployee

  Scenario: AA-13 TC-DiegoMaiz-01
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Asignar' button should be disabled in the modal displayed

  Scenario: AA-12 TC-DiegoMaiz-03
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    When click 'Cancelar' button on 'Assign Item' modal
    Then the page title should be "Perfil de Empleado"
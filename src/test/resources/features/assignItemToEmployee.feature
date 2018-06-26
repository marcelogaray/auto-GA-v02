Feature: AssignItemToEmployee

  Scenario: AA-13 TC-DiegoMaiz-01
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Asignar' button should be disabled in the modal displayed

  Scenario: AA-16 TC-DiegoMaiz-06
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    And click 'Estado del activo' dropdown in assign item modal
    And select any state
    And click 'Activo' dropdown in assign item modal
    When select any item
    Then 'Asignar' button should be enabled in the modal displayed
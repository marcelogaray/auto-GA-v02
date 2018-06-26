Feature: AssignItemToEmployee

  Scenario: AA-13 TC-DiegoMaiz-01
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Asignar' button should be disabled in the modal displayed
  Scenario: AA-11 TC-DiegoMaiz-02
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then modal title should be "Asignacion de Activo"
  Scenario: AA-12 TC-DiegoMaiz-03
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    When click 'Cancelar' button on 'Assign Item' modal
    Then the page title should be "Perfil de Empleado"
  Scenario: AA-14 TC-DiegoMaiz-04
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Estado del activo' dropdown should exist
  Scenario: AA-15 TC-DiegoMaiz-05
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    When click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Activo' dropdown should exist
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
    And select any item
    Then 'Asignar' button should be enabled in the modal displayed
  Scenario: AA-17 TC-DiegoMaiz-07
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    And click 'Estado del activo' dropdown in assign item modal
    And select any state
    And click 'Activo' dropdown in assign item modal
    And select any item
    And click 'Asignar' button in assign item modal
    Then the list of 'Assigned items' should increase in one
  Scenario: AA-18 TC-DiegoMaiz-08
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    When click 'Detail' button of an active employee in 'Employees List' page
    Then 'Asignar Activo' button should exist in 'Employee Detail' page

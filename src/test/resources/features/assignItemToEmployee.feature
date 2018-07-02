Feature: AssignItemToEmployee

  Scenario: AA-13 Verificar que el boton "Asignar" esta deshabilitado si no se llenaron los campos requeridos
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Asignar' button should be disabled in the modal displayed

  Scenario: AA-11 Verificar que se despliegue un modal cuando se intente asignar un activo a un empleado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    Then modal title should be "Asignacion de Activo"

  Scenario: AA-12 Verificar que al cancelar la asignacion de un activo se muestre el perfil del empleado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    And click 'Cancelar' button on 'Assign Item' modal
    Then the current page title should be "Perfil de Empleado"

  Scenario: AA-14 Verificar que el modal desplegado al asignar un activo a un empleado contenga el campo "Estado del Activo"
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Estado del activo' dropdown should exist

  Scenario: AA-15 Verificar que el modal desplegado al asignar un activo a un empleado contenga el campo "Activo"
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    Then 'Activo' dropdown should exist

  Scenario: AA-16 Verificar que el boton "Asignar Activo" esta habilitado si se llenaron los campos requeridos
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    And click 'Estado del activo' dropdown in assign item modal
    And select any state
    And click 'Activo' dropdown in assign item modal
    And select any item
    Then 'Asignar' button should be enabled in the modal displayed

  Scenario: AA-17 Verificar que al asignar un activo a un empleado este es adicionado en la seccion items asignados del perfil del empleado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    And click 'Asignar Activo' button on 'Employee Detail' page
    And click 'Estado del activo' dropdown in assign item modal
    And select any state
    And click 'Activo' dropdown in assign item modal
    And select any item
    And click 'Asignar' button in assign item modal
    Then the list of 'Assigned items' should increase in one

  Scenario: AA-18 Verificar el boton "Asignar Activo" esta disponible en el perfil de un empleado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Empleados' option on 'Estructura Organizacional' submenu
    And click 'Detail' button of an active employee in 'Employees List' page
    Then 'Asignar Activo' button should exist in 'Employee Detail' page

Feature: AssignItemToEmployee

  Scenario: AA-12 Verify that a modal is displayed when assigning an item to employee
    Given 'SSI' page is loaded
    And User is authenticated
    And I click on Estructura Organizacional menu button
    And I click on Empleados option
    And I click on Employee Detail button
    When I click on Cancelar button
    Then Employee's profile should be displayed
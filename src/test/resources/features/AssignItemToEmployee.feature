Feature: AssignItemToEmployee

#space
  Scenario: AA-13 Verify that an item cannot be assigned to an employee if the required fields are not filled
    Given 'SSI' page is loaded
    And User is authenticated

#space
    And I click on Estructura Organizacional menu button
    And I click on Empleados option
    And I click on Employee Detail button
    And I click on Asignar Activo button
    When Fields are empty
    Then Asignar button should be disabled
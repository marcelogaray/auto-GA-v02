Feature: EO-05-New Contract

  Scenario: EO-05 Verificar si se puede crear un contrato
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Contratos' option on 'Estructura Organizacional' submenu
    When 'Contracts Form' page is fill with new employee data
    Then 'Registrar' button should be clicked on 'Contracts form' page
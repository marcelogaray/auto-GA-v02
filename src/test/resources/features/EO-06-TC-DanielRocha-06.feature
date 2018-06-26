Feature: EO-06- Contracts

  Scenario: EO-06 Verificar si se puede crear un contrato SIN los campos requeridos
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    And click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Contratos' option on 'Estructura Organizacional' submenu
    When 'Contracts Form' page is fill with some employee data
    Then 'Registrar' button should be HIDE on 'Contracts form' page

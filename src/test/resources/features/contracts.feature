Feature: EO-06- Contracts

  Scenario: EO-06 Verificar si se puede crear un contrato SIN los campos requeridos
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu
    And click 'Contratos' option on 'Estructura Organizacional' submenu
    And 'Contracts Form' page is filled with contract data
    Then 'Registrar' button should be HIDE on 'Contracts form' page
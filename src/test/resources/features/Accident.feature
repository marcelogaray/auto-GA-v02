# Accident feature review the behavior in this feature
Feature: Accident

  Scenario: AC-01 Verificar que un accidente es creado
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And click 'Create Accident' button on 'Accidente' page
    And fill 'Accident' form on 'Registro Accidente' page
      | enployee    | Reagan Hatfield         |
      | deparment   | Direccion de obra       |
      | description | accident desc           |
      | severity    | accident sev            |
      | state       | accident state          |
      | material    | accident used           |
      | senority    | accident employee       |
      | other       | accident other employee |
      | date        | 04/08/2017              |
    Then verify that new accident is added in the list
    And verify accident desc description for new accident

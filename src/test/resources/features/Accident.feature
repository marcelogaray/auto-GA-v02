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

  Scenario: AC-12 verificar que un accidente no es creado cuando presionamos el buton cancel
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And click 'Create Accident' button on 'Accidente' page
    And click on 'atras' button on 'registrar accidente' page
    Then verify that accident is not added in the list

  Scenario: AC-02 Verificar que un accidente es eliminado
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And delete accident from position 1
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    Then verify that one Accident was removed in the list

  Scenario: AC-03 verificar que un accidente es modificado
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And edit accident from position 1
    And edit 'Accident' form on 'Modificar Accidente' page
      | enployee    | Reagan Hatfield        |
      | deparment   | Direccion de obra      |
      | description | accident desc edit     |
      | severity    | accident sev edit      |
      | material    | accident used edit     |
      | state       | accident state ediy    |
      | senority    | accident employee edit |
      | other       | other edit             |
      | date        | 04/09/2017             |
    Then verify that 1 Accident is modified

  Scenario: AC-14 verificar que un accidente puede ser buscado por su severidad
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And select severity search filter option on 'Accidente' page
    And set bajo search filter value on 'Accidente' page
    And click on search button on 'Accidente' page
    Then verify that accident are filer by bajo severity

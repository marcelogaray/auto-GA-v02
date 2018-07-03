Feature: Accident

  Scenario: AC-01 Verificar que un accidente es creado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And click 'Create Accident' button on 'Accidente' page
    And fill 'Accident' form on 'Registro Accidente' page
      | enployee    | Reagan Hatfield         |
      | deparment   | Direccion de obra       |
      | description | dolor de espalda baja   |
      | severity    | accident sev            |
      | state       | accident state          |
      | material    | accident used           |
      | senority    | accident employee       |
      | other       | accident other employee |
      | date        | 04/08/2017              |
    And click 'guardar' button on 'Registro Accidente' page
    Then verify that new accident is added in the list
    And verify 'dolor de espalda baja' description for new accident

  Scenario: AC-12 verificar que un accidente no es creado cuando presionamos el buton cancel
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And click 'Create Accident' button on 'Accidente' page
    And fill 'Accident' form on 'Registro Accidente' page
      | enployee    | Reagan Hatfield         |
      | deparment   | Direccion de obra       |
      | description | description value       |
      | severity    | accident sev            |
      | state       | accident state          |
      | material    | accident used           |
      | senority    | accident employee       |
      | other       | accident other employee |
      | date        | 04/08/2017              |
    And click 'atras' button on 'Registro Accidente' page
    Then verify that accident with 'description value' description is not added in the list

  Scenario: AC-02 Verificar que un accidente es eliminado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And delete accident with 'dolor de espalda baja' description
    And click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    Then verify that accident with 'dolor de espalda baja' description is not added in the list

  Scenario: AC-03 verificar que un accidente es modificado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And edit accident from position '1'
    And edit 'Accident' form on 'Modificar Accidente' page
      | enployee    | Reagan Hatfield        |
      | deparment   | Direccion de obra      |
      | description | dolor de espalda       |
      | severity    | accident sev edit      |
      | material    | accident used edit     |
      | state       | accident state ediy    |
      | senority    | accident employee edit |
      | other       | other edit             |
      | date        | 04/04/2017             |
    Then verify that '1' Accident is modified

  Scenario: AC-14 verificar que un accidente puede ser buscado por su severidad
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And select 'severity' search filter option on 'Accidente' page
    And set 'bajo' search filter value on 'Accidente' page
    And click on 'Buscar' button on 'Accidente' page
    Then verify that accident are filter by 'bajo' severity

  Scenario: AC-04 verificar que el boton 'guardar' esta desabilitado por defecto en la vista crear accidente
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And click 'Create Accident' button on 'Accidente' page
    Then verify that 'guardar' button is disabled by default on 'Register Accidente' page

  Scenario: AC-05 verificar que el boton 'modificar' esta abilitado por defecto en la pagina modificar accidente
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And edit accident from position '1'
    Then verify that 'mofificar' button is enabled by default on 'modificar Accidente' page

  Scenario: AC-09 verificar que un mensaje es mostrado cuando el campo severidad esta vacio
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Accidente' option on 'Accidente e Incidentes' menu
    And click 'Create Accident' button on 'Accidente' page
    And click 'severidad' field into 'accident' form on 'registro accidente' page
    And click 'estado' field into 'accident' form on 'registro accidente' page
    Then verify that 'severity' error message is displayed


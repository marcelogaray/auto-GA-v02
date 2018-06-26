# Accident feature review the behavior in this feature
Feature: Plan de Contingencias

  Scenario: PC-01 Verificar que un plan de contingencia es creado
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And click 'Crear Plan de continegcia' button on 'Plan de Contigencia' page
    And fill 'plan de contingencia' form on 'Registro Plan de contingencias' page
      | accident     | irritacion en la vista                                                         |
      | standartName | Direccion de obrauso de mallas de proteccion en las contructiones              |
      | material     | gafas                                                                          |
      | penalties    | 2 semana suspendidio del trabajo                                               |
      | description  | uso de mallas de proteccion para evitar la caide de esconbros fuera de la obra |
      | date         | 05/17/2018                                                                     |
    Then verify that new Contingency plan is added in the list
    And verify irritacion en la vista accident name for new Contingency Plan

  Scenario: PC-02 Verificar que un plan de contingencia es eliminado
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And delete Contingency plan from position 1
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    Then verify that Contingency Plan was removed in the list

  Scenario: PC-03 verificar que un plan de contingencia es modificado
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And edit contigency plan from position 1
    And edit 'Contingency Plan' form values on 'Modificar plan de contingencia' page
      | accident     | irritacion en la vista     |
      | standartName | Direccion de obras updated |
      | material     | gafas updated              |
      | penalties    | 2 semanas updated          |
      | description  | uso de mallas updated      |
    Then verify that Contingency at position 1 is modified

  Scenario: PC-13 verificar que plan de contingencia puede ser buscado por su penalidad
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And select Penalidad search filter option on 'Plan de Contingencia' page
    And set 2 semana suspendidio del trabajo search filter value on 'Plan de Contingencia' page
    And click on search button on 'Plan de Contingencia' page
    Then verify that Contingency plans are filter by 2 semana suspendidio del trabajo penalties

  Scenario: PC-04 verificar que el boton 'guardar' esta desabilitado por defecto en la vista crear plan de contingencia
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And click 'Crear Plan de continegcia' button on 'Plan de Contigencia' page
    Then verify that 'guardar' button is disabled by default on 'Registro plan de contingencia' page

  Scenario: PC-05 verificar que el boton modificar esta abilitado por defecto
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And edit contigency plan from position 1
    Then verify that 'mofificar' button is enabled by default on 'modificar plan de contingencia' page

  Scenario: PC-09 verificar que un mensaje es mostrado cuando el campo 'nombre plan de contingencia' esta vacio
    When click 'Accidente e Incidentes' menu on 'NavigationBar' top menu
    And click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu
    And click 'Crear Plan de continegcia' button on 'Plan de Contigencia' page
    And click standart name field into 'contingency' form on 'registro plan de contingencia' page
    And click description field into 'contingency' form on 'registro plan de contingencia' page
    Then verify that 'standart name' error message is displayed

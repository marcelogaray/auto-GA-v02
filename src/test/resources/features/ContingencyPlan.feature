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

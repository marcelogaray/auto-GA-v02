# Storage feature
Feature: Storage

  Scenario: S-01 Verificar que la lista de almacenes de muestra
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Almacenes' menu on 'NavigationBar' top menu
    Then the page loaded should contains the "Almacenes" title main

  Scenario: S-02 Verificar que un almacen es creado
    Given 'SSI Application' page is loaded
    And user is authenticated with administrator credentials
    When click 'Almacenes' menu on 'NavigationBar' top menu
    And click 'Agregar Almacen' button on 'Storage' page
    And fill 'Storage' form on 'Registro Accidente' page
      | name | Equipo de reserva |
    Then verify that new storage is added in the list
    And verify name for new storage

  Scenario:  S-03 Verificar cabecera de reporte de almacenes
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Reportes' menu button on 'Navigation Bar' top menu
    When click 'Reporte de Alamacenes' option on 'Reportes' submenu
    Then the header of the storage report should contain the "Almacen" title
    And "Item" title as second column
    And "Marca" title as third column
    And "Tipo" title as fourth column

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
    And verify 'Equipo de reserva' name for new storage

  Scenario: S-03 Verificar cabecera de reporte de almacenes
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Reportes' menu button on 'Navigation Bar' top menu
    When click 'Reporte de Almacenes' option on 'Reportes' submenu
    Then the header of the storage report should contain the "Almacen" title
    And "Item" title as second column
    And "Marca" title as third column
    And "Tipo" title as fourth column

  Scenario: S-04 Verificar que un Almacen no es creado al presionar el boton cancelar
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Almacenes' menu on 'NavigationBar' top menu
    When click 'Agregar Almacen' button on 'Storage' page
    And click on 'Cancelar' button on 'Agregar Almacen' page
    Then verify that almacen is not added in the list

  Scenario: S-05 Verificar que un almacen es eliminado
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Almacenes' menu on 'NavigationBar' top menu
    And delete storage from position '3'
    Then verify that Storage was deleted in the list

  Scenario: S-06 Verificar que un almacen es modificado con el campo requerido
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    When click 'Almacenes' menu on 'NavigationBar' top menu
    And click on the edit button of the storage location '0'
    And edit 'Storage' form on 'Editar Almacen' page
      | name | Proteccion ultra personal |
    Then verify that '0' Storage is modified

  Scenario: S-07 Verificar que el boton 'Guardar' no esta disponible si el campo 'Nombre' esta vacio
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Almacenes' menu on 'NavigationBar' top menu
    When click 'Agregar Almacen' button on 'Storage' page
    Then verify that the 'Guardar' button is not available if the 'Nombre de Almacen' text field is empty

  Scenario: S-08 Verificar que la lista de reporte de almacenes es cargada
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Reportes' menu button on 'Navigation Bar' top menu
    When click 'Reporte de Almacenes' option on 'Reportes' submenu
    Then the page loaded must contain as title "Reporte de activos y almacenes"
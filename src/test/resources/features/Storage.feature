# Storage feature
Feature: Accident

  Scenario: S-01 Verificar que un almacen es creado
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When Click 'Almacenes' menu on 'NavigationBar' top menu
    And Click 'Agregar Almacen' button on 'Storage' page
    And Fill 'Storage' form on 'Registro Accidente' page
      | name | Equipo de reserva |
    Then Verify that new storage is added in the list
    And Verify name for new storage


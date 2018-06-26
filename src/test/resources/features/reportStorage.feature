Feature: ReportStorage

  Scenario: S-08 Verify that the 'Reporte de Almacenes' button shows the report list
    Given 'SSI' page is loaded
    And User is authenticated with administrator credentials
    And Click 'Reportes' menu button on 'Navigation Bar' top menu
    When Click 'Reporte de almacenes' option on 'Reportes' submenu
    Then 'Storage Item Details' page is loaded
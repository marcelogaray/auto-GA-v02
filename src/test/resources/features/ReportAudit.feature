Feature: reportAudit

  Scenario: R0003 Verificar que se puede identificar los usuarios que realizaron modificaciones en datos del programa.
    Given 'SSI' loaded
    And User is authenticated in portal
    And "salary" of the "Lavonne" employee is updated to "10000"
    And click on "Reports" menu button
    When click on "ReporteDeModificacionesDeDatos" submenu Button
    Then The update in "employee" should be displayed in the table
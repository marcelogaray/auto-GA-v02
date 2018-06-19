Feature: reportAudit

  Scenario: R0003 Verificar que se puede identificar los usuarios que realizaron modificaciones en datos del programa.
    Given 'SSI' loaded
    And User is authenticated in portal
    And click on "Reports" menu button
    When click on "ReporteDeModificacionesDeDatos" submenu Button
    Then The list of modification should be displayed
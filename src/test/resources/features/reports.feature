Feature: reports
#Verificar que el reporte de activos disponibles muestra en la cabecera "Codigo", "Nombre de Material" y "Estado"
  Scenario:  ROO1 TC - InesBaina - 08
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Reportes' menu button on 'Navigation Bar' top menu
    When click 'Activos Disponibles' option on 'Reportes' submenu
    Then the header of the report should contain the "Codigo" title
    And the "Nombre de Material" title as second column
    And the "Estado" title as third column

#Verificar que el reporte de activos devueltos muestra en la cabecera "Nombre(s)", "Apellido(s)", "Codigo del Activo",
#"Nombre del Activo", "Estado Devolucion" y "Fecha devolucion"
  Scenario:  ROO2 TC - InesBaina - 09
    Given 'SSI' page is loaded
    And user is authenticated with administrator credentials
    And click 'Reportes' menu button on 'Navigation Bar' top menu
    When click 'Activos Devueltos' option on 'Reportes' submenu
    Then the header of the  'Activos Devueltos' report should contain the "Nombre(s)" title
    And the "Apellido(s)" title as second column of the  'Activos Devueltos' report
    And the "Codigo del Activo" title as third column of the  'Activos Devueltos' report
    And the "Nombre del Activo" title as fourth column of the  'Activos Devueltos' report
    And the "Estado Devolucion" title as fifth column of the  'Activos Devueltos' report
    And the "Fecha devolucion" title as sixth column of the  'Activos Devueltos' report

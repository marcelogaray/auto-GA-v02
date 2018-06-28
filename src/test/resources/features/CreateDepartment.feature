Feature: department

  Scenario: DEP0001 Verificar que se puede crear 1 departamento.
    Given 'SSI' loaded for department
    And User is authenticated in portal para departamentos
    And click on "Estructura Organizacional" menu button de department menu
    And click on "Departamentos" submenu Button de departament submenu
    And click on "Agregar Nuevo Departamento" Button de department page
    And "nuevoDepartamento" es provisto como nombre de departamento
    And "Direccion de obra" es seleccionado como padre
    When se realiza click en boton "Registrar"
    Then El "departamento" es registrado en la base de datos y listado en "lista de Departamentos"
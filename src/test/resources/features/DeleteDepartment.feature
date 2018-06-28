Feature: department

  Scenario: DEP0002 Verificar que se puede eliminar 1 departamento.
    Given 'SSI' loaded for delete department
    And User is authenticated in portal para delete departamentos
    And click on "Estructura Organizacional" menu button de delete department menu
    And click on "Departamentos" submenu Button de delete departament submenu
    And click on "Agregar Nuevo Departamento" Button de delete departamento page
    And "departamento a eliminar" es provisto como nombre de delete departamento
    And se realiza click en boton "Registrar" de delete departamento
    And El "departamento a eliminar" es registrado en la base de datos y listado en "lista de Departamentos" de delete departamento
    When El "departamento a eliminar" Departamento es eliminado de la lista
    Then El "departamento a eliminar" no se lista en la  lista
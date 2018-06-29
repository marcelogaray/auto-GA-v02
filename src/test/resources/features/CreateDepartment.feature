Feature: department

  Scenario: DEP0001 Verificar que se puede crear 1 departamento.
    Given 'SSI' loaded for department
    And User is authenticated in portal for departments
    And click on "Estructura Organizacional" menu button de department menu
    And click on "Departamentos" submenu Button de department submenu
    And click on "Agregar Nuevo Departamento" Button de department page
    And "nuevoDepartamento" es provisto como nombre de departamento
    And "Direccion de obra" es seleccionado como padre
    When se realiza click en boton "Registrar"
    Then El "nuevoDepartamento" es registrado en la base de datos y listado en "lista de Departamentos"
    And El "nuevoDepartamento" Departamento es eliminado de la lista

  Scenario: DEP0002 Verificar que se puede eliminar 1 departamento.
    Given 'SSI' loaded for department
    And User is authenticated in portal for departments
    And click on "Estructura Organizacional" menu button de department menu
    And click on "Departamentos" submenu Button de department submenu
    And click on "Agregar Nuevo Departamento" Button de department page
    And "departamento a eliminar" es provisto como nombre de departamento
    And se realiza click en boton "Registrar"
    And El "departamento a eliminar" es registrado en la base de datos y listado en "lista de Departamentos"
    When El "departamento a eliminar" Departamento es eliminado de la lista
    Then El "departamento a eliminar" no se lista en la  lista

  Scenario: DEP0003 Verificar que se puede editar 1 departamento.
    Given 'SSI' loaded for department
    And User is authenticated in portal for departments
    And click on "Estructura Organizacional" menu button de department menu
    And click on "Departamentos" submenu Button de department submenu
    And click on "Agregar Nuevo Departamento" Button de department page
    And "departamentoToEdit" es provisto como nombre de departamento
    And "Direccion de obra" es seleccionado como padre
    And se realiza click en boton "Registrar"
    And Click boton Edit para el "departamentoToEdit" a editar
    When se Actualiza el nombre del  departamento a "departmentEdited", se adiciona "Almacenes" como padre y click "Guardar"
    Then Notar que la actualizacion "departmentEdited" se registra en la lista de departamentos
    And El "departmentEdited" Departamento es eliminado de la lista


  Scenario: DEP0004 Verificar que se pueden  asignar hijos a un departamento.
    Given 'SSI' loaded for department
    And User is authenticated in portal for departments
    And click on "Estructura Organizacional" menu button de department menu
    And click on "Departamentos" submenu Button de department submenu
    And click on "Agregar Nuevo Departamento" Button de department page
    And "departamento with child" es provisto como nombre de departamento
    And "Direccion de obra" es seleccionado como padre
    And se realiza click en boton "Registrar"
    And Click boton Edit para el "departamento with child" a editar
    When se Actualiza el nombre del  departamento a "departamento with child", se adiciona "Almacenes" como child y click "Guardar"
    Then Notar que el  child "Almacenes" tiene como parent "departamento with child" se registra en la lista de departamentos
    And El "departamento with child" Departamento es eliminado de la lista

package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private static Login login;
    private static NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private AssignEmployeeItemModal assignEmployeeItemModal;

    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^user is authenticated with administrator credentials$")
    public void userIsAuthenticatedWithAdministratorCredentials() throws Throwable {
        if (navigationBar == null) {
            navigationBar = login.setCredentials();
        }
    }

    @And("^click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu$")
    public void clickEstructuraOrganizacionalMenuButton() throws Throwable {
        organizationalStructureMenu = navigationBar.clickOrganizationalStructure();
    }

    @And("^click 'Empleados' option on 'Estructura Organizacional' submenu$")
    public void clickEmpleadosOption() throws Throwable {
        employeesSubMenu = organizationalStructureMenu.clickEmployees();
    }

    @And("^click 'Detail' button of an active employee in 'Employees List' page$")
    public void clickDetailButtonOfAnActiveEmployee() throws Throwable {
        employeeDetail = employeesSubMenu.clickEmployeeDetail();
    }

    @When("^click 'Asignar Activo' button on 'Employee Detail' page$")
    public void clickAsignarActivoButton() throws Throwable {
        assignEmployeeItemModal = employeeDetail.clickAssignEmployeeItem();
    }

    @Then("^'Asignar' button should be disabled in the modal displayed$")
    public void asignarActivoButtonShouldBeDisabled() throws Throwable {
        Assert.assertFalse(assignEmployeeItemModal.isAssignButtonEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_DISABLE, "Asignar"));
    }

    @Then("^'Asignar Activo' button should exist in 'Employee Detail' page$")
    public void asignarActivoButtonShouldExistInEmployeeDetailPage() throws Throwable {
        Assert.assertTrue(employeeDetail.hasAssignItemButton(), String.format(ErrorMessage.ERROR_MESSAGE_BUTTON_SHOULD_EXIST_IN_PAGE, "Asignar Activo", "Employee Detail"));
    }
}

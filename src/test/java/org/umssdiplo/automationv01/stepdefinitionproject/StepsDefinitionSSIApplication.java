package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.ContractRegister;
import org.umssdiplo.automationv01.core.managepage.EmployeeRegister;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private Login login;
    private NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private ContractRegister contractRegister;
    private EmployeeRegister employeeRegister;
    private AssignEmployeeItemModal assignEmployeeItemModal;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set Admin credentials on 'Login' page$")
    public void setCredentialsOnLoginPage() throws Throwable {
        navigationBar = login.setCredentials();
    }

    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^User is authenticated with administrator credentials$")
    public void userIsAuthenticatedWithAdministratorCredentials() throws Throwable {
        navigationBar = login.setCredentials();
    }

    @And("^click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu$")
    public void clickEstructuraOrganizacionalMenuButton() throws Throwable {
        organizationalStructureMenu = navigationBar.clickOrganizationalStructure();
    }

    @And("^click 'Empleados' option on 'Estructura Organizacional' submenu$")
    public void clickEmpleadosOption() throws Throwable {
        employeesSubMenu = organizationalStructureMenu.clickEmployees();
    }


    @Then("^'Asignar' button should be disabled$")
    public void asignarActivoButtonShouldBeDisabled() throws Throwable {
        Assert.assertTrue(assignEmployeeItemModal.isAssignButtonDisabled(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_DISSABLE, "Asignar"));
    }

    @And("^click 'agregar empleado' button in 'Employees List' page$")
    public void clickAgregarEmpleadoButtonInEmployeesListPage() throws Throwable {
        employeeRegister = employeesSubMenu.clickEmployeeRegister();
    }

    @When("^'Employee Form' page is fill with new employee data$")
    public void employeeFormPageIsFillWithNewEmployeeData() throws Throwable {
        employeeRegister.fillForm();
    }

    @Then("^'Registrar' button should be clicked$")
    public void registrarButtonShouldBeClicked() throws Throwable {
        employeeRegister.clickAddEmployeeButton();
    }

    @And("^click 'Contratos' option on 'Estructura Organizacional' submenu$")
    public void clickContratosOptionOnEstructuraOrganizacionalSubmenu() throws Throwable {
        contractRegister = new ContractRegister();

    }

    @When("^'Contracts Form' page is fill with new employee data$")
    public void contractsFormPageIsFillWithNewEmployeeData() throws Throwable {
        contractRegister.fillForm();
    }

    @Then("^'Registrar' button should be clicked on 'Contracts form' page$")
    public void registrarButtonShouldBeClickedOnContractsFormPage() throws Throwable {
        contractRegister.clickAddContractButton();
    }
}

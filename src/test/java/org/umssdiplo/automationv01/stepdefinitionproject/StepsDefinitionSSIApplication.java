package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.accidentsubmenu.AccidentSubMenu;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.managepage.accident.CreateAccident;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.Map;

public class StepsDefinitionSSIApplication {
    private static final int NEW_ACCIDENT = 1;
    private Login login;
    private NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private AssignEmployeeItemModal assignEmployeeItemModal;
    private Accident accident;
    private CreateAccident createAccident;
    private AccidentSubMenu accidentSubMenu;
    private int totalAccidents;

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

    @And("^click 'Detail' button of an active employee in 'Employees List' page$")
    public void clickDetailButtonOfAnActiveEmployee() throws Throwable {
        employeeDetail = employeesSubMenu.clickEmployeeDetail();
    }

    @When("^click 'Asignar Activo' button on 'Employee Detail' page$")
    public void clickAsignarActivoButton() throws Throwable {
        assignEmployeeItemModal = employeeDetail.clickAssignEmployeeItem();
    }

    @Then("^'Asignar' button should be disabled$")
    public void asignarActivoButtonShouldBeDisabled() throws Throwable {
        Assert.assertTrue(assignEmployeeItemModal.isAssignButtonDisabled(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_DISSABLE, "Asignar"));
    }

    @When("^click 'Accidente e Incidentes' menu on 'NavigationBar' top menu")
    public void clicAccidentEIncidentMenu() throws Throwable {
        accidentSubMenu = navigationBar.clickAccidentEIncidentButton();
    }

    @When("^click 'Accidente' option on 'Accidente e Incidentes' menu")
    public void clickAccidentOption() throws Throwable {
        accident = accidentSubMenu.clickAccidentButton();
    }

    @When("^click 'Create Accident' button on 'Acciden' page$")
    public void clickCreateAccident() throws Throwable {
        totalAccidents = accident.countAccidents();
        createAccident = accident.createAccident();
    }

    @When("^fill 'Accident' form on 'Registro Accidente' page$")
    public void fillAccidentForm(Map<String, String> data) throws Throwable {
        accident = createAccident.createAccident(data);
    }

    @Then("^verify that new accident is added in the list$")
    public void verifyAccidentWasAdded() throws Throwable {
        Assert.assertEquals(accident.countAccidents(), totalAccidents + NEW_ACCIDENT, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_ACCIDENT, "Accident"));
    }

    @Then("^verify (.*?) description for new accident$")
    public void verifyNewAccidentDescription(String description) throws Throwable {
        Assert.assertEquals(accident.getDescription(totalAccidents), description, String.format(ErrorMessage.ERROR_MESSAGE_DESCRIPION_NEW_ACCIDENT, "Accident"));
    }
}

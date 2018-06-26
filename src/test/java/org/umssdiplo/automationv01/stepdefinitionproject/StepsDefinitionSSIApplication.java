package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu.AccidentEIncidentMenu;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.ContingencyPlan;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.CreateContingencyPlan;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.EditContingencyPlan;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.Map;

public class StepsDefinitionSSIApplication {
    private static final int NUMBER_ROW = 1;
    private Login login;
    private NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private AssignEmployeeItemModal assignEmployeeItemModal;
    private AccidentEIncidentMenu accidentEIncidentMenu;
    private ContingencyPlan contingencyPlan;
    private CreateContingencyPlan createContingencyPlan;
    private EditContingencyPlan editContingencyPlan;
    private int totalContingencyPlans;
    private Map<String, String> contingencyMap;

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
        navigationBar = new NavigationBar();
        accidentEIncidentMenu = navigationBar.clickAccidentEIncidentButton();
    }

    @When("^click 'Plan de Contingencia' option on 'Accidente e Incidentes' menu")
    public void clickContingencyOption() throws Throwable {
        contingencyPlan = accidentEIncidentMenu.clickContingencyButton();
    }

    @When("^click 'Crear Plan de continegcia' button on 'Plan de Contigencia' page$")
    public void clickCreateContingencyPLanButton() throws Throwable {
        totalContingencyPlans = contingencyPlan.countContingencies();
        createContingencyPlan = contingencyPlan.clickCreateContingencyPlanButton();
    }

    @When("^fill 'plan de contingencia' form on 'Registro Plan de contingencias' page$")
    public void fillContingencyPlanForm(Map<String, String> data) throws Throwable {
        contingencyPlan = createContingencyPlan.createContingencyPlan(data);
    }

    @Then("^verify that new Contingency plan is added in the list$")
    public void verifyContingencyPLantWasAdded() throws Throwable {
        Assert.assertEquals(contingencyPlan.countContingencies(), totalContingencyPlans + NUMBER_ROW, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_CONTINGENCY_PLAN, "contigency"));
    }

    @Then("^verify (.*?) accident name for new Contingency Plan$")
    public void verifyNewContingencyAccidentName(String standardName) throws Throwable {
        Assert.assertEquals(contingencyPlan.getAccidentColumnAt(totalContingencyPlans), standardName, String.format(ErrorMessage.ERROR_MESSAGE_CONTINGENCY_INFORMATION, "contigency"));
    }

    @When("^delete Contingency plan from position (\\d+)")
    public void deleteIncidentAt(int position) throws Throwable {
        totalContingencyPlans = contingencyPlan.countContingencies();
        contingencyPlan.deleteContingencyPlan(position);
    }

    @Then("^verify that Contingency Plan was removed in the list")
    public void verifyContingencyWasRemoved() throws Throwable {
        Assert.assertEquals(contingencyPlan.countContingencies(), (totalContingencyPlans - NUMBER_ROW), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_CONTINGENCY_PLAN, "contigency"));
    }

    @Then("^edit contigency plan from position (\\d+)")
    public void editContingencyPLantAt(int position) throws Throwable {
        editContingencyPlan = contingencyPlan.editContingencyPlan(position);
    }

    @When("^edit 'Contingency Plan' form values on 'Modificar plan de contingencia' page$")
    public void editContingencyPlanForm(Map<String, String> data) throws Throwable {
        contingencyMap = data;
        contingencyPlan = editContingencyPlan.editContingencyPlan(data);
    }

    @Then("^verify that Contingency at position (\\d+) is modified")
    public void verifyContingencyIsModified(int position) throws Throwable {
        Assert.assertEquals(contingencyPlan.getContingencyPlan(position), contingencyMap, String.format(ErrorMessage.ERROR_MESSAGE_EDIT_CONTINGENCY_PLAN, "Contingency"));
    }

    @When("^select (.*?) search filter option on 'Plan de Contingencia' page")
    public void selectSearchFilterOption(String option) throws Throwable {
        contingencyPlan.selectSearchContingencyOption(option);

    }

    @When("^set (.*?) search filter value on 'Plan de Contingencia' page")
    public void setSearchFilterValue(String value) throws Throwable {
        contingencyPlan.setSearchContingencyInput(value);
    }

    @When("^click on search button on 'Plan de Contingencia' page")
    public void clickSearchButton() throws Throwable {
        contingencyPlan.clickSearchContingencyButton();
    }

    @When("^verify that Contingency plans are filter by (.*?) penalties")
    public void verifyThatContingencyIsFilterByPenalties(String penalties) throws Throwable {
        Assert.assertEquals(contingencyPlan.isPenaltyColumnsMatchWithFilter(penalties), true);
    }

    @When("^verify that 'guardar' button is disabled by default on 'Registro plan de contingencia' page")
    public void verifyThatSaveButtonIsDisabled() throws Throwable {
        Assert.assertEquals(createContingencyPlan.isSaveButtonEnabled(), false);
    }

    @When("^verify that 'mofificar' button is enabled by default on 'modificar plan de contingencia' page")
    public void verifyThatEditButtonIsEnabled() throws Throwable {
        Assert.assertEquals(editContingencyPlan.isEditButtonEnabled(), true);
    }

    @When("^click standart name field into 'contingency' form on 'registro plan de contingencia' page")
    public void clickStandartNameInput() throws Throwable {
        createContingencyPlan.clickStandartnameInput();
    }

    @When("^click description field into 'contingency' form on 'registro plan de contingencia' page")
    public void clickStateInput() throws Throwable {
        createContingencyPlan.clickDescriptinoInput();
    }

    @When("^verify that 'standart name' error message is displayed")
    public void verifystandartNameErrorMessage() throws Throwable {
        Assert.assertEquals(createContingencyPlan.getStandartnameErrorMessage(), String.format(ErrorMessage.ERROR_MESSAGE_REQUIRED_FIELD, "nombre plan de contingencia"));
    }
}

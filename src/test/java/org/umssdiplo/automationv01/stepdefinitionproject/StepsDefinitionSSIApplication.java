package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
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
    private static final int NEW_ITEM_ASSIGNED = 1;
    private int totalAssignedItems;
    private static Login login;
    private static NavigationBar navigationBar;
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
        if (navigationBar == null) {
            navigationBar = login.setCredentials();
        }
    }

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
        totalAssignedItems = employeeDetail.countAssignedItems();
        assignEmployeeItemModal = employeeDetail.clickAssignEmployeeItem();
    }

    @Then("^'Asignar' button should be disabled in the modal displayed$")
    public void asignarActivoButtonShouldBeDisabled() throws Throwable {
        Assert.assertFalse(assignEmployeeItemModal.isAssignButtonEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_DISABLE, "Asignar"));
    }

    @Then("^modal title should be \"([^\"]*)\"$")
    public void modalTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(assignEmployeeItemModal.getTitle(), expected, String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_MODAL_TITLE, assignEmployeeItemModal.getTitle()));
    }

    @When("^click 'Cancelar' button on 'Assign Item' modal$")
    public void clickCancelarButtonOnAssignItemModal() throws Throwable {
        employeeDetail = assignEmployeeItemModal.clickCancel();
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void thePageTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(expected, employeeDetail.getTitle(), String.format(ErrorMessage.ERROR_MESSAGE_PAGE_TITLE, employeeDetail.getTitle()));
    }

    @Then("^'Estado del activo' dropdown should exist$")
    public void stateItemDropdownShouldExist() throws Throwable {
        Assert.assertTrue(assignEmployeeItemModal.hasStateItemDropdown(), String.format(ErrorMessage.ERROR_MESSAGE_DROPDOWN_SHOULD_EXIST, "Estado del activo"));
    }

    @Then("^'Activo' dropdown should exist$")
    public void activeDropdownShouldExist() throws Throwable {
        Assert.assertTrue(assignEmployeeItemModal.hasItemDropdown(), String.format(ErrorMessage.ERROR_MESSAGE_DROPDOWN_SHOULD_EXIST, "Activo"));
    }

    @And("^click 'Estado del activo' dropdown in assign item modal$")
    public void clickEstadoDelActivoDropdownInAssignItemModal() throws Throwable {
        assignEmployeeItemModal.clickStateItemDropdown();
    }

    @And("^select any state$")
    public void selectAnyState() throws Throwable {
        assignEmployeeItemModal.selectStateItemDropdown();
    }

    @And("^click 'Activo' dropdown in assign item modal$")
    public void clickActivoDropdownInAssignItemModal() throws Throwable {
        assignEmployeeItemModal.clickItemDropdown();
    }

    @And("^select any item$")
    public void selectAnyItem() throws Throwable {
        assignEmployeeItemModal.selectItem();
    }

    @Then("^'Asignar' button should be enabled in the modal displayed$")
    public void asignarButtonShouldBeEnabledInTheModalDisplayed() throws Throwable {
        Assert.assertTrue(assignEmployeeItemModal.isAssignButtonEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_ENABLE, "Asignar"));
    }

    @And("^click 'Asignar' button in assign item modal$")
    public void clickAsignarButtonInAssignItemModal() throws Throwable {
        assignEmployeeItemModal.clickAssignButton();
    }

    @Then("^the list of 'Assigned items' should increase in one$")
    public void theListOfAssignedItemsShouldIncreaseInOne() throws Throwable {
        Assert.assertEquals(employeeDetail.countAssignedItems(), totalAssignedItems + NEW_ITEM_ASSIGNED, String.format(ErrorMessage.ERROR_MESSAGE_INCREASE_ASSIGNED_ITEMS, "Assigned items"));
    }

    @Then("^'Asignar Activo' button should exist in 'Employee Detail' page$")
    public void asignarActivoButtonShouldExistInEmployeeDetailPage() throws Throwable {
        Assert.assertTrue(employeeDetail.hasAssignItemButton(), String.format(ErrorMessage.ERROR_MESSAGE_BUTTON_SHOULD_EXIST_IN_PAGE, "Asignar Activo", "Employee Detail"));
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

    @Then("^verify '(.*?)' accident name for new Contingency Plan$")
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

    @When("^select '(.*?)' search filter option on 'Plan de Contingencia' page")
    public void selectSearchFilterOption(String option) throws Throwable {
        contingencyPlan.selectSearchContingencyOption(option);

    }

    @When("^set '(.*?)' search filter value on 'Plan de Contingencia' page")
    public void setSearchFilterValue(String value) throws Throwable {
        contingencyPlan.setSearchContingencyInput(value);
    }

    @When("^click on 'buscar' button on 'Plan de Contingencia' page")
    public void clickSearchButton() throws Throwable {
        contingencyPlan.clickSearchContingencyButton();
    }

    @When("^verify that Contingency plans are filter by '(.*?)' penalties")
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

    @When("^click standard name field into 'contingency' form on 'registro plan de contingencia' page")
    public void clickStandardNameInput() throws Throwable {
        createContingencyPlan.clickStandartnameInput();
    }

    @When("^click 'descripcion' field into 'contingency' form on 'registro plan de contingencia' page")
    public void clickStateInput() throws Throwable {
        createContingencyPlan.clickDescriptinoInput();
    }

    @When("^verify that 'standard name' error message is displayed")
    public void verifyStandardNameErrorMessage() throws Throwable {
        Assert.assertEquals(createContingencyPlan.getStandartnameErrorMessage(), String.format(ErrorMessage.ERROR_MESSAGE_REQUIRED_FIELD, "nombre plan de contingencia"));
    }
}

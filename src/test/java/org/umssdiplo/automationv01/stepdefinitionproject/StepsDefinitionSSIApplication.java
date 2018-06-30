package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.accident.ModificarAccident;
import org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu.AccidentEIncidentMenu;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.managepage.accident.CreateAccident;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.storage.CreateStorage;
import org.umssdiplo.automationv01.core.managepage.storage.Storage;
import org.umssdiplo.automationv01.core.managepage.storagemenu.StorageMenu;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.Map;

public class StepsDefinitionSSIApplication {
    private static final int ACCIDENT_ROW = 1;
    private Login login;
    private NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private AssignEmployeeItemModal assignEmployeeItemModal;
    private Accident accident;
    private CreateAccident createAccident;
    private AccidentEIncidentMenu accidentEIncidentMenu;
    private ModificarAccident modificarAccident;
    private int totalAccidents;
    private Map<String, String> accidentMap;
    private StorageMenu storageMenu;
    private int totalStorages;
    private Storage storage;
    private CreateStorage createStorage;
    private static final int STORAGE_ROW = 1;

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

    @When("^click 'Accidente' option on 'Accidente e Incidentes' menu")
    public void clickAccidentOption() throws Throwable {
        accident = accidentEIncidentMenu.clickAccidentButton();
    }

    @When("^click 'Create Accident' button on 'Accidente' page$")
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
        Assert.assertEquals(accident.countAccidents(), totalAccidents + ACCIDENT_ROW, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_ACCIDENT, "Accident"));
    }

    @Then("^verify (.*?) description for new accident$")
    public void verifyNewAccidentDescription(String description) throws Throwable {
        Assert.assertEquals(accident.getDescription(totalAccidents), description, String.format(ErrorMessage.ERROR_MESSAGE_DESCRIPION_NEW_ACCIDENT, "Accident"));
    }

    @When("^delete accident from position (\\d+)")
    public void deleteIncidentAt(int position) throws Throwable {
        totalAccidents = accident.countAccidents();
        accident.deleteAccident(position);
    }

    @Then("^verify that one Accident was removed in the list")
    public void verifyIncidentWasRemoved() throws Throwable {
        Assert.assertEquals(accident.countAccidents(), (totalAccidents - ACCIDENT_ROW), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_DISSABLE, "Accident"));
    }

    @Then("^edit accident from position (\\d+)")
    public void editAccidentAt(int position) throws Throwable {
        modificarAccident = accident.editAccident(position);
    }

    @When("^edit 'Accident' form on 'Modificar Accidente' page$")
    public void editAccidentForm(Map<String, String> data) throws Throwable {
        accidentMap = data;
        accident = modificarAccident.editAccident(data);
    }

    @Then("^verify that (\\d+) Accident is modified")
    public void verifyAccidentIsModified(int position) throws Throwable {
        Assert.assertEquals(accident.getAccident(position), accidentMap, String.format(ErrorMessage.ERROR_MESSAGE_EDIT_ACCIDENT, "Accident"));
    }

    @When("^select (.*?) search filter option on 'Accidente' page")
    public void selectSearchFilterOption(String option) throws Throwable {
        accident.selectSearchOption(option);

    }

    @When("^set (.*?) search filter value on 'Accidente' page")
    public void setSearchFilterValue(String value) throws Throwable {
        accident.setSearchAccidentInput(value);
    }

    @When("^click on search button on 'Accidente' page")
    public void clickSearchAccidentButton() throws Throwable {
        accident.clickSearchButton();
    }

    @When("^verify that accident are filer by (.*?) severity")
    public void verifyThatAccidenyIsFilterBySeverity(String severity) throws Throwable {
        Assert.assertEquals(accident.isSevetiryColumnMatchWithFilter(severity), true);
    }

    @When("^verify that 'guardar' button is disabled by default on 'Register Accidente' page")
    public void verifyThatSaveButtonIsDisabled() throws Throwable {
        Assert.assertEquals(createAccident.isSaveButtonEnabled(), false);
    }

    @When("^verify that 'mofificar' button is enabled by default on 'modificar Accidente' page")
    public void verifyThatEditButtonIsEnabled() throws Throwable {
        Assert.assertEquals(modificarAccident.isEditButtonEnabled(), true);
    }

    @When("^set (.*?) severity field into 'accident' form on 'registro accidente' page")
    public void verifyThatEditButtonIsEnabled(String severity) throws Throwable {
        createAccident.setSeverity(severity);
    }

    @When("^click severity field into 'accident' form on 'registro accidente' page")
    public void clickSeverityInput() throws Throwable {
        createAccident.clickSeverityInput();
    }

    @When("^click state field into 'accident' form on 'registro accidente' page")
    public void clickStateInput() throws Throwable {
        createAccident.clickStateInput();
    }

    @When("^verify that 'severity' error message is displayed")
    public void verifySeverityErrorMessage() throws Throwable {
        Assert.assertEquals(createAccident.getSeverityErrorMessage(), String.format(ErrorMessage.ERROR_MESSAGE_REQUIRED_FIELD, "severidad"));
    }

    @When("^clear severity field into 'accident' form on 'modificar accidente' page")
    public void clearSeverityInput() throws Throwable {
        modificarAccident.clearSeverityInput();
    }

    @When("^click state field into 'accident' form on 'modificar accidente' page")
    public void clickStateInputModificarForm() throws Throwable {
        modificarAccident.clickStateInput();
    }

    @Then("^click on 'atras' button on 'registrar accidente' page$")
    public void clickBackButton() throws Throwable {
        createAccident.clickBackButton();
    }

    @Then("^verify that accident is not added in the list$")
    public void verifyAccidentWasNotAdded() throws Throwable {
        Assert.assertEquals(accident.countAccidents(), totalAccidents, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_ACCIDENT, "Accident"));
    }

    @When("^Click 'Almacenes' menu on 'NavigationBar' top menu$")
    public void clickAlmacenesMenuOnNavigationBarTopMenu() throws Throwable {
        navigationBar = new NavigationBar();
        storage = navigationBar.clickStorageButton();
    }

    @And("^Click 'Agregar Almacen' button on 'Storage' page$")
    public void clickAgregarAlmacenButtonOnStoragePage() throws Throwable {
        totalStorages = storage.countStorages();
        createStorage = storage.createStorage();
    }

    @And("^Fill 'Storage' form on 'Registro Accidente' page$")
    public void fillStorageFormOnRegistroAccidentePage(Map<String, String> data) throws Throwable {
        storage = createStorage.createStorage(data);
    }

    @Then("^Verify that new storage is added in the list$")
    public void verifyThatNewStorageIsAddedInTheList() throws Throwable {
        Assert.assertEquals(storage.countStorages(), totalStorages + STORAGE_ROW, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_STORAGE, "Storage"));
    }

    @And("^Verify name for new storage$")
    public void verifyNameForNewStorage(String name) throws Throwable {
        Assert.assertEquals(storage.getName(totalStorages), name, String.format(ErrorMessage.ERROR_MESSAGE_NAME_NEW_STORAGE, "Storage"));
    }
}

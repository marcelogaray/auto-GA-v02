package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.RegisterContract;
import org.umssdiplo.automationv01.core.managepage.accident.ModificarAccident;
import org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu.AccidentEIncidentMenu;
import org.umssdiplo.automationv01.core.managepage.addItem.AddItem;
import org.umssdiplo.automationv01.core.managepage.addItemType.AddItemType;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.editItemType.EditItemType;
import org.umssdiplo.automationv01.core.managepage.reports.AvailableItemsReport;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.ContingencyPlan;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.CreateContingencyPlan;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.EditContingencyPlan;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.managepage.accident.CreateAccident;
import org.umssdiplo.automationv01.core.managepage.listItemType.ListItemType;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.activosMenu.ActivosMenu;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.positions.EditPosition;
import org.umssdiplo.automationv01.core.managepage.positions.RegisterPosition;
import org.umssdiplo.automationv01.core.managepage.positionssubmenu.PositionsSubMenu;
import org.umssdiplo.automationv01.core.managepage.reports.RefundedItemsReport;
import org.umssdiplo.automationv01.core.managepage.reports.StorageReport;
import org.umssdiplo.automationv01.core.managepage.reportssubmenu.ReportsSubMenu;
import org.umssdiplo.automationv01.core.managepage.storage.CreateStorage;
import org.umssdiplo.automationv01.core.managepage.storage.EditStorage;
import org.umssdiplo.automationv01.core.managepage.storage.Storage;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.Map;

import static org.umssdiplo.automationv01.core.utils.ErrorMessage.*;

public class StepsDefinitionSSIApplication {
    private static final int ACCIDENT_ROW = 1;
    private static final int NUMBER_ROW = 1;
    private static final int STORAGE_ROW = 1;
    private static final int NEW_ITEM_ASSIGNED = 1;
    private int totalAssignedItems;
    private int totalAccidents;
    private int totalContingencyPlans;
    private int totalPositions;
    private int totalStorages;
    private Map<String, String> contingencyMap;
    private Map<String, String> accidentMap;
    private Map<String, String> storageMap;
    private static Login login;
    private static NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private RegisterContract registerContract;
    private AssignEmployeeItemModal assignEmployeeItemModal;
    private PositionsSubMenu positionsSubMenu;
    private RegisterPosition registerPosition;
    private EditPosition updatePosition;
    private ReportsSubMenu reportsSubMenu;
    private AvailableItemsReport availableItemsReport;
    private RefundedItemsReport refundedItemsReport;
    private Accident accident;
    private CreateAccident createAccident;
    private AccidentEIncidentMenu accidentEIncidentMenu;
    private ModificarAccident modificarAccident;
    private ContingencyPlan contingencyPlan;
    private CreateContingencyPlan createContingencyPlan;
    private EditContingencyPlan editContingencyPlan;
    private Storage storage;
    private CreateStorage createStorage;
    private StorageReport storageReport;
    private EditStorage editStorage;
    private ActivosMenu activosMenu;
    private ListItemType listItemType;
    private EditItemType editItemType;
    private AddItemType addItemType;
    private AddItem addItem;

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

    @When("^click 'Estructura Organizacional' menu button on 'Navigation Bar' top menu$")
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

    @And("^click 'Asignar Activo' button on 'Employee Detail' page$")
    public void clickAsignarActivoButton() throws Throwable {
        totalAssignedItems = employeeDetail.countAssignedItems();
        assignEmployeeItemModal = employeeDetail.clickAssignEmployeeItem();
    }

    @Then("^'Asignar' button should be disabled in the modal displayed$")
    public void asignarActivoButtonShouldBeDisabled() throws Throwable {
        Assert.assertFalse(assignEmployeeItemModal.isAssignButtonEnabled(), String.format(ERROR_MESSAGE_BUTTON_DISABLE, "Asignar"));
    }

    @Then("^modal title should be \"([^\"]*)\"$")
    public void modalTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(assignEmployeeItemModal.getTitle(), expected, String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_MODAL_TITLE, assignEmployeeItemModal.getTitle()));
    }

    @And("^click 'Cancelar' button on 'Assign Item' modal$")
    public void clickCancelarButtonOnAssignItemModal() throws Throwable {
        employeeDetail = assignEmployeeItemModal.clickCancel();
    }

    @Then("^the current page title should be \"([^\"]*)\"$")
    public void theCurrentPageTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(expected, employeeDetail.getTitle(), String.format(ERROR_MESSAGE_PAGE_TITLE, employeeDetail.getTitle()));
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
        Assert.assertTrue(assignEmployeeItemModal.isAssignButtonEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_BUTTON_ENABLE, "Asignar"));
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

    @When("^delete Contingency plan with '(.*?)' description")
    public void deleteIncidentAt(String standardName) throws Throwable {
        totalContingencyPlans = contingencyPlan.countContingencies();
        contingencyPlan.deleteContingencyPlan(standardName);
    }

    @Then("^verify that Contingency Plan was removed in the list")
    public void verifyContingencyWasRemoved() throws Throwable {
        Assert.assertEquals(contingencyPlan.countContingencies(), (totalContingencyPlans - NUMBER_ROW), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_ROW, "contigency"));
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
    public void selectSearchContingencyFilterOption(String option) throws Throwable {
        contingencyPlan.selectSearchContingencyOption(option);
    }

    @When("^set '(.*?)' search filter value on 'Plan de Contingencia' page")
    public void setSearchContingencyFilterValue(String value) throws Throwable {
        contingencyPlan.setSearchContingencyInput(value);
    }

    @When("^click on 'buscar' button on 'Plan de Contingencia' page")
    public void clickSearchButton() throws Throwable {
        contingencyPlan.clickSearchContingencyButton();
    }

    @Then("^verify that Contingency plans are filter by '(.*?)' penalties")
    public void verifyThatContingencyIsFilterByPenalties(String penalties) throws Throwable {
        Assert.assertTrue(contingencyPlan.isPenaltyColumnsMatchWithFilter(penalties), String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_DOES_NOT_MATCH, "penalties"));
    }

    @Then("^verify that 'guardar' button is disabled by default on 'Registro plan de contingencia' page")
    public void verifyThatSaveButtonContingencyIsDisabled() throws Throwable {
        Assert.assertFalse(createContingencyPlan.isSaveButtonEnabled(), String.format(ERROR_MESSAGE_BUTTON_DISABLE, "guardar"));
    }

    @Then("^verify that 'mofificar' button is enabled by default on 'modificar plan de contingencia' page")
    public void verifyThatEditButtonContingencyIsEnabled() throws Throwable {
        Assert.assertTrue(editContingencyPlan.isEditButtonEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_BUTTON_ENABLE, "modificar"));
    }

    @When("^click standard name field into 'contingency' form on 'registro plan de contingencia' page")
    public void clickStandardNameInput() throws Throwable {
        createContingencyPlan.clickStandartnameInput();
    }

    @When("^click 'descripcion' field into 'contingency' form on 'registro plan de contingencia' page")
    public void clickStateContingencyInput() throws Throwable {
        createContingencyPlan.clickDescriptinoInput();
    }

    @When("^verify that 'standard name' error message is displayed")
    public void verifyStandardNameErrorMessage() throws Throwable {
        Assert.assertEquals(createContingencyPlan.getStandartnameErrorMessage(), String.format(ErrorMessage.ERROR_MESSAGE_REQUIRED_FIELD, "nombre plan de contingencia"));
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
        createAccident.fillAccidentForm(data);
    }

    @When("^click 'guardar' button on 'Registro Accidente' page$")
    public void clickGuardarButton() throws Throwable {
        accident = createAccident.clickSaveButton();
    }

    @When("^click 'atras' button on 'Registro Accidente' page$")
    public void clickAtrasButton() throws Throwable {
        accident = createAccident.clickBackButton();
    }

    @Then("^verify that new accident is added in the list$")
    public void verifyAccidentWasAdded() throws Throwable {
        Assert.assertEquals(accident.countAccidents(), totalAccidents + ACCIDENT_ROW, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_ACCIDENT, "Accident"));
    }

    @Then("^verify '(.*?)' description for new accident$")
    public void verifyNewAccidentDescription(String description) throws Throwable {
        Assert.assertEquals(accident.getDescription(totalAccidents), description, String.format(ErrorMessage.ERROR_MESSAGE_DESCRIPTION_NEW_ACCIDENT, "Accident"));
    }

    @When("^delete accident with '(.*?)' description")
    public void deleteAccidentAt(String description) throws Throwable {
        totalAccidents = accident.countAccidents();
        accident.deleteAccident(description);
    }

    @Then("^verify that one Accident was removed in the list")
    public void verifyAccidentWasRemoved() throws Throwable {
        Assert.assertEquals(accident.countAccidents(), (totalAccidents - ACCIDENT_ROW), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_ROW, "Accident"));
    }

    @Then("^edit accident from position '(\\d+)'")
    public void editAccidentAt(int position) throws Throwable {
        modificarAccident = accident.editAccident(position);
    }

    @When("^edit 'Accident' form on 'Modificar Accidente' page$")
    public void editAccidentForm(Map<String, String> data) throws Throwable {
        accidentMap = data;
        accident = modificarAccident.editAccident(data);
    }

    @Then("^verify that '(\\d+)' Accident is modified")
    public void verifyAccidentIsModified(int position) throws Throwable {
        Assert.assertEquals(accident.getAccident(position), accidentMap, String.format(ErrorMessage.ERROR_MESSAGE_EDIT_ACCIDENT, "Accident"));
    }

    @When("^select '(.*?)' search filter option on 'Accidente' page")
    public void selectSearchFilterOption(String option) throws Throwable {
        accident.selectSearchOption(option);

    }

    @When("^set '(.*?)' search filter value on 'Accidente' page")
    public void setSearchFilterValue(String value) throws Throwable {
        accident.setSearchAccidentInput(value);
    }

    @When("^click on 'Buscar' button on 'Accidente' page")
    public void clickSearchAccidentButton() throws Throwable {
        accident.clickSearchButton();
    }

    @When("^verify that accident are filter by '(.*?)' severity")
    public void verifyThatAccidenyIsFilterBySeverity(String severity) throws Throwable {
        Assert.assertTrue(accident.isSevetiryColumnMatchWithFilter(severity), String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_DOES_NOT_MATCH, "Severity"));
    }

    @When("^verify that 'guardar' button is disabled by default on 'Register Accidente' page")
    public void verifyThatSaveButtonIsDisabled() throws Throwable {
        Assert.assertFalse(createAccident.isSaveButtonEnabled(), String.format(ERROR_MESSAGE_BUTTON_DISABLE, "Guardar"));
    }

    @When("^verify that 'mofificar' button is enabled by default on 'modificar Accidente' page")
    public void verifyThatEditButtonIsEnabled() throws Throwable {
        Assert.assertTrue(modificarAccident.isEditButtonEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_BUTTON_ENABLE, "Modificar"));
    }

    @When("^set '(.*?)' severity field into 'accident' form on 'registro accidente' page")
    public void verifyThatEditButtonIsEnabled(String severity) throws Throwable {
        createAccident.setSeverity(severity);
    }

    @When("^click 'severidad' field into 'accident' form on 'registro accidente' page")
    public void clickSeverityInput() throws Throwable {
        createAccident.clickSeverityInput();
    }

    @When("^click 'estado' field into 'accident' form on 'registro accidente' page")
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

    @And("^click 'Cargos' option from list menu on 'Estructura Organizacional' submenu$")
    public void clickCargosOptionFromListMenuOnEstructuraOrganizacionalSubmenu() throws Throwable {
        positionsSubMenu = organizationalStructureMenu.clickPositions();
    }

    @And("^click 'Agregar Nueva Position' button on 'Lista de Posiciones' page$")
    public void clickAgregarNuevaPositionButtonOnListaDePosicionesPage() throws Throwable {
        registerPosition = positionsSubMenu.clickAddPosition();
    }

    @And("^click 'Guardar' button without required fields filled on 'Registrar Posicion en la empresa' page$")
    public void clickGuardarButtonWithoutRequiredFieldsFilledOnRegistrarPosicionEnLaEmpresaPage() throws Throwable {
        registerPosition.clickSavePosition();
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void thePageTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(registerPosition.getTitle(), expected, String.format(ErrorMessage.ERROR_MESSAGE_ITEM_ELEMENT_PRESENT, expected));
    }

    @And("^click 'Eliminar' button on 'Lista de Posiciones' page of element (\\d+)$")
    public void clickEliminarButtonOnListaDePosicionesPageOfElement(int element) throws Throwable {
        totalPositions = positionsSubMenu.countPositions();
        positionsSubMenu.deletePosition(element);
    }

    @Then("^after delete a position the same number of elements should be displayed$")
    public void thePageShouldNotDisplayTheElementOnListaDePosicionesPage() throws Throwable {
        Assert.assertEquals(positionsSubMenu.countPositions(), (totalPositions), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_POSITION, "Position"));
    }

    @When("^click 'Editar' option from Position list on 'Lista de Posiciones' page of element (\\d+)$")
    public void clickEditarOptionFromPositionListOnListaDePosicionesPage(int element) throws Throwable {
        updatePosition = positionsSubMenu.editPosition(element);
    }

    @Then("^the 'Actualizar Posiciones en la Empresa' page should contain the \"([^\"]*)\" button$")
    public void theActualizarPosicionesEnLaEmpresaPageShouldContainTheButton(String saveButtonName) throws Throwable {
        Assert.assertEquals(updatePosition.getSaveButtonName(), (saveButtonName), String.format(ErrorMessage.ERROR_MESSAGE_ITEM_ELEMENT_PRESENT, saveButtonName));
    }

    @Then("^the page loaded should contains the \"([^\"]*)\" title$")
    public void thePageLoadedShouldContainsTheTitle(String title) throws Throwable {
        Assert.assertEquals(positionsSubMenu.getTitle(), (title), String.format(ErrorMessage.ERROR_MESSAGE_ITEM_ELEMENT_PRESENT, title));
    }

    @Then("^the 'Devolver' button should be displayed in 'Activos Asignados' section of Employee Detail page$")
    public void theDevolverButtonShouldBeDisplayedInActivosAsignadosSectionOfEmployeeDetailPage() throws Throwable {
        Assert.assertTrue(employeeDetail.existReturnButton(), String.format(ErrorMessage.ERROR_MESSAGE_ITEM_ELEMENT_PRESENT, "The Devolver button"));
    }

    @Then("^the \"([^\"]*)\" section should be displayed in 'Employee Detail' page$")
    public void theSectionShouldBeDisplayedInEmployeeDetailPage(String assignSectionTitle) throws Throwable {
        Assert.assertTrue(employeeDetail.existAssignItemTitleSection(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_ITEM_TITLE, assignSectionTitle));
    }

    @When("^click 'Reportes' menu button on 'Navigation Bar' top menu$")
    public void clickReportesMenuButtonOnNavigationBarTopMenu() throws Throwable {
        reportsSubMenu = navigationBar.clickReports();
    }

    @And("^click 'Activos Disponibles' option on 'Reportes' submenu$")
    public void clickActivosDisponiblesOptionOnReportesSubmenu() throws Throwable {
        availableItemsReport = reportsSubMenu.clickAvailableItemsReport();
    }

    @Then("^the header of the report should contain the \"([^\"]*)\" title$")
    public void theHeaderOfTheReportShouldContainTheTitle(String firstColumn) throws Throwable {
        Assert.assertEquals(availableItemsReport.getFirstHeaderTable(), firstColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, firstColumn));
    }

    @And("^the \"([^\"]*)\" title as second column$")
    public void theTitleAsSecondColumn(String secondColumn) throws Throwable {
        Assert.assertEquals(availableItemsReport.getSecondHeaderTable(), secondColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, secondColumn));
    }

    @And("^the \"([^\"]*)\" title as third column$")
    public void theTitleAsThirdColumn(String thirdColumn) throws Throwable {
        Assert.assertEquals(availableItemsReport.getThirdTable(), thirdColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, thirdColumn));
    }

    @When("^click 'Activos Devueltos' option on 'Reportes' submenu$")
    public void clickActivosDevueltosOptionOnReportesSubmenu() throws Throwable {
        refundedItemsReport = reportsSubMenu.clickRefundedItemsReport();
    }

    @Then("^the header of the  'Activos Devueltos' report should contain the \"([^\"]*)\" title$")
    public void theHeaderOfTheActivosDevueltosReportShouldContainTheTitle(String firstColumn) throws Throwable {
        Assert.assertEquals(refundedItemsReport.getFirstHeaderTable(), firstColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, firstColumn));
    }

    @And("^the \"([^\"]*)\" title as second column of the  'Activos Devueltos' report$")
    public void theTitleAsSecondColumnOfTheActivosDevueltosReport(String secondColumn) throws Throwable {
        Assert.assertEquals(refundedItemsReport.getSecondHeaderTable(), secondColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, secondColumn));
    }

    @And("^the \"([^\"]*)\" title as third column of the  'Activos Devueltos' report$")
    public void theTitleAsThirdColumnOfTheActivosDevueltosReport(String thirdColumn) throws Throwable {
        Assert.assertEquals(refundedItemsReport.getThirdHeaderTable(), thirdColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, thirdColumn));
    }

    @And("^the \"([^\"]*)\" title as fourth column of the  'Activos Devueltos' report$")
    public void theTitleAsFourthColumnOfTheActivosDevueltosReport(String fourthColumn) throws Throwable {
        Assert.assertEquals(refundedItemsReport.getFourthHeaderTable(), fourthColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, fourthColumn));

    }

    @And("^the \"([^\"]*)\" title as fifth column of the  'Activos Devueltos' report$")
    public void theTitleAsFifthColumnOfTheActivosDevueltosReport(String fifthColumn) throws Throwable {
        Assert.assertEquals(refundedItemsReport.getFifthHeaderTable(), fifthColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, fifthColumn));
    }

    @And("^the \"([^\"]*)\" title as sixth column of the  'Activos Devueltos' report$")
    public void theTitleAsSixthColumnOfTheActivosDevueltosReport(String sixthColumn) throws Throwable {
        Assert.assertEquals(refundedItemsReport.getSixthHeaderTable(), sixthColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, sixthColumn));
    }

    @Then("^verify that accident with '(.*?)' description is not added in the list$")
    public void verifyAccidentWasNotAdded(String description) throws Throwable {
        Assert.assertFalse(accident.isDescriptionShowOnList(description), String.format(ErrorMessage.ERROR_MESSAGE_NOT_CREATE_ACCIDENT, "Accident"));
    }

    @Then("^verify that contingency plan with '(.*?)' standard name is not added in the list$")
    public void verifyContingencyPlaneisNotAdded(String standardName) throws Throwable {
        Assert.assertFalse(contingencyPlan.isStandardNameShowOnList(standardName), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_ROW, "contigency"));
    }

    @When("^click 'Almacenes' menu on 'NavigationBar' top menu$")
    public void clickAlmacenesMenuOnNavigationBarTopMenu() throws Throwable {
        storage = navigationBar.clickStorageButton();
    }

    @Then("^the page loaded should contains the \"([^\"]*)\" title main$")
    public void thePageLoadedShouldContainsTheTitleMain(String title) throws Throwable {
        Assert.assertEquals(storage.getTitle(), (title), String.format(ErrorMessage.ERROR_MESSAGE_NAME_ELEMENT_PRESENT, title));
    }

    @And("^click 'Agregar Almacen' button on 'Storage' page$")
    public void clickAgregarAlmacenButtonOnStoragePage() throws Throwable {
        totalStorages = storage.countStorages();
        createStorage = storage.createStorage();
    }

    @And("^fill 'Storage' form on 'Registro Accidente' page$")
    public void fillStorageFormOnRegistroAccidentePage(Map<String, String> data) throws Throwable {
        storage = createStorage.createStorage(data);
    }

    @Then("^verify that new storage is added in the list$")
    public void verifyThatNewStorageIsAddedInTheList() throws Throwable {
        Assert.assertEquals(storage.countStorages(), totalStorages + STORAGE_ROW, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_STORAGE, "Storage"));
    }

    @And("^verify '(.*?)' name for new storage$")
    public void verifyEquipoDeReservaNameForNewStorage(String name) throws Throwable {
        Assert.assertEquals(storage.getName(totalStorages), name, String.format(ErrorMessage.ERROR_MESSAGE_NAME_NEW_STORAGE, "Storage"));
    }

    @And("^click 'Reportes' menu button on 'Navigation Bar' menu$")
    public void clickReportesMenuButtonOnNavigationBarMenu() throws Throwable {
        reportsSubMenu = navigationBar.clickReports();
    }

    @When("^click 'Reporte de Almacenes' option on 'Reportes' submenu$")
    public void clickReporteDeAlamacenesOptionOnReportesSubmenu() throws Throwable {
        storageReport = reportsSubMenu.clickStorageReport();
    }

    @Then("^the header of the storage report should contain the \"([^\"]*)\" title$")
    public void theHeaderOfTheStorageReportShouldContainTheTitle(String firstColumn) throws Throwable {
        Assert.assertEquals(storageReport.getFirstHeaderTable(), firstColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, firstColumn));
    }

    @And("^\"([^\"]*)\" title as second column$")
    public void titleAsSecondColumn(String secondColumn) throws Throwable {
        Assert.assertEquals(storageReport.getSecondHeaderTable(), secondColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, secondColumn));
    }

    @And("^\"([^\"]*)\" title as third column$")
    public void titleAsThirdColumn(String thridColumn) throws Throwable {
        Assert.assertEquals(storageReport.getThirdTable(), thridColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, thridColumn));
    }

    @And("^\"([^\"]*)\" title as fourth column$")
    public void titleAsFourthColumn(String fourthColumn) throws Throwable {
        Assert.assertEquals(storageReport.getFourthTable(), fourthColumn, String.format(ErrorMessage.ERROR_MESSAGE_COLUMN_TEXT, fourthColumn));
    }

    @And("^click on 'Cancelar' button on 'Agregar Almacen' page$")
    public void clickOnCancelarButtonOnAgregarAlmacenPage() throws Throwable {
        createStorage.clickCancelButton();
    }

    @Then("^verify that almacen is not added in the list$")
    public void verifyThatAlmacenIsNotAddedInTheList() throws Throwable {
        Assert.assertEquals(storage.countStorages(), totalStorages, String.format(ErrorMessage.ERROR_MESSAGE_CREATE_STORAGE, "Storage"));
    }

    @And("^delete storage from position '(\\d+)'$")
    public void deleteStorageFromPosition(int position) throws Throwable {
        totalStorages = storage.countStorages();
        storage.deleteStorage(position);
    }

    @Then("^verify that Storage was deleted in the list$")
    public void verifyThatStorageWasDeletedInTheList() throws Throwable {
        Assert.assertEquals(storage.countStorages(), (totalStorages - STORAGE_ROW), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_ROW, "Storage"));
    }

    @And("^click on the edit button of the storage location '(\\d+)'$")
    public void clickOnTheEditButtonOfTheStorageLocation(int position) throws Throwable {
        editStorage = storage.editStorage(position);
    }

    @And("^edit 'Storage' form on 'Editar Almacen' page$")
    public void editStorageFormOnEditarAlmacenPage(Map<String, String> data) throws Throwable {
        storageMap = data;
        storage = editStorage.editStorage(data);
    }

    @Then("^verify that '(\\d+)' Storage is modified$")
    public void verifyThatStorageIsModified(int position) throws Throwable {
        Assert.assertEquals(storage.getStorage(position), storageMap, String.format(ErrorMessage.ERROR_MESSAGE_EDIT_STORAGE, "Storage"));
    }

    @Then("^verify that the 'Guardar' button is not available if the 'Nombre de Almacen' text field is empty$")
    public void verifyThatTheGuardarButtonIsNotAvailableIfTheNombreDeAlmacenFieldIsEmpty() throws Throwable {
        Assert.assertFalse(createStorage.isSaveButtonEnabled(), String.format(ERROR_MESSAGE_BUTTON_DISABLE, "Guardar"));
    }

    @Then("^the page loaded must contain as title \"([^\"]*)\"$")
    public void hePageLoadedMustContainAsTitle(String title) throws Throwable {
        Assert.assertEquals(storageReport.getTitle(), title, String.format(ErrorMessage.ERROR_MESSAGE_NAME_ELEMENT_PRESENT, title));
    }

    @And("^click 'Contratos' option on 'Estructura Organizacional' submenu$")
    public void clickContratosOptionOnEstructuraOrganizacionalSubmenu() throws Throwable {
        registerContract = organizationalStructureMenu.clickContracts();
    }

    @When("^'Contracts Form' page is filled with contract data$")
    public void contractsFormPageIsFillWithSomeEmployeeData() throws Throwable {
        registerContract.setInputName();
        registerContract.setInputDescription();
    }

    @Then("^'Registrar' button should be HIDE on 'Contracts form' page$")
    public void registrarButtonShouldBeHIDEOnContractsFormPage() throws Throwable {
        Assert.assertFalse(registerContract.contractButtonIsEnabled(), String.format(ErrorMessage.ERROR_MESSAGE_ADD_CONTRACT_EMPTY_FIELDS));
    }

    @And("^Click 'Login' button on Page Header$")
    public void clickLoginButtonOnPageHeader() throws Throwable {
        if (navigationBar == null) {
            login.clickLoginButton();
        }
    }

    @And("^Enter Username$")
    public void enterUsername() throws Throwable {
        if (navigationBar == null) {
            login.enterUsername();
        }
    }

    @And("^Enter Password$")
    public void enterPassword() throws Throwable {
        if (navigationBar == null) {
            login.enterPassword();
        }
    }

    @And("^Click 'Login' button to accept credentials$")
    public void clickLoginButtonToAcceptCredentials() throws Throwable {
        if (navigationBar == null) {
            navigationBar = login.clickLoginAcceptButton();
        }
    }

    @And("^Click 'Activos' menu in Navigation bar$")
    public void clickActivosMenuInNavigationBar() throws Throwable {
        activosMenu = navigationBar.clickActivos();
    }

    @And("^Click 'Lista de Tipos' submenu option$")
    public void clickListaDeTiposMenuOption() throws Throwable {
        listItemType = activosMenu.clickItemTypeListSubMenu();
    }

    @And("^Click 'Edit' button of the row \"([^\"]*)\" in the list$")
    public void clickEditButtonOfTheRowInTheList(String indexParam) throws Throwable {
        int index = Integer.parseInt(indexParam) - 1;
        editItemType = listItemType.clickEditBtnInRow(index);
    }

    @And("^Set \"([^\"]*)\" as the new name for the item type$")
    public void setAsTheNewNameForTheItemType(String newName) throws Throwable {
        editItemType.enterNewItemTypeName(newName);
    }

    @When("^Click 'Save' button$")
    public void clickSaveButton() throws Throwable {
        listItemType = editItemType.clickSaveItemTypeBtn();
    }

    @Then("^Verify row \"([^\"]*)\" has \"([^\"]*)\" as name in Item Type list page$")
    public void verifyRowHasAsNameInItemTypeListPage(String indexParam, String expectedItemTypeName) throws Throwable {
        int index = Integer.parseInt(indexParam) - 1;
        String actualItemTypeName = listItemType.getItemTypeNameInTableRow(index);
        Assert.assertEquals(actualItemTypeName, expectedItemTypeName, String.format(ERROR_MESSAGE_EDIT_ITEMTYPE_COMPLETED, expectedItemTypeName));
    }

    @And("^Click 'Anadir Tipo de Item' button$")
    public void clickAnadirTipoDeItemButton() throws Throwable {
        editItemType = listItemType.clickAddItemTypeBtn();
    }

    @And("^Enter \"([^\"]*)\" in Name input field$")
    public void enterInNameInputField(String itemTypeName) throws Throwable {
        editItemType.enterNewItemTypeName(itemTypeName);
    }

    @And("^Verify \"([^\"]*)\" is in the list$")
    public void verifyIsInTheList(String expectedItemTypeName) throws Throwable {
        boolean expectedResult = listItemType.existItemTypeByName(expectedItemTypeName);
        Assert.assertTrue(expectedResult);
    }

    @When("^Click 'Delete' button of \"([^\"]*)\" row$")
    public void clickDeleteButtonOfRow(String itemTypeName) throws Throwable {
        listItemType = listItemType.clickDeleteBtnByItemTypeName(itemTypeName);
    }

    @Then("^Verify that \"([^\"]*)\" does not exist in the list$")
    public void verifyThatDoesNotExistInTheList(String itemTypeName) throws Throwable {
        boolean actualResult = listItemType.existItemTypeByName(itemTypeName);
        Assert.assertEquals(actualResult, false, String.format(ERROR_MESSAGE_EDIT_ITEMTYPE_DELETED, itemTypeName));
    }

    @Then("^Verify that \"([^\"]*)\" is the title of the loaded page$")
    public void verifyThatIsTheTitleOfTheLoadedPage(String expectedTitle) throws Throwable {
        String actualTitle = listItemType.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, String.format(ERROR_MESSAGE_PAGE_TITLE, expectedTitle));
    }

    @And("^Click 'Edit' button of \"([^\"]*)\" row$")
    public void clickEditButtonOfRow(String itemTypeName) throws Throwable {
        editItemType = listItemType.clickEditBtnByItemTypeName(itemTypeName);
    }

    @When("^Click 'Cancel' button in Edit Item Type page$")
    public void clickCancelButtonInEditItemTypePage() throws Throwable {
        listItemType = editItemType.clickCancelEditItemTypeBtn();
    }

    @When("^Click 'Anadir Tipo' submenu option$")
    public void clickAnadirTipoSubmenuOption() throws Throwable {
        addItemType = activosMenu.clickAnadirTypeSubmenu();
    }

    @Then("^Verify 'Save' button status is \"([^\"]*)\"$")
    public void verifySaveButtonStatusIs(String expecedBtnStatus) throws Throwable {
        String actualStatus = addItemType.getSaveBtnStatus();
        Assert.assertEquals(actualStatus, expecedBtnStatus, String.format(ERROR_MESSAGE_BUTTON_DISABLE, "Save"));
    }

    @When("^Click 'Anadir Item' submenu option$")
    public void clickAnadirItemSubmenuOption() throws Throwable {
        addItem = activosMenu.clickAnadirItemSubmenu();
    }

    @Then("^Verify \"([^\"]*)\" is the title of the Page$")
    public void verifyIsTheTitleOfThePage(String expectedTitle) throws Throwable {
        String actualPageTitle = addItem.getPageMainTitle();
        Assert.assertEquals(actualPageTitle, expectedTitle, String.format(ERROR_MESSAGE_PAGE_TITLE, expectedTitle));
    }

    @And("^Click 'Delete' button of \"([^\"]*)\" name$")
    public void clickDeleteButtonOfName(String itemTypeName) throws Throwable {
        listItemType = listItemType.clickDeleteBtnByItemTypeName(itemTypeName);
    }

    @Then("^Verify 'Save' button status is \"([^\"]*)\" in 'Anadir Item' page$")
    public void verifySaveButtonStatusIsInAnadirItemPage(String expectedStatus) throws Throwable {
        String actualsStatus = addItem.getSaveBtnStatus();
        Assert.assertEquals(actualsStatus, expectedStatus, String.format(ERROR_MESSAGE_BUTTON_DISABLE, "Save"));
    }
}

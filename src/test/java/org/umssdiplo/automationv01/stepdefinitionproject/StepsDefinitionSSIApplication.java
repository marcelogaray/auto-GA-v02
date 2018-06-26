package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.reports.AvailableItemsReport;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.positions.EditPosition;
import org.umssdiplo.automationv01.core.managepage.positions.RegisterPosition;
import org.umssdiplo.automationv01.core.managepage.positionssubmenu.PositionsSubMenu;
import org.umssdiplo.automationv01.core.managepage.reports.RefundedItemsReport;
import org.umssdiplo.automationv01.core.managepage.reportssubmenu.ReportsSubMenu;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private static final int POSITION_REMOVED = 1;

    private static Login login;
    private static NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private AssignEmployeeItemModal assignEmployeeItemModal;
    private PositionsSubMenu positionsSubMenu;
    private RegisterPosition registerPosition;
    private int totalPositions;
    private EditPosition updatePosition;
    private ReportsSubMenu reportsSubMenu;
    private AvailableItemsReport availableItemsReport;
    private RefundedItemsReport refundedItemsReport;


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

    @Then("^'Asignar' button should be disabled$")
    public void asignarActivoButtonShouldBeDisabled() throws Throwable {
        Assert.assertTrue(assignEmployeeItemModal.isAssignButtonDisabled(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_BUTTON_DISSABLE, "Asignar"));
    }

    @And("^click 'Cargos' option from list menu on 'Estructura Organizacional' submenu$")
    public void clickCargosOptionFromListMenuOnEstructuraOrganizacionalSubmenu() throws Throwable {
        positionsSubMenu = organizationalStructureMenu.clickPositions();
    }

    @And("^click 'Agregar Nueva Position' button on 'Lista de Posiciones' page$")
    public void clickAgregarNuevaPositionButtonOnListaDePosicionesPage() throws Throwable {
        registerPosition = positionsSubMenu.clickAddPosition();
    }

    @When("^click 'Guardar' button without required fields filled on 'Registrar Posicion en la empresa' page$")
    public void clickGuardarButtonWithoutRequiredFieldsFilledOnRegistrarPosicionEnLaEmpresaPage() throws Throwable {
        registerPosition.clickSavePosition();
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void thePageTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(registerPosition.getTitle(), expected, String.format(ErrorMessage.ERROR_MESSAGE_REGISTER_POSITION, expected));
    }

    @When("^click 'Eliminar' button on 'Lista de Posiciones' page of element (\\d+)$")
    public void clickEliminarButtonOnListaDePosicionesPageOfElement(int element) throws Throwable {
        totalPositions = positionsSubMenu.countPositions();
        positionsSubMenu.deletePosition(element);
    }

    @Then("^the page should not display the element removed on 'Lista de Posiciones' page$")
    public void thePageShouldNotDisplayTheElementOnListaDePosicionesPage() throws Throwable {
        Assert.assertEquals(positionsSubMenu.countPositions(), (totalPositions - POSITION_REMOVED), String.format(ErrorMessage.ERROR_MESSAGE_DELETE_POSITION, "Position"));
    }


    @When("^click 'Editar' option from Position list on 'Lista de Posiciones' page of element (\\d+)$")
    public void clickEditarOptionFromPositionListOnListaDePosicionesPage(int element) throws Throwable {

        updatePosition = positionsSubMenu.editPosition(element);
    }

    @Then("^the 'Actualizar Posiciones en la Empresa' page should contain the \"([^\"]*)\" button$")
    public void theActualizarPosicionesEnLaEmpresaPageShouldContainTheButton(String saveButtonName) throws Throwable {
        Assert.assertEquals(updatePosition.getSaveButtonName(), (saveButtonName), String.format(ErrorMessage.ERROR_MESSAGE_UPDATE_POSITION, saveButtonName));
    }

    @Then("^the page loaded should contains the \"([^\"]*)\" title$")
    public void thePageLoadedShouldContainsTheTitle(String title) throws Throwable {
        Assert.assertEquals(positionsSubMenu.getTitle(), (title), String.format(ErrorMessage.ERROR_MESSAGE_LIST_POSITION, title));
    }

    @Then("^the 'Devolver' button should be displayed in 'Activos Asignados' section of Employee Detail page$")
    public void theDevolverButtonShouldBeDisplayedInActivosAsignadosSectionOfEmployeeDetailPage() throws Throwable {
        Assert.assertTrue(employeeDetail.existReturnButton(), String.format(ErrorMessage.ERROR_MESSAGE_UNASSIGN_ITEM, "The Devolver button"));
    }

    @Then("^the \"([^\"]*)\" section should be displayed in 'Employee Detail' page$")
    public void theSectionShouldBeDisplayedInEmployeeDetailPage(String assignSectionTitle) throws Throwable {
        Assert.assertTrue(employeeDetail.existAssignItemTitleSection(), String.format(ErrorMessage.ERROR_MESSAGE_ASSIGN_ITEM_TITLE, assignSectionTitle));
    }

    @And("^click 'Reportes' menu button on 'Navigation Bar' top menu$")
    public void clickReportesMenuButtonOnNavigationBarTopMenu() throws Throwable {
        reportsSubMenu = navigationBar.clickReports();
    }

    @When("^click 'Activos Disponibles' option on 'Reportes' submenu$")
    public void clickActivosDisponiblesOptionOnReportesSubmenu() throws Throwable {
        availableItemsReport = reportsSubMenu.clickAvailableItemsReport();
    }


    @Then("^the header of the report should contain the \"([^\"]*)\" title$")
    public void theHeaderOfTheReportShouldContainTheTitle(String firstColumn) throws Throwable {
        Assert.assertEquals(availableItemsReport.getFirstHeaderTable(), firstColumn, String.format(ErrorMessage.ERROR_MESSAGE_FIRST_COLUMN_TEXT, firstColumn));
    }

    @And("^the \"([^\"]*)\" title as second column$")
    public void theTitleAsSecondColumn(String secondColumn) throws Throwable {
        Assert.assertEquals(availableItemsReport.getSecondHeaderTable(), secondColumn, String.format(ErrorMessage.ERROR_MESSAGE_SECOND_COLUMN_TEXT, secondColumn));
    }

    @And("^the \"([^\"]*)\" title as third column$")
    public void theTitleAsThirdColumn(String thirdColumn) throws Throwable {
        Assert.assertEquals(availableItemsReport.getThirdTable(), thirdColumn, String.format(ErrorMessage.ERROR_MESSAGE_THIRD_COLUMN_TEXT, thirdColumn));
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
}

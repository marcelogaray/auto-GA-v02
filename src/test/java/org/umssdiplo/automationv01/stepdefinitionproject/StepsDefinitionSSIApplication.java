package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.addItem.AddItem;
import org.umssdiplo.automationv01.core.managepage.addItemType.AddItemType;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.managepage.editItemType.EditItemType;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.listItemType.ListItemType;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.ActivosMenu;
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
    private ActivosMenu activosMenu;
    private ListItemType listItemType;
    private EditItemType editItemType;
    private AddItemType addItemType;
    private AddItem addItem;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        if (login == null) {
            login = LoadPage.loginPage();
        }
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
        if(navigationBar == null){
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
        Assert.assertEquals(actualItemTypeName, expectedItemTypeName);
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
        Assert.assertEquals(actualResult, false);
    }

    @Then("^Verify that \"([^\"]*)\" is the title of the loaded page$")
    public void verifyThatIsTheTitleOfTheLoadedPage(String expectedTitle) throws Throwable {
        String actualTitle = listItemType.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
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
        Assert.assertEquals(actualStatus, expecedBtnStatus);
    }

    @When("^Click 'Anadir Item' submenu option$")
    public void clickAnadirItemSubmenuOption() throws Throwable {
        addItem = activosMenu.clickAnadirItemSubmenu();
    }

    @Then("^Verify \"([^\"]*)\" is the title of the Page$")
    public void verifyIsTheTitleOfThePage(String expectedTitle) throws Throwable {
        String actualPageTitle = addItem.getPageMainTitle();
        Assert.assertEquals(actualPageTitle, expectedTitle);
    }

    @And("^Click 'Delete' button of \"([^\"]*)\" name$")
    public void clickDeleteButtonOfName(String itemTypeName) throws Throwable {
        listItemType = listItemType.clickDeleteBtnByItemTypeName(itemTypeName);
    }

    @Then("^Verify 'Save' button status is \"([^\"]*)\" in 'Anadir Item' page$")
    public void verifySaveButtonStatusIsInAnadirItemPage(String expectedStatus) throws Throwable {
        String actualsStatus = addItem.getSaveBtnStatus();
        Assert.assertEquals(actualsStatus, expectedStatus);
    }
}

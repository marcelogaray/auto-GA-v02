package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
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
    private static final int NEW_ITEM_ASSIGNED = 1;
    private static Login login;
    private static NavigationBar navigationBar;
    private static OrganizationalStructureMenu organizationalStructureMenu;
    private static EmployeesSubMenu employeesSubMenu;
    private static EmployeeDetail employeeDetail;
    private static AssignEmployeeItemModal assignEmployeeItemModal;
    private int totalAssignedItems;

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
}

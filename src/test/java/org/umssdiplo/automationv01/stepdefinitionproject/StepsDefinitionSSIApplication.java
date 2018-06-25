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
import org.umssdiplo.automationv01.core.managepage.storage.AddStorage;
import org.umssdiplo.automationv01.core.managepage.storage.DeleteStorage;
import org.umssdiplo.automationv01.core.managepage.storage.EditStorage;
import org.umssdiplo.automationv01.core.managepage.storage.StorageList;
import org.umssdiplo.automationv01.core.utils.ErrorMessage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private Login login;
    private NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private EmployeesSubMenu employeesSubMenu;
    private EmployeeDetail employeeDetail;
    private AssignEmployeeItemModal assignEmployeeItemModal;
    private StorageList storageList;
    private AddStorage addStorage;
    private EditStorage editStorage;
    private DeleteStorage deleteStorage;

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

    @And("^Click 'Almacenes' menu button on 'Navigation Bar' top menu$")
    public void clickAlmacenesMenuButtonOnNavigationBarTopMenu() throws Throwable {
        storageList = navigationBar.clickStorages();
    }

    @And("^Click 'Agregar Nuevo Almacen' button$")
    public void clickAgregarNuevoAlmacenButton() throws Throwable {
        addStorage = storageList.clickAddStorage();
    }

    @And("^Enter a store name in the \"([^\"]*)\" field$")
    public void enterAStoreNameInTheField(String arg0) throws Throwable {
        addStorage.inputNameStorage();
    }

    @When("^Click 'Guardar' button$")
    public void clickGuardarButton() throws Throwable {
        addStorage.clickSave();
    }

    @Then("^The page should redirect to the list of Storages containing the new Storage$")
    public void thePageShouldRedirectToTheListOfStoragesContainingTheNewStorage() throws Throwable {
        Assert.assertTrue(storageList.isStorageVisible());
    }

    @And("^Click 'Editar' button$")
    public void clickEditarButton() throws Throwable {
        editStorage = storageList.clickEditStorage();
    }

    @And("^Enter a store new name in the \"([^\"]*)\" field$")
    public void enterAStoreNewNameInTheField(String arg0) throws Throwable {
        editStorage.inputNewNameStorage();
    }

    @When("^Click in 'Guardar' button$")
    public void clickInGuardarButton() throws Throwable {
        editStorage.clickSave();
    }

    @Then("^The page should redirect to the list of Storages containing the new Storage Edited$")
    public void thePageShouldRedirectToTheListOfStoragesContainingTheNewStorageEdited() throws Throwable {
        Assert.assertTrue(storageList.isNewNameStorageEditVisible());
    }

    @When("^Click 'Eliminar' button$")
    public void clickEliminarButton() throws Throwable {
        deleteStorage = storageList.clickDeleteStorage();
    }

    @Then("^The page the list of Storages ya no containing the Storage Eliminado$")
    public void thePageTheListOfStoragesYaNoContainingTheStorageEliminado() throws Throwable {
        Assert.assertFalse(storageList.isNotExist());
    }
}

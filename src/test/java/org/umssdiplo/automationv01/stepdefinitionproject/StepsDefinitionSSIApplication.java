package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.editItemTypePage.EditItemTypePage;
import org.umssdiplo.automationv01.core.managepage.listaTipoItemPage.ListItemTypePage;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.menu.ActivosMenu;
import org.umssdiplo.automationv01.core.managepage.menu.MainMenu;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private Login login;
    private MainMenu mainMenu;
    private ActivosMenu activosMenu;
    private ListItemTypePage listItemTypePage;
    private EditItemTypePage editItemTypePage;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set Admin credentials on 'Login' page$")
    public void setCredentialsOnLoginPage() throws Throwable {
        navigationBar = login.setCredentials();
    }

    @And("^Click 'Login' button on Page Header$")
    public void clickOnLoginButtonOnPageHeader() throws Throwable {
        login.clickOnLoginButton();
    }

    @And("^Enter Username$")
    public void enterUsername() throws Throwable {
        login.enterUsername();
    }

    @And("^Enter Password$")
    public void enterPassword() throws Throwable {
        login.enterPassword();
    }

    @And("^Click 'Login' button to accept credentials$")
    public void clickOnLoginButtonToAcceptCredentials() throws Throwable {
        mainMenu = login.clickOnLoginAcceptButton();
    }

    @And("^Click 'Activos' menu in Main menu$")
    public void clickOnActivosButton() throws Throwable {
        activosMenu = mainMenu.clickOnActivosMenu();
    }

    @And("^Click 'Lista de Tipos' submenu option$")
    public void clickOnListaDeTiposMenuOption() throws Throwable {
        listItemTypePage = activosMenu.clickOnItemTypeListSubMenu();
    }

    @And("^Click 'Edit' button of the first element in the list$")
    public void clickOnEditButtonOfTheFirstElementInTheList() throws Throwable {
        editItemTypePage = listItemTypePage.clickOnFirstRowEditBtn();
    }

    @And("^Set \"([^\"]*)\" as the new name for the item type$")
    public void setAsTheNewNameForTheItemType(String newName) throws Throwable {
        editItemTypePage.enterNewItemTypeName(newName);
    }

    @When("^Click on 'Save' button$")
    public void clickOnSaveButton() throws Throwable {
        listItemTypePage = editItemTypePage.clickOnSaveItemTypeBtn();
    }

    @Then("^Check first Item Type name is \"([^\"]*)\"$")
    public void checkFirstItemTypeNameIs(String expectedName) throws Throwable {
        listItemTypePage.checkFirstItemTypeName(expectedName);
    }
}

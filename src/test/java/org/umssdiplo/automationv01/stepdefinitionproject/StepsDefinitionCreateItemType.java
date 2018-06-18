package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.ItemType.CreateItemType;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionCreateItemType {

    private Login login;
    private CreateItemType createItemType;


    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
        createItemType = new CreateItemType();
    }

    @And("^User is authenticated$")
    public void userIsAuthenticated() throws Throwable {
        login.setCredentials();
    }

    @And("^I click on \"([^\"]*)\" menu button$")
    public void iClickOnMenuButton(String arg0) throws Throwable {
        createItemType.clickOnActiveMenuOption();
    }

    @And("^I click on \"([^\"]*)\" Button$")
    public void iClickOnButton(String arg0) throws Throwable {
        createItemType.clickOnItemTypeMenuOption();
    }


    @And("^I type an item name in \"([^\"]*)\" field$")
    public void iTypeAnItemNameInField(String arg0) throws Throwable {
        createItemType.typeOnActiveTypeName();
    }


    @When("^I click on \"([^\"]*)\" button to save the Item type$")
    public void iClickOnButtonToSaveTheItemType(String arg0) throws Throwable {
       createItemType.clickOnSaveButton();
    }


    @Then("^The Item should be added$")
    public void theItemShouldBeAdded() throws Throwable {

    }
}

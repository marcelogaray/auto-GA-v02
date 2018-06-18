package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.Position.CreatePosition;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionCreatePosition {
    private Login login;
    private CreatePosition createPosition;

    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
        createPosition = new CreatePosition();
    }

    @And("^User is authenticated$")
    public void userIsAuthenticated() throws Throwable {
        login.setCredentials();
    }

    @And("^I click on \"([^\"]*)\" menu button$")
    public void iClickOnMenuButton(String arg0) throws Throwable {

        createPosition.clickOnOrganizationalMenuOption();
    }

    @And("^I click on \"([^\"]*)\" option$")
    public void iClickOnOption(String arg0) throws Throwable {

        createPosition.clickOnListPositionOption();
    }

    @And("^I click on \"([^\"]*)\" Button$")
    public void iClickOnButton(String arg0) throws Throwable {

        createPosition.clickOnAddNewPosition();
    }

    @When("^I click on \"([^\"]*)\" button without fill required fields$")
    public void iClickOnButtonWithoutFillRequiredFields(String arg0) throws Throwable {

        createPosition.clickOnSavePosition();
    }

    @Then("^The page title should be the same$")
    public void thePageTitleShouldBeTheSame() throws Throwable {

        final String expected = "Registrar Posiciones en la Empresa";
        Assert.assertEquals(createPosition.getTitleText(), expected);
    }
}
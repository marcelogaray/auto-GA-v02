package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.EmployeeItem.AssignEmployeeItem;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionAssignItemToEmployee {
    private Login login;
    private AssignEmployeeItem assignEmployeeItem;

    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
// Space
        login = LoadPage.loginPage();
        assignEmployeeItem = new AssignEmployeeItem();
// Space
    }

    @And("^User is authenticated$")
    public void userIsAuthenticated() throws Throwable {
        login.setCredentials();
    }

    @And("^I click on Estructura Organizacional menu button$")
    public void iClickOnEstructuraOrganizacionalMenuButton$(){
        assignEmployeeItem.clickOnEstructuraOrganizacionalMenuButton();
    }

    @And("^I click on Empleados option$")
    public void iClickOnEmpleadosOption() throws Throwable {
        assignEmployeeItem.clickOnEmpleadosOption();
    }

    @And("^I click on Employee Detail button$")
    public void iClickOnEmployeeDetailButton() throws Throwable {
        assignEmployeeItem.clickOnEmployeeDetailButton();
    }

    @And("^I click on Asignar Activo button$")
    public void iClickOnAsignarActivoButton() throws Throwable {
        assignEmployeeItem.clickOnAsignarActivoButton();
    }

    @When("^Fields are empty$")
    public void fieldsAreEmpty() throws Throwable {
    }

    @Then("^Asignar button should be disabled$")
    public void asignarButtonShouldBeDisabled() throws Throwable {
        Assert.assertFalse(assignEmployeeItem.isAssignButtonEnabled());
    }
}
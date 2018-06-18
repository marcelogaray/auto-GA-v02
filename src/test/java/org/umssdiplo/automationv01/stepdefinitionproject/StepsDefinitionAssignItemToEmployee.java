package org.umssdiplo.automationv01.stepdefinitionproject;

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
        login = LoadPage.loginPage();
        assignEmployeeItem = new AssignEmployeeItem();
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

    @When("^I click on Asignar Activo button$")
    public void iClickOnAsignarActivoButton() throws Throwable {
        assignEmployeeItem.clickOnAsignarActivoButton();
    }

    @Then("^A modal with \"([^\"]*)\" should be displayed$")
    public void aModalWithShouldBeDisplayed(String arg0) throws Throwable {
        final String EXPECTED = "Asignacion de Activo";
        Assert.assertEquals(assignEmployeeItem.getTitleText(), EXPECTED);
    }
}

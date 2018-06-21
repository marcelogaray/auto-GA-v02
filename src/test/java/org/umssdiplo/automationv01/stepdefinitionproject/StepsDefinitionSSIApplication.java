package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.managepage.accident.CreateAccident;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.Map;

public class StepsDefinitionSSIApplication {
    private Login login;
    private NavigationBar navigationBar;
    private Accident accident;
    private CreateAccident createAccident;
    private int totalAccidents;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set Admin credentials on 'Login' page$")
    public void setCredentialsOnLoginPage() throws Throwable {
        navigationBar = login.setCredentials();
    }

    @When("^go to accident Page$")
    public void goToAccidentPage() throws Throwable {
        accident = navigationBar.goToAccidentPage();
    }

    @When("^go to create accident page$")
    public void createAccident() throws Throwable {
        totalAccidents = accident.countAccidents();
        createAccident = accident.createAccident();
    }

    @When("^create an accident$")
    public void enterDescription$(Map<String, String> data) throws Throwable {
        accident = createAccident.createAccident(data);
    }

    @Then("^verify that new accident is added (\\d+) in the list$")
    public void verifyAccidentWasAdded(int newAccident) throws Throwable {
        Assert.assertEquals(accident.countAccidents(), totalAccidents + newAccident);
    }
}

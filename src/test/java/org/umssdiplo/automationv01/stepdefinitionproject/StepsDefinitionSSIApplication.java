package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.incident.Incident;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private Login login;
    private NavigationBar navigationBar;
    private Incident incident;
    private int totalIncidents;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set Admin credentials on 'Login' page$")
    public void setCredentialsOnLoginPage() throws Throwable {
        navigationBar = login.setCredentials();
    }

    @When("^click on 'incident' menu on 'navigationBar' page$")
    public void goToIncidentPage() throws Throwable {
        incident = navigationBar.goToIncidentPage();
    }

    @When("^delete incident from position (\\d+)")
    public void deleteIncident(int position) throws Throwable {
        totalIncidents = incident.countIncidents();
        incident.deleteIncident(position);
    }

    @Then("^verify that one incident was removed (\\d+) in the list")
    public void verifyIncidentWasRemoved(int incidentRemovedCount) throws Throwable {
        Assert.assertEquals(incident.countIncidents(), (totalIncidents - incidentRemovedCount));
    }
}

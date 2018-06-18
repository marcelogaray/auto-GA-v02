package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Incident.CreateIncident;
import org.umssdiplo.automationv01.core.managepage.Incident.Incident;

import java.util.List;

public class StepsDefinitionIncident {
    private Incident incident = new Incident();
    private int incidents;
    private CreateIncident createIncident = new CreateIncident();

    @When("^go to incident Page$")
    public void goToIncident() throws Throwable {
        incident.selectIncidentLink();
    }

    @And("^get list of incidents$")
    public void getincidents() throws Throwable {
        incidents = incident.countIncident();
    }

    @And("^go to create incident page$")
    public void createIncident() throws Throwable {
        incident.createIncident();
    }

    @And("^fill all required fields for Incident$")
    public void enterDescription$(DataTable incidentInformation) throws Throwable {
        List<List<String>> data = incidentInformation.raw();
        createIncident.setDescription(data.get(2).get(0));
        createIncident.selectDepartment(data.get(1).get(0));
        createIncident.selectEmployee(data.get(0).get(0));
        createIncident.setSeverity(data.get(3).get(0));
        createIncident.setMaterial(data.get(4).get(0));
        createIncident.setOther(data.get(5).get(0));
        createIncident.setDate(data.get(6).get(0));
        createIncident.clickSaveButton();
    }

    @Then("^verify that one incident is added$")
    public void verifyIncidentWasAdded() throws Throwable {
        Assert.assertEquals(incident.countIncident(), incidents + 1);
    }
}

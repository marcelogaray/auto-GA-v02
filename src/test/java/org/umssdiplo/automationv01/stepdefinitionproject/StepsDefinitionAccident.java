package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Accident.Accident;
import org.umssdiplo.automationv01.core.managepage.Accident.CreateAccident;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.List;

public class StepsDefinitionAccident {
    private Accident accident = new Accident();
    private int accidents;
    private CreateAccident createAccident = new CreateAccident();

    @When("^go to accident Page$")
    public void goToAccident() throws Throwable {
        accident.selectAccidentLink();
    }

    @And("^get list of accidents$")
    public void getAccidents() throws Throwable {
        accidents = accident.countAccident();
    }

    @And("^go to create accident page$")
    public void createAccident() throws Throwable {
        accident.createAccident();
    }

    @And("^fill all required fields$")
    public void enterDescription$(DataTable accidentInformation) throws Throwable {
        List<List<String>> data = accidentInformation.raw();
        createAccident.setDescription(data.get(2).get(0));
        createAccident.selectDepartment(data.get(1).get(0));
        createAccident.selectEmployee(data.get(0).get(0));
        createAccident.setSeverity(data.get(3).get(0));
        createAccident.setState(data.get(4).get(0));
        createAccident.setSenority(data.get(5).get(0));
        createAccident.setMaterial(data.get(6).get(0));
        createAccident.setOther(data.get(7).get(0));
        createAccident.setDate(data.get(8).get(0));
        createAccident.clickSaveButton();
    }

    @Then("^verify that one accident is added$")
    public void verifyAccidentWasAdded() throws Throwable {
        Assert.assertEquals(accident.countAccident(), accidents + 1);
    }
}

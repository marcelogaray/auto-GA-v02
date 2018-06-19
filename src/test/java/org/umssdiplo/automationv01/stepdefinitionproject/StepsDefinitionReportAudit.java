package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.ItemType.CreateItemType;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.Reports.ReportAuditHistory;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionReportAudit {
    private Login login;
    private ReportAuditHistory reportAuditHistory;


    @Given("^'SSI' loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
        reportAuditHistory = new ReportAuditHistory();
    }

    @And("^User is authenticated in portal$")
    public void userIsAuthenticated() throws Throwable {
        login.setCredentials();
    }

    @And("^click on \"([^\"]*)\" menu button$")
    public void clickOnMenuButton(String arg0) throws Throwable {
        reportAuditHistory.clickOnActiveMenuOption();
    }


    @When("^click on \"([^\"]*)\" submenu Button$")
    public void clickOnSubmenuButton(String arg0) throws Throwable {
        reportAuditHistory.clickOnSubmenuButton();
    }


    @Then("^The list of modification should be displayed$")
    public void theListOfModificationShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

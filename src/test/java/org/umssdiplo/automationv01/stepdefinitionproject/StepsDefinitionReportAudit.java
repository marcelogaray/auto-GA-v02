package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.reports.ReportAuditHistory;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.Random;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class StepsDefinitionReportAudit {
    private Login login;
    private ReportAuditHistory reportAuditHistory;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private String newSalary;
    private String employeeName;
    private static NavigationBar navigationBar;


    @Given("^'SSI' loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
        reportAuditHistory = new ReportAuditHistory();
    }

    @And("^User is authenticated in portal$")
    public void userIsAuthenticated() throws Throwable {
        if(navigationBar==null){
            navigationBar = login.setCredentials();
        }
    }

    @And("^click on \"([^\"]*)\" menu button on navigation bar tab menu$")
    public void clickOnMenuButton(String arg0) throws Throwable {
        reportAuditHistory.clickOnActiveMenuOption();
    }


    @When("^click on \"([^\"]*)\" submenu Button$")
    public void clickOnSubmenuButton(String arg0) throws Throwable {
        reportAuditHistory.clickOnSubmenuButton();
    }


    @Then("^The update in \"([^\"]*)\" should be displayed in the table$")
    public void theListOfModificationShouldBeDisplayed(String arg0) throws Throwable {
        assertNotNull(reportAuditHistory.getSalary(newSalary));
        ofAnIsUpdatedTo("", employeeName, "450");
    }

    @And("^\"([^\"]*)\" of the \"([^\"]*)\" employee is updated to \"([^\"]*)\"$")
    public void ofAnIsUpdatedTo(String arg0, String name, String salary) throws Throwable {
        Random rand = new Random();
        newSalary = new StringBuffer().append(rand.nextInt(Integer.parseInt(salary))).toString();
        employeeName = name;
        navigationBar.clickEmployees().selectEmployee(name).setSalary(salary);

    }

}

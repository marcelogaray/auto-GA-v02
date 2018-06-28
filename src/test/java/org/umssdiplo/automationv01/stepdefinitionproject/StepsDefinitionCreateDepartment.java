package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.CreateDepartmentPage;
import org.umssdiplo.automationv01.core.managepage.reports.ReportAuditHistory;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import static org.testng.Assert.assertNotNull;

public class StepsDefinitionCreateDepartment {
    private Login login;
    CreateDepartmentPage createDepartmentPage;
    private String departmentName;

    @Given("^'SSI' loaded for department$")
    public void ssiLoadedForDepartment() throws Throwable {
        login = LoadPage.loginPage();
        createDepartmentPage = new CreateDepartmentPage();
    }

    @And("^User is authenticated in portal para departamentos$")
    public void userIsAuthenticatedInPortalParaDepartamentos() throws Throwable {
        login.setCredentials();
    }

    @And("^click on \"([^\"]*)\" menu button de department menu$")
    public void clickOnMenuButtonDeDepartmentMenu(String arg0) throws Throwable {
        createDepartmentPage.clickOnActiveMenuOption();
    }

    @And("^click on \"([^\"]*)\" submenu Button de departament submenu$")
    public void clickOnSubmenuButtonDeDepartamentSubmenu(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage.clickOnSubmenuButton();
    }

    @And("^click on \"([^\"]*)\" Button de department page$")
    public void clickOnButtonDeDepartmentPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage.clickAddDepartment();
    }

    @And("^\"([^\"]*)\" es provisto como nombre de departamento$")
    public void esProvistoComoNombreDeDepartamento(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.departmentName=name;
        createDepartmentPage.setDepartmentName(name);
    }

    @And("^\"([^\"]*)\" es seleccionado como padre$")
    public void esSeleccionadoComoPadre(String parentName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage.setParent(parentName);
    }

    @When("^se realiza click en boton \"([^\"]*)\"$")
    public void seRealizaClickEnBoton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage.clickRegistrar();
    }

    @Then("^El \"([^\"]*)\" es registrado en la base de datos y listado en \"([^\"]*)\"$")
    public void elEsRegistradoEnLaBaseDeDatosYListadoEn(String arg0, String arg1) throws Throwable {
        assertNotNull(createDepartmentPage.getDepartment(departmentName));
    }
}

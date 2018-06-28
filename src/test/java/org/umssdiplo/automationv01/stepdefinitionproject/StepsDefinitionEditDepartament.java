package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.CreateDepartmentPage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionEditDepartament {
    private Login login;
    CreateDepartmentPage createDepartmentPage;
    private String departmentName;

    @Given("^'SSI' loaded for edit departamentos$")
    public void ssiLoadedForDepartment() throws Throwable {
        login = LoadPage.loginPage();
        createDepartmentPage = new CreateDepartmentPage();
    }

    @And("^User is authenticated in portal para editar departamentos$")
    public void userIsAuthenticatedInPortalParaEditarDepartamentos() throws Throwable {
        login.setCredentials();
    }

    @And("^click on \"([^\"]*)\" menu button de editar departmento menu$")
    public void clickOnMenuButtonDeEditarDepartmentoMenu(String arg0) throws Throwable {
        createDepartmentPage.clickOnActiveMenuOption();
    }

    @And("^click on \"([^\"]*)\" submenu Button de editar departamento submenu$")
    public void clickOnSubmenuButtonDeEditarDepartamentoSubmenu(String arg0) throws Throwable {
        createDepartmentPage.clickOnSubmenuButton();
    }

    @And("^click on \"([^\"]*)\" Button de editar departamento$")
    public void clickOnButtonDeEditarDepartamento(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage.clickAddDepartment();
    }

    @And("^\"([^\"]*)\" es provisto como nombre de editar departamento$")
    public void esProvistoComoNombreDeEditarDepartamento(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.departmentName=name;
        createDepartmentPage.setDepartmentName(name);
    }

    @And("^\"([^\"]*)\" es seleccionado como padre de editar departamento$")
    public void esSeleccionadoComoPadreDeEditarDepartamento(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^se realiza click en boton \"([^\"]*)\" para  editar departamento$")
    public void seRealizaClickEnBotonParaEditarDepartamento(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Click boton Edit para el \"([^\"]*)\" a editar$")
    public void clickBotonEditParaElAEditar(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^se Actualiza el nombre del  departamento a \"([^\"]*)\" y click \"([^\"]*)\"$")
    public void seActualizaElNombreDelDepartamentoAYClick(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^Notar que la actualizacion \"([^\"]*)\" se registra en la lista de departamentos$")
    public void notarQueLaActualizacionSeRegistraEnLaListaDeDepartamentos(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

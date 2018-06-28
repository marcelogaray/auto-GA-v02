package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.CreateDepartmentPage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class StepsDefinitionDeleteDepartamento {
    private Login login;
    CreateDepartmentPage createDepartmentPage;
    private String departmentName;

    @Given("^'SSI' loaded for delete department$")
    public void ssiLoadedForDepartment() throws Throwable {
        login = LoadPage.loginPage();
        createDepartmentPage = new CreateDepartmentPage();
    }

    @And("^User is authenticated in portal para delete departamentos$")
    public void userIsAuthenticatedInPortalParaDeleteDepartamentos() throws Throwable {
        login.setCredentials();
    }

    @And("^click on \"([^\"]*)\" menu button de delete department menu$")
    public void clickOnMenuButtonDeDeleteDepartmentMenu(String arg0) throws Throwable {
        createDepartmentPage.clickOnActiveMenuOption();
    }

    @And("^click on \"([^\"]*)\" submenu Button de delete departament submenu$")
    public void clickOnSubmenuButtonDeDeleteDepartamentSubmenu(String arg0) throws Throwable {
        createDepartmentPage.clickOnSubmenuButton();
    }

    @And("^click on \"([^\"]*)\" Button de delete departamento page$")
    public void clickOnButtonDeDeleteDepartamentoPage(String arg0) throws Throwable {
        createDepartmentPage.clickAddDepartment();
    }

    @And("^\"([^\"]*)\" es provisto como nombre de delete departamento$")
    public void esProvistoComoNombreDeDeleteDepartamento(String name) throws Throwable {
        this.departmentName=name;
        createDepartmentPage.setDepartmentName(name);
    }

    @And("^\"([^\"]*)\" es seleccionado como padre de delete departamento$")
    public void esSeleccionadoComoPadreDeDeleteDepartamento(String parentName) throws Throwable {
        createDepartmentPage.setParent(parentName);
    }

    @And("^se realiza click en boton \"([^\"]*)\" de delete departamento$")
    public void seRealizaClickEnBotonDeDeleteDepartamento(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage.clickRegistrar();
    }

    @When("^El \"([^\"]*)\" es registrado en la base de datos y listado en \"([^\"]*)\" de delete departamento$")
    public void elEsRegistradoEnLaBaseDeDatosYListadoEnDeDeleteDepartamento(String arg0, String arg1) throws Throwable {
        assertNotNull(createDepartmentPage.getDepartment(departmentName));
    }

    @Then("^El \"([^\"]*)\" Departamento es eliminado de la lista$")
    public void elDepartamentoEsEliminadoDeLaLista(String arg0) throws Throwable {
        createDepartmentPage.deleteDepartment(arg0);
    }

    @Then("^El \"([^\"]*)\" no se lista en la  lista$")
    public void elNoSeListaEnLaLista(String arg0) throws Throwable {
        assertNull(createDepartmentPage.getDepartment(arg0));
    }
}

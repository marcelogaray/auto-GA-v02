package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.CreateDepartmentPage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.EditDepartmentPage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.ListDepartmentPage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class StepsDefinitionCreateDepartment {
    private static Login login;
    private static CreateDepartmentPage createDepartmentPage;
    private static EditDepartmentPage editDepartmentPage;
    private static ListDepartmentPage listDepartmentPages;
    private String departmentName;
    public static final String BUTTON_EDIT = "Editar";
    public static final String BUTTON_DELETE = "Eliminar";
    private static NavigationBar navigationBar;

    @Given("^'SSI' loaded for department$")
    public void ssiLoadedForDepartment() throws Throwable {
        login = LoadPage.loginPage();
        createDepartmentPage = new CreateDepartmentPage();
    }

    @And("^User is authenticated in portal for departments$")
    public void userIsAuthenticatedInPortalParaDepartamentos() throws Throwable {
        if(navigationBar==null){
            navigationBar = login.setCredentials();
        }
    }

    @And("^click on \"([^\"]*)\" menu button de department menu$")
    public void clickOnMenuButtonDeDepartmentMenu(String arg0) throws Throwable {
        navigationBar.clickOnActiveMenuOption();
    }

    @And("^click on \"([^\"]*)\" submenu Button de department submenu$")
    public void clickOnSubmenuButtonDeDepartamentSubmenu(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        listDepartmentPages = navigationBar.clickOnSubmenuButton();
    }

    @And("^click on \"([^\"]*)\" Button de department page$")
    public void clickOnButtonDeDepartmentPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createDepartmentPage = listDepartmentPages.clickAddDepartment();
    }

    @And("^\"([^\"]*)\" es provisto como nombre de departamento$")
    public void esProvistoComoNombreDeDepartamento(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.departmentName = name;
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
    public void elEsRegistradoEnLaBaseDeDatosYListadoEn(String departmentName, String arg1) throws Throwable {
        assertEquals(listDepartmentPages.getDepartment(this.departmentName),departmentName, "The department name does not match");
    }

    @When("^El \"([^\"]*)\" Departamento es eliminado de la lista$")
    public void elDepartamentoEsEliminadoDeLaLista(String name) throws Throwable {
        listDepartmentPages.actionDepartment(name, BUTTON_DELETE);
    }

    @Then("^El \"([^\"]*)\" no se lista en la  lista$")
    public void elNoSeListaEnLaLista(String departmentName) throws Throwable {
        assertNull(listDepartmentPages.getDepartment(departmentName),"The list still contains the department");
    }


    @And("^Click boton Edit para el \"([^\"]*)\" a editar$")
    public void clickBotonEditParaElAEditar(String name) throws Throwable {
        editDepartmentPage = listDepartmentPages.editDepartment(name, BUTTON_EDIT);
    }

    @When("^se Actualiza el nombre del  departamento a \"([^\"]*)\", se adiciona \"([^\"]*)\" como padre y click \"([^\"]*)\"$")
    public void seActualizaElNombreDelDepartamentoASeAdicionaComoPadreYClick(String name, String parentname, String action) throws Throwable {
        editDepartmentPage.editDepartment(name, parentname, action);
    }

    @Then("^Notar que la actualizacion \"([^\"]*)\" se registra en la lista de departamentos$")
    public void notarQueLaActualizacionSeRegistraEnLaListaDeDepartamentos(String departmentName) throws Throwable {
        assertEquals(listDepartmentPages.getDepartment(departmentName),departmentName, "The department name does not match");
    }

    @When("^se Actualiza el nombre del  departamento a \"([^\"]*)\", se adiciona \"([^\"]*)\" como child y click \"([^\"]*)\"$")
    public void seActualizaElNombreDelDepartamentoASeAdicionaComoChildYClick(String name, String childname, String action) throws Throwable {
        editDepartmentPage.editDepartmentChild(name, childname, action);
    }

    @Then("^Notar que el  child \"([^\"]*)\" tiene como parent \"([^\"]*)\" se registra en la lista de departamentos$")
    public void notarQueElChildTieneComoParentSeRegistraEnLaListaDeDepartamentos(String child, String parent) throws Throwable {
        assertEquals(listDepartmentPages.getChild(child,parent), child, "nombre del child no  coinside");
    }
}

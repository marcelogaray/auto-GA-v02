package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.login.Login;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.positions.RegisterPosition;
import org.umssdiplo.automationv01.core.managepage.positionssubmenu.PositionsSubMenu;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionSSIApplication {
    private static Login login;
    private static NavigationBar navigationBar;
    private OrganizationalStructureMenu organizationalStructureMenu;
    private PositionsSubMenu positionsSubMenu;
    private RegisterPosition registerPosition;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set Admin credentials on 'Login' page$")
    public void setCredentialsOnLoginPage() throws Throwable {
        navigationBar = login.setCredentials();
    }

    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        // Here should be an assertion
    }

    @And("^Click on 'Estructura Organizacional' menu button$")
    public void clickOnEstructuraOrganizacionalMenuButton() throws Throwable {
        organizationalStructureMenu = navigationBar.clickOrganizationalStructure();
    }

    @And("^Click on 'Cargos' option from list menu$")
    public void clickOnCargosOptionFromListMenu() throws Throwable {
        positionsSubMenu = organizationalStructureMenu.clickPositions();
    }

    @And("^Click on 'Agregar Nueva Position' Button in list position page$")
    public void clickOnAgregarNuevaPositionButtonInListPositionPage() throws Throwable {
        registerPosition = positionsSubMenu.clickAddPosition();
    }

    @When("^Click on 'Guardar' button without required fields filled$")
    public void clickOnGuardarButtonWithoutRequiredFieldsFilled() throws Throwable {
        registerPosition.clickSavePosition();
    }

    @Then("^The page title should be \"([^\"]*)\"$")
    public void thePageTitleShouldBe(String expected) throws Throwable {
        Assert.assertEquals(registerPosition.getTitle(), expected);
    }
}

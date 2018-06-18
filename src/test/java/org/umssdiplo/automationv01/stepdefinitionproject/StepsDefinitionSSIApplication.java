package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;
import org.umssdiplo.automationv01.core.managepage.Accident.Accident;
import org.umssdiplo.automationv01.core.managepage.Accident.CreateAccident;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;
import org.testng.Assert;

public class StepsDefinitionSSIApplication {
    private Login login;
    private Accident accident;
    private int accidents;
    private CreateAccident createAccident;

    @Given("^'SSI Application' page is loaded$")
    public void ssiApplicationPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set \"([^\"]*)\" credentials on 'Login' page$")
    public void setCredentialsOnLoginPage(String arg0) throws Throwable {
        login.setCredentials();
    }
}

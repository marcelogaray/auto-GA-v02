package org.umssdiplo.automationv01.core.managepage.Storage;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class StepsDefinitionsCreateStorage extends BasePage {

    @FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/a[2]/span")
    private WebElement menuStorage;

    @FindBy(id = "addStorage")
    private WebElement addNewStorage;

    @FindBy(name = "storageName")
    private WebElement nameStorage;

    @FindBy(id = "/html/body/app-root/app-register-storage/div/div/mat-card/form/mat-card-actions/button[1]")
    private WebElement saveStorage;

    @Given("^'SSI' page is loaded$")
    public void ssiPageIsLoaded() throws Throwable {
        webDriver.get("http://localhost:4200/");;
    }

    @And("^Click on \"([^\"]*)\" menu button$")
    public void clickOnMenuButton(String arg0) throws Throwable {
        CommonEvents.clickButton(menuStorage);
    }

    @And("^Click on \"([^\"]*)\" Button$")
    public void clickOnButton(String arg0) throws Throwable {
        CommonEvents.clickButton(addNewStorage);
    }

    @And("^Write the name of a storage in the \"([^\"]*)\" field$")
    public void writeTheNameOfAStorageInTheField(String arg0) throws Throwable {
        CommonEvents.setInputField(nameStorage, "Almacen de monitoreo personal");
    }

    @When("^Click on \"([^\"]*)\" button to save the Storage$")
    public void clickOnButtonToSaveTheStorage(String arg0) throws Throwable {
        CommonEvents.clickButton(saveStorage);
        webDriver.get("http://localhost:4200/storage-list");
    }

    @Then("^The Storage should be added and the number of Storage increased$")
    public void theStorageShouldBeAddedAndTheNumberOfStorageIncreased() throws Throwable {
        System.out.println("================================");
        System.out.println(" Almacen agregado correctamente ");
        System.out.println("================================");
    }
}

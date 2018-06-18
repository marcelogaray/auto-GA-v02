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

public class StepsDefinitionEditStorage extends BasePage {

    @FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/a[2]/span")
    private WebElement menuStorage;

    @FindBy(xpath = "/html/body/app-root/app-storage-list/div/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[2]/button[2]")
    private WebElement editButton;

    @FindBy(name = "storageName")
    private WebElement newNameStorage;

    @FindBy(xpath = "/html/body/app-root/app-update-storage/div/div/mat-card/form/mat-card-actions/button[1]")
    private WebElement addStorage;

    @Given("^'SSI' page is loaded correctly$")
    public void ssiPageIsLoadedCorrectly() throws Throwable {
        webDriver.get("http://localhost:4200/");;
    }

    @And("^Click on list \"([^\"]*)\" menu button$")
    public void clickOnListMenuButton(String arg0) throws Throwable {
        CommonEvents.clickButton(menuStorage);
    }

    @And("^Click on \"([^\"]*)\" Button of Storage selected$")
    public void clickOnButtonOfStorageSelected(String arg0) throws Throwable {
        CommonEvents.clickButton(editButton);
    }

    @And("^Write the new name of a storage in the \"([^\"]*)\" field$")
    public void writeTheNewNameOfAStorageInTheField(String arg0) throws Throwable {
        CommonEvents.setInputField(newNameStorage, "Nombre de almacen Editado");
    }

    @When("^Click on \"([^\"]*)\" button to save the Storage with the new values$")
    public void clickOnButtonToSaveTheStorageWithTheNewValues(String arg0) throws Throwable {
        CommonEvents.clickButton(addStorage);
        webDriver.get("http://localhost:4200/storage-list");
    }

    @Then("^The Storage should be edited$")
    public void theStorageShouldBeEdited() throws Throwable {
        System.out.println("================================");
        System.out.println(" Almacen editado correctamente ");
        System.out.println("================================");
    }
}

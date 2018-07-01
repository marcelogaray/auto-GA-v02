package org.umssdiplo.automationv01.core.managepage.contingencyplan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.Map;

public class CreateContingencyPlan extends BasePage {
    @FindBy(id = "accident-select")
    private WebElement accidentSelect;

    @FindBy(id = "standart-name-input")
    private WebElement standardNameInput;

    @FindBy(id = "material-input")
    private WebElement materialInput;

    @FindBy(id = "penalties-input")
    private WebElement penaltiesInput;

    @FindBy(id = "description-input")
    private WebElement descriptionInput;

    @FindBy(id = "date-input")
    private WebElement dateInput;

    @FindBy(id = "save-contingency-button")
    private WebElement saveContingencyButton;

    @FindBy(id = "back-contingency-button")
    private WebElement backContingencyButton;

    @FindBy(id = "standart-name-require-message")
    private WebElement standartNameRequireMessage;

    public CreateContingencyPlan() {
        CommonEvents.isVisible(saveContingencyButton);
    }

    public void selectAccidentByText(String textValue) {
        CommonEvents.selectElementByText(accidentSelect, textValue);
    }

    public void setStandardNameInput(String value) {
        CommonEvents.setInputField(standardNameInput, value);
    }

    public void setMaterialInput(String value) {
        CommonEvents.setInputField(materialInput, value);
    }

    public void setPenaltiesInput(String value) {
        CommonEvents.setInputField(penaltiesInput, value);
    }

    public void setDescription(String value) {
        CommonEvents.setInputField(descriptionInput, value);
    }

    public void setDateInput(String value) {
        dateInput.sendKeys(value);
    }

    public ContingencyPlan clickSaveButton() {
        CommonEvents.clickButton(saveContingencyButton);
        return new ContingencyPlan();
    }

    public ContingencyPlan createContingencyPlan(Map<String, String> data) {
        selectAccidentByText(data.get("accident").toString());
        setStandardNameInput(data.get("standardName"));
        setMaterialInput(data.get("material"));
        setPenaltiesInput(data.get("penalties"));
        setDescription(data.get("description"));
        setDateInput(data.get("date"));
        clickSaveButton();
        return new ContingencyPlan();
    }

    public boolean isSaveButtonEnabled() {
        return CommonEvents.isPresent(saveContingencyButton);
    }

    public void clickStandartnameInput() {
        CommonEvents.clickButton(standardNameInput);
    }

    public void clickDescriptinoInput() {
        CommonEvents.clickButton(descriptionInput);
    }

    public String getStandartnameErrorMessage() {
        return CommonEvents.getTextContent(standartNameRequireMessage);
    }
}

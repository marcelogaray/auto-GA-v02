package org.umssdiplo.automationv01.core.managepage.contingencyplan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.Map;

public class EditContingencyPlan extends BasePage {
    @FindBy(id = "accident-select")
    private WebElement accidentSelect;

    @FindBy(id = "standart-name-input")
    private WebElement standartNameInput;

    @FindBy(id = "material-input")
    private WebElement materialInput;

    @FindBy(id = "penalties-input")
    private WebElement penaltiesInput;

    @FindBy(id = "description-input")
    private WebElement descriptionInput;

    @FindBy(id = "date-input")
    private WebElement dateInput;

    @FindBy(id = "edit-contingency-button")
    private WebElement editContingencyButton;

    @FindBy(id = "back-contingency-button")
    private WebElement backContingencyButton;

    @FindBy(id = "standart-name-require-message")
    private WebElement standartNameRequireMessage;

    public EditContingencyPlan() {
        CommonEvents.isVisible(editContingencyButton);
    }

    public void selectAccidentByText(String textValue) {
        CommonEvents.selectElementByText(accidentSelect, textValue);
    }

    public void setStandartNameInput(String value) {
        CommonEvents.setInputField(standartNameInput, value);
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

    public ContingencyPlan clickEditButton() {
        CommonEvents.clickButton(editContingencyButton);
        return new ContingencyPlan();
    }

    public ContingencyPlan editContingencyPlan(Map<String, String> data) {
        selectAccidentByText(data.get("accident").toString());
        setStandartNameInput(data.get("standartName"));
        setMaterialInput(data.get("material"));
        setPenaltiesInput(data.get("penalties"));
        setDescription(data.get("description"));
        clickEditButton();
        return new ContingencyPlan();
    }

    public boolean isEditButtonEnabled() {
        return CommonEvents.isPresent(editContingencyButton);
    }
}

package org.umssdiplo.automationv01.core.managepage.accident;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.Map;

public class ModificarAccident extends BasePage {
    @FindBy(id = "employee-select")
    private WebElement employeeSelect;

    @FindBy(id = "department-select")
    private WebElement departmentSelect;

    @FindBy(id = "description-input")
    private WebElement description;

    @FindBy(id = "severity-input")
    private WebElement severity;

    @FindBy(id = "material-input")
    private WebElement material;

    @FindBy(id = "state-input")
    private WebElement state;

    @FindBy(id = "personal-input")
    private WebElement other;

    @FindBy(id = "seniority-input")
    private WebElement senority;

    @FindBy(id = "date-input")
    private WebElement accidentDate;

    @FindBy(id = "edit-accident-button")
    private WebElement editButton;

    @FindBy(id = "severity-required-message")
    private WebElement severityErrorMessage;


    public void selectEmployeeByValue(String textValue) {
        CommonEvents.selectElementByText(employeeSelect, textValue);
    }

    public void selectDepartmentByValue(String textValue) {
        CommonEvents.selectElementByText(departmentSelect, textValue);
    }

    public void setDescription(String value) {
        CommonEvents.setInputField(description, value);
    }

    public void setSeverity(String value) {
        CommonEvents.setInputField(severity, value);
    }

    public void setMaterial(String value) {
        CommonEvents.setInputField(material, value);
    }

    public void setOther(String value) {
        CommonEvents.setInputField(other, value);
    }

    public void setDate(String value) {
        accidentDate.sendKeys(value);
    }

    public void setState(String value) {
        CommonEvents.setInputField(state, value);
    }

    public void setSenority(String value) {
        CommonEvents.setInputField(senority, value);
    }

    public Accident clickEditButton() {
        CommonEvents.clickButton(editButton);
        return new Accident();
    }

    public Accident editAccident(Map<String, String> data) {
        selectEmployeeByValue(data.get("enployee").toString());
        selectDepartmentByValue(data.get("deparment").toString());
        setDescription(data.get("description"));
        setSeverity(data.get("severity"));
        setMaterial(data.get("material"));
        setState(data.get("state"));
        setSenority(data.get("senority"));
        setOther(data.get("other"));
        setDate(data.get("date"));
        clickEditButton();
        return new Accident();
    }

    public boolean isEditButtonEnabled() {
        return CommonEvents.isPresent(editButton);
    }

    public void clearSeverityInput() {
        CommonEvents.clearInputField(severity);
    }

    public void clickStateInput() {
        CommonEvents.clickButton(state);
    }

    public String getSeverityErrorMessage() {
        return CommonEvents.getTextContent(severityErrorMessage);
    }
}

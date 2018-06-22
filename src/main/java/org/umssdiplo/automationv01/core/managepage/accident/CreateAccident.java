package org.umssdiplo.automationv01.core.managepage.accident;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.Map;

public class CreateAccident extends BasePage {
    @FindBy(id = "employee-select")
    private WebElement employeeSelect;

    @FindBy(id = "department-select")
    private WebElement departmentSelect;

    @FindBy(id = "description-input")
    private WebElement description;

    @FindBy(id = "severity-input")
    private WebElement severity;

    @FindBy(id = "state-input")
    private WebElement state;

    @FindBy(id = "material-input")
    private WebElement material;

    @FindBy(id = "seniority-input")
    private WebElement senority;

    @FindBy(id = "personal-input")
    private WebElement other;

    @FindBy(id = "date-input")
    private WebElement accidentDate;

    @FindBy(id = "save-accident-button")
    private WebElement saveButton;

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

    public void setState(String value) {
        CommonEvents.setInputField(state, value);
    }

    public void setMaterial(String value) {
        CommonEvents.setInputField(material, value);
    }

    public void setSenority(String value) {
        CommonEvents.setInputField(senority, value);
    }

    public void setOther(String value) {
        CommonEvents.setInputField(other, value);
    }

    public void setDate(String value) {
        accidentDate.sendKeys(value);
    }

    public Accident clickSaveButton() {
        CommonEvents.clickButton(saveButton);
        return new Accident();
    }

    public Accident createAccident(Map<String, String> data) {
        selectEmployeeByValue(data.get("enployee").toString());
        selectDepartmentByValue(data.get("deparment").toString());
        setDescription(data.get("description"));
        setSeverity(data.get("severity"));
        setMaterial(data.get("material"));
        setState(data.get("state"));
        setOther("other");
        setSenority(data.get("senority"));
        setDate(data.get("date"));
        clickSaveButton();
        return new Accident();
    }
}

package org.umssdiplo.automationv01.core.managepage.Accident;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreateAccident extends BasePage {

    @FindBy(id = "employeeDropDown")
    private WebElement employeeDropDown;

    @FindBy(xpath = "//*[@id=\"mat-option-10\"]/span")
    private WebElement employee;

    @FindBy(id = "departmentDropDown")
    private WebElement departmentDropDown;

    @FindBy(xpath = "//*[@id=\"mat-option-0\"]/span")
    private WebElement department;

    @FindBy(id = "descriptionInput")
    private WebElement description;

    @FindBy(id = "severityInput")
    private WebElement severity;

    @FindBy(id = "stateInput")
    private WebElement state;

    @FindBy(id = "materialInput")
    private WebElement material;

    @FindBy(id = "seniorityInput")
    private WebElement senority;

    @FindBy(id = "personalInput")
    private WebElement other;

    @FindBy(id = "dateInput")
    private WebElement accidentDate;

    @FindBy(id = "saveButton")
    private WebElement saveButton;


    public void selectEmployee(String value) {
        CommonEvents.clickButton(employeeDropDown);
        CommonEvents.clickButton(employee);
    }

    public void selectDepartment(String value) {
        CommonEvents.clickButton(departmentDropDown);
        CommonEvents.clickButton(department);
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


    public void clickSaveButton() {
        CommonEvents.clickButton(saveButton);
    }

}

package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreateDepartmentPage extends BasePage {

    @FindBy(tagName = "mat-select")
    private WebElement matSelect;

    @FindBy(tagName = "input")
    private WebElement departmentName;

    @FindBy(xpath = "//span[text()= 'Registrar']")
    private WebElement registrar;

    public CreateDepartmentPage(){
//        CommonEvents.isVisible(this.departmentName);
    }


    public void setDepartmentName(String departmentName) {
        CommonEvents.setInputField(this.departmentName, departmentName);
    }

    public void setParent(String parent) {
        CommonEvents.isVisible(this.matSelect);
        CommonEvents.jsClickElement(this.matSelect);
        WebElement selected = CommonEvents.selectMatOption(this.matSelect, parent);
        CommonEvents.jsClickElement(selected);
    }

    public void clickRegistrar() {
        CommonEvents.isVisible(registrar);
        CommonEvents.jsClickElement(registrar);
    }
}

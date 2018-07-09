package org.umssdiplo.automationv01.core.managepage.editdepartmentpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EditDepartmentPage extends BasePage {

    @FindBy(tagName = "mat-select")
    private WebElement matSelect;

    @FindBy(tagName = "input")
    private WebElement departmentName;

    @FindBy(xpath = "//label[contains(text(),'Departamento Padre')]/../..//mat-select")
    private WebElement editParentSelect;

    @FindBy(xpath = "//label[contains(text(),'Departamentos hijos')]/../..//mat-select")
    private WebElement editChildSelect;

    @FindBy(xpath = "//span[contains(text(),'Guardar')]")
    private WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),'Atras')]")
    private WebElement backButton;

    public EditDepartmentPage(){
        CommonEvents.isVisible(this.departmentName);
    }

    public void setDepartmentName(String departmentName) {
        CommonEvents.setInputField(this.departmentName, departmentName);
    }

    public void editDepartment(String name, String childname, String action) {
        setDepartmentName(name);
        CommonEvents.isVisible(this.matSelect);
        CommonEvents.clickButton(this.matSelect);
        WebElement selected = CommonEvents.selectMatOption(this.matSelect, childname);
        CommonEvents.jsClickElement(selected);
        CommonEvents.escape();
        CommonEvents.jsClickElement(saveButton);
    }

    public void editDepartmentChild(String name, String childname, String action) {
        setDepartmentName(name);
        CommonEvents.isVisible(this.editChildSelect);
        CommonEvents.jsClickElement(this.editChildSelect);
        WebElement selected = CommonEvents.selectMatOption(this.editChildSelect, childname);
        CommonEvents.jsClickElement(selected);
        CommonEvents.escape();
        CommonEvents.jsClickElement(saveButton);
    }
}

package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreateDepartmentPage extends BasePage {
//    @FindBy(xpath = "//span[text() = 'Estructura Organizacional']")
//    private WebElement activeMenu;
//
//    @FindBy(xpath = "//span[contains(text(), 'Departamentos')]")
//    private WebElement activeSubmenu;

//    @FindBy(xpath = "//span[text()= 'Agregar Nuevo Departamento']")
//    private WebElement addDepartment;

    @FindBy(tagName = "mat-select")
    private WebElement matSelect;

    @FindBy(tagName = "input")
    private WebElement departmentName;

    @FindBy(xpath = "//span[text()= 'Registrar']")
    private WebElement registrar;

//    @FindBy(tagName = "mat-card")
//    private WebElement table;

    /*edit page*/
//    @FindBy(xpath = "//label[contains(text(),'Departamento Padre')]/../..//mat-select")
//    private WebElement editParentSelect;
//
//    @FindBy(xpath = "//label[contains(text(),'Departamentos hijos')]/../..//mat-select")
//    private WebElement editChildSelect;
//
//    @FindBy(xpath = "//span[contains(text(),'Guardar')]")
//    private WebElement saveButton;
//
//    @FindBy(xpath = "//span[contains(text(),'Atras')]")
//    private WebElement backButton;

//    public void clickOnActiveMenuOption() {
//        CommonEvents.isVisible(activeMenu);
//        CommonEvents.clickButton(activeMenu);
//    }
//
//    public void clickOnSubmenuButton() {
//        CommonEvents.isVisible(activeSubmenu);
//        CommonEvents.jsClickElement(activeSubmenu);
//    }



    public void setDepartmentName(String departmentName) {
        CommonEvents.isVisible(this.departmentName);
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

//    public String getDepartment(String departmentName) {
//        WebElement sCellValue;
//        try {
//            sCellValue = CommonEvents.findWebElementFromMatTable(table, departmentName);
//            System.out.println("Department: " + sCellValue.getTagName() + " " + sCellValue.getText());
//            System.out.println(sCellValue.getText().toString());
//        } catch (Exception e) {
//            return null;
//        }
//        return sCellValue.getText().toString();
//    }

//    public void actionDepartment(String departmentName, String action) {
//        WebElement actionButton = CommonEvents.findButtonByCellofMatTable(table, departmentName, action);
//        System.out.println(actionButton.getTagName() + " " + actionButton.getText());
//        CommonEvents.jsScrollDown(addDepartment);
//        CommonEvents.mouseOver(actionButton);
//        CommonEvents.jsClickElement(actionButton);
//    }

//    public void editDepartment(String name, String childname, String action) {
//        setDepartmentName(name);
//        CommonEvents.isVisible(this.matSelect);
//        CommonEvents.jsClickElement(this.matSelect);
//        WebElement selected = CommonEvents.selectMatOption(this.matSelect, childname);
//        CommonEvents.jsClickElement(selected);
//        CommonEvents.escape();
//        CommonEvents.jsClickElement(saveButton);
//    }
//
//    public void editDepartmentChild(String name, String childname, String action) {
//        setDepartmentName(name);
//        CommonEvents.isVisible(this.editChildSelect);
//        CommonEvents.jsClickElement(this.editChildSelect);
//        WebElement selected = CommonEvents.selectMatOption(this.editChildSelect, childname);
//        CommonEvents.jsClickElement(selected);
//        CommonEvents.escape();
//        CommonEvents.jsClickElement(saveButton);
//    }

//    public String getChild(String child, String parent) {
//        WebElement sCellValue;
//        sCellValue = CommonEvents.findChildFromMatTable(table, child, parent);
//        System.out.println("Department: " + sCellValue.getTagName() + " " + sCellValue.getText());
//        System.out.println(sCellValue.toString());
//        return sCellValue.getText().toString();
//    }
}

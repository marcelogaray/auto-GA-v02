package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreateDepartmentPage extends BasePage {
    @FindBy(xpath = "//span[text() = 'Estructura Organizacional']")
    private WebElement activeMenu;

    @FindBy(xpath = "//span[contains(text(), 'Departamentos')]")
    private WebElement activeSubmenu;

    @FindBy(xpath = "//span[text()= 'Agregar Nuevo Departamento']")
    private WebElement addDepartment;

    @FindBy(tagName = "mat-select")
    private WebElement matSelect;

    @FindBy(tagName = "input")
    private WebElement departmentName;

    @FindBy(xpath = "//span[text()= 'Registrar']")
    private WebElement registrar;

    @FindBy(tagName = "mat-card")
    private WebElement table;



    public void clickOnActiveMenuOption() {
        CommonEvents.isVisible(activeMenu);
        CommonEvents.clickButton(activeMenu);
    }

    public void clickOnSubmenuButton() {
        CommonEvents.isVisible(activeSubmenu);
        CommonEvents.jsClickElement(activeSubmenu);
    }

    public void clickAddDepartment() {
        CommonEvents.isVisible(addDepartment);
        CommonEvents.clickButton(addDepartment);
    }

    public void setDepartmentName(String departmentName) {
        CommonEvents.isVisible(this.departmentName);
        CommonEvents.setInputField(this.departmentName, departmentName);
    }
    public void setParent(String parent) {
        CommonEvents.isVisible(this.matSelect);
        CommonEvents.jsClickElement(this.matSelect);
        CommonEvents.customWait(500);
        WebElement selected = webDriver.findElement(By.xpath("//span[text()= '"+parent+"']"));
        CommonEvents.jsClickElement(selected);
    }
    public void clickRegistrar(){
        CommonEvents.isVisible(registrar);
        CommonEvents.jsClickElement(registrar);
    }

    public String getDepartment(String departmentName) {
        WebElement sCellValue;
        try {
//            System.out.println("//mat-row//[contains(text(),'" + departmentName + "')]")  ;
            sCellValue = table.findElement(By.xpath("//mat-cell[contains(text(),'" + departmentName + "')]"));
            System.out.println("Department: " + sCellValue.getTagName()+" "+sCellValue.getText());
            System.out.println(sCellValue.toString());
        }catch (Exception e){
            return null;
        }
        return sCellValue.getText().toString();
    }

    public void deleteDepartment(String departmentName) {
        WebElement sCellValue = table.findElement(By.xpath("//mat-cell[contains(text(),'" + departmentName + "')]/.."));
        System.out.println("parent: " + sCellValue.getTagName()+" "+sCellValue.getText());
        CommonEvents.jsScrollDown(sCellValue);
        WebElement deleteButton = sCellValue.findElement(By.xpath("//mat-cell[contains(text(),'" + departmentName + "')]/..//button//*[contains(text(),'Eliminar')]"));
        System.out.println(deleteButton.getTagName()+" "+deleteButton.getText());
        CommonEvents.jsScrollDown(addDepartment);
        CommonEvents.mouseOver(deleteButton);
        CommonEvents.jsClickElement(deleteButton);
    }
}

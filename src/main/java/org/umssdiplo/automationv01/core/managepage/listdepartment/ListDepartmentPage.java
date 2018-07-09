package org.umssdiplo.automationv01.core.managepage.listdepartment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.createdepartmentpage.CreateDepartmentPage;
import org.umssdiplo.automationv01.core.managepage.editdepartmentpage.EditDepartmentPage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ListDepartmentPage extends BasePage {
    @FindBy(xpath = "//span[text()= 'Agregar Nuevo Departamento']")
    private WebElement addDepartment;

    @FindBy(tagName = "mat-card")
    private WebElement table;

    public CreateDepartmentPage clickAddDepartment() {
        CommonEvents.customWait(2500);
        CommonEvents.isVisible(addDepartment);
        CommonEvents.jsClickElement(addDepartment);
        return new CreateDepartmentPage();
    }

    public EditDepartmentPage editDepartment(String departmentName, String action){
        CommonEvents.customWait(2500);
        actionDepartment(departmentName,action);
        return new EditDepartmentPage();
    }

    public void actionDepartment(String departmentName, String action) {
        WebElement actionButton = CommonEvents.findButtonByCellofMatTable(table, departmentName, action);
        System.out.println(actionButton.getTagName() + " " + actionButton.getText());
        CommonEvents.jsScrollDown(addDepartment);
        CommonEvents.mouseOver(actionButton);
        CommonEvents.jsClickElement(actionButton);
    }

    public String getDepartment(String departmentName) {
        WebElement sCellValue;
        try {
            sCellValue = CommonEvents.findWebElementFromMatTable(table, departmentName);
            System.out.println("Department: " + sCellValue.getTagName() + " " + sCellValue.getText());
            System.out.println(sCellValue.getText().toString());
        } catch (Exception e) {
            return null;
        }
        return sCellValue.getText().toString();
    }
    public String getChild(String child, String parent) {
        WebElement sCellValue;
        sCellValue = CommonEvents.findChildFromMatTable(table, child, parent);
        System.out.println("Department: " + sCellValue.getTagName() + " " + sCellValue.getText());
        System.out.println(sCellValue.toString());
        return sCellValue.getText().toString();
    }

}

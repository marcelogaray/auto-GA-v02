package org.umssdiplo.automationv01.core.managepage.employee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeeList extends BasePage {
    @FindBy(xpath = "//table[@class='table table-sm table-hover']")
    private WebElement listEmployees;

    public EmployeePage selectEmployee(String name) {
        WebElement sCellValue = listEmployees.findElement(By.xpath("//td[contains(text(),'" + name + "')]"));
        WebElement editButton = sCellValue.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']"));
        CommonEvents.jsClickElement(editButton);
        return new EmployeePage();
    }
}

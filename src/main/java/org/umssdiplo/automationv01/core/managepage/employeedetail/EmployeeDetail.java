package org.umssdiplo.automationv01.core.managepage.employeedetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class EmployeeDetail extends BasePage {
    private final String ele = "employee-delete"+2;

    @FindBy(id = ele)
    private WebElement dropEmployee;

    public EmployeeDetail() { }

    public void clickDropEmployee() {
        dropEmployee.click();
    }
}

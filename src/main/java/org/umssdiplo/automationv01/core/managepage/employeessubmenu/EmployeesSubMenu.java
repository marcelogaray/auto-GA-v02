package org.umssdiplo.automationv01.core.managepage.employeessubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.EmployeeRegister;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeesSubMenu extends BasePage {
    @FindBy(id = "add-employee-button")
    private WebElement addEmployeeButton;

    public EmployeesSubMenu() {
        CommonEvents.isVisible(addEmployeeButton);
    }

    public EmployeeDetail clickEmployeeRegister() {
        CommonEvents.clickButton(addEmployeeButton);
        return new EmployeeDetail();
    }
}

package org.umssdiplo.automationv01.core.managepage.employeessubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.EmployeeRegister;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeesSubMenu extends BasePage {
    @FindBy(id = "employee-update"+17)
    private WebElement addEmployeeButton;

    public EmployeesSubMenu() {
        CommonEvents.isVisible(addEmployeeButton);
    }

    public EmployeeRegister clickEmployeeRegister() {
        CommonEvents.clickButton(addEmployeeButton);
        return new EmployeeRegister();
    }
}

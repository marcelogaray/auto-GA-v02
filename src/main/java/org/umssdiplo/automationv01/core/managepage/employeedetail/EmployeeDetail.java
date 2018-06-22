package org.umssdiplo.automationv01.core.managepage.employeedetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItem;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeeDetail extends BasePage {
    @FindBy(id = "assigned-items-title")
    private WebElement asssignedActiveTitle;

    @FindBy(id = "assign-active")
    private WebElement assignItemButton;

    public EmployeeDetail() {
        CommonEvents.isVisible(asssignedActiveTitle);
    }

    public AssignEmployeeItem clickAssignEmployeeItem() {
        CommonEvents.clickButton(assignItemButton);
        return new AssignEmployeeItem();
    }
}

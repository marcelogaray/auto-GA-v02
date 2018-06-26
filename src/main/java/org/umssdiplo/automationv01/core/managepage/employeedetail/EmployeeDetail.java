package org.umssdiplo.automationv01.core.managepage.employeedetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeeDetail extends BasePage {
    @FindBy(id = "assigned-items-title")
    private WebElement asssignedActiveTitle;

    @FindBy(id = "assign-active")
    private WebElement assignItemButton;

    @FindBy(className = "return-item-btn")
    private WebElement returnButtons;

    @FindBy(id = "assigned-items-title")
    private WebElement assignItemTitle;


    public EmployeeDetail() {
        CommonEvents.isVisible(asssignedActiveTitle);
    }

    public AssignEmployeeItemModal clickAssignEmployeeItem() {
        CommonEvents.clickButton(assignItemButton);
        return new AssignEmployeeItemModal();
    }

    public boolean existReturnButton() {
        return CommonEvents.isPresent(returnButtons);
    }

    public boolean existAssignItemTitleSection() {
        return CommonEvents.isPresent(assignItemTitle);
    }
}

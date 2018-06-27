package org.umssdiplo.automationv01.core.managepage.employeedetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class EmployeeDetail extends BasePage {
    @FindBy(id = "assigned-items-title")
    private WebElement assignedActiveTitle;

    @FindBy(id = "assign-active")
    private WebElement assignItemButton;

    @FindBy(id = "employee-detail-title")
    private WebElement pageTitle;

    @FindBy(css = ".mat-list-item.mat-3-line.ng-star-inserted")
    private List<WebElement> assignedItems;

    public EmployeeDetail() {
        CommonEvents.isVisible(assignedActiveTitle);
    }

    public AssignEmployeeItemModal clickAssignEmployeeItem() {
        CommonEvents.clickButton(assignItemButton);
        return new AssignEmployeeItemModal();
    }

    public int countAssignedItems() {
        CommonEvents.customWait(3000);
        return CommonEvents.countElement(assignedItems);
    }

    public boolean hasAssignItemButton() {
        return CommonEvents.isPresent(assignItemButton);
    }

    public String getTitle() {
        return pageTitle.getText();
    }
}

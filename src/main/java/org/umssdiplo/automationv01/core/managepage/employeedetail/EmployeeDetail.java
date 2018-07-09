package org.umssdiplo.automationv01.core.managepage.employeedetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class EmployeeDetail extends BasePage {
    @FindBy(id = "assign-active")
    private WebElement assignItemButton;

    @FindBy(className = "return-item-btn")
    private WebElement returnButton;

    @FindBy(id = "assigned-items-title")
    private WebElement assignItemTitle;

    @FindBy(id = "employee-detail-title")
    private WebElement pageTitle;

    @FindBy(css = ".mat-list-item.mat-3-line.ng-star-inserted")
    private List<WebElement> assignedItems;

    public EmployeeDetail() {
        CommonEvents.isVisible(assignItemTitle);
    }

    public AssignEmployeeItemModal clickAssignEmployeeItem() {
        CommonEvents.customWait(2500);
        CommonEvents.clickButton(assignItemButton);
        return new AssignEmployeeItemModal();
    }

    public boolean existReturnButton() {
        return CommonEvents.isPresent(returnButton);
    }

    public boolean existAssignItemTitleSection() {
        return CommonEvents.isPresent(assignItemTitle);
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

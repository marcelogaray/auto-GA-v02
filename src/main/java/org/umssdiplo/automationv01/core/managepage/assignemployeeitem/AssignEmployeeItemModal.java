package org.umssdiplo.automationv01.core.managepage.assignemployeeitem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class AssignEmployeeItemModal extends BasePage {
    @FindBy(id = "cancel-assign-item-btn")
    private WebElement cancelAssignButton;

    @FindBy(id = "assign-item-btn")
    private WebElement assignButton;

    @FindBy(id = "assign-item-title")
    private WebElement assignItemTitle;

    @FindBy(id = "state-item-dropdown")
    private WebElement stateItemDropdown;

    @FindBy(id = "item-dropdown")
    private WebElement itemDropdown;

    @FindBy(id = "mat-option-0")
    private WebElement stateItemOption;

    @FindBy(id = "mat-option-5")
    private WebElement itemOption;

    @FindBy(className = ".mat-list-item.mat-3-line.ng-star-inserted")
    private List<WebElement> assignedItems;

    public AssignEmployeeItemModal() {
        CommonEvents.isPresent(cancelAssignButton);
    }

    public boolean isAssignButtonEnabled() {
        return assignButton.isEnabled();
    }

    public String getTitle() {
        return assignItemTitle.getText();
    }

    public EmployeeDetail clickCancel() {
        CommonEvents.clickButton(cancelAssignButton);
        return new EmployeeDetail();
    }

    public boolean hasStateItemDropdown() {
        return CommonEvents.isPresent(stateItemDropdown);
    }

    public void clickStateItemDropdown() {
        CommonEvents.clickButton(stateItemDropdown);
    }

    public void selectStateItemDropdown() {
        CommonEvents.clickButton(stateItemOption);
    }

    public void clickItemDropdown() {
        CommonEvents.clickButton(itemDropdown);
    }

    public void selectItem() {
        CommonEvents.clickButton(itemOption);
    }

    public boolean hasItemDropdown() {
        return CommonEvents.isPresent(itemDropdown);
    }

    public EmployeeDetail clickAssignButton() {
        CommonEvents.clickButton(assignButton);
        return new EmployeeDetail();
    }
}

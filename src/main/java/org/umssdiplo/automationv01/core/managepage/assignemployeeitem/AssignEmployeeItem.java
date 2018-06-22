package org.umssdiplo.automationv01.core.managepage.assignemployeeitem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AssignEmployeeItem extends BasePage {
    @FindBy(id = "cancel-assign-item-btn")
    private WebElement cancelAssignButton;

    @FindBy(id = "assign-item-btn")
    private WebElement assignButton;

    public AssignEmployeeItem() {
        CommonEvents.isPresent(cancelAssignButton);
    }

    public boolean isAssignButtonDisabled() {
        return assignButton.isDisplayed();
    }
}

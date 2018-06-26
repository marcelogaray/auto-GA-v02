package org.umssdiplo.automationv01.core.managepage.reportstorage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.employeedetail.EmployeeDetail;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ReportStorage extends BasePage {
    @FindBy(id = "backStorageButton")
    private WebElement backStorageButton;

    public ReportStorage() {
        CommonEvents.isVisible(backStorageButton);
    }

    public boolean isBackStorageButtonDisabled() {
        return backStorageButton.isDisplayed();
    }
}

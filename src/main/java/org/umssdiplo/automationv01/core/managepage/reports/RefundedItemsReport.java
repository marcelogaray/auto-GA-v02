
package org.umssdiplo.automationv01.core.managepage.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class RefundedItemsReport extends BasePage {
    @FindBy(id = "first-column-header")
    private WebElement employeeNameColumnTitle;

    @FindBy(id = "second-column-header")
    private WebElement employeeLastNameColumnTitle;

    @FindBy(id = "third-column-header")
    private WebElement itemCodeColumnTitle;

    @FindBy(id = "fourth-column-header")
    private WebElement itemNameColumnTitle;

    @FindBy(id = "fifth-column-header")
    private WebElement stateColumnTitle;

    @FindBy(id = "sixth-column-header")
    private WebElement dateColumnTitle;

    public RefundedItemsReport() {
        CommonEvents.isVisible(dateColumnTitle);
    }

    public String getFirstHeaderTable() {
        return employeeNameColumnTitle.getText();
    }

    public String getSecondHeaderTable() {
        return employeeLastNameColumnTitle.getText();
    }

    public String getThirdHeaderTable() {
        return itemCodeColumnTitle.getText();
    }

    public String getFourthHeaderTable() {
        return itemNameColumnTitle.getText();
    }

    public String getFifthHeaderTable() {
        return stateColumnTitle.getText();
    }

    public String getSixthHeaderTable() {
        return dateColumnTitle.getText();
    }
}

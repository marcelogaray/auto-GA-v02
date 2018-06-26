
package org.umssdiplo.automationv01.core.managepage.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class RefundedItemsReport extends BasePage {
    @FindBy(id = "first-column-header")
    private WebElement firstColumnTitle;

    @FindBy(id = "second-column-header")
    private WebElement secondColumnTitle;

    @FindBy(id = "third-column-header")
    private WebElement thirdColumnTitle;

    @FindBy(id = "fourth-column-header")
    private WebElement fourthColumnTitle;

    @FindBy(id = "fifth-column-header")
    private WebElement fifthColumnTitle;

    @FindBy(id = "sixth-column-header")
    private WebElement sixthColumnTitle;

    public RefundedItemsReport() {
        CommonEvents.isVisible(sixthColumnTitle);
    }

    public String getFirstHeaderTable() {
        return firstColumnTitle.getText();
    }

    public String getSecondHeaderTable() {
        return secondColumnTitle.getText();
    }

    public String getThirdHeaderTable() {
        return thirdColumnTitle.getText();
    }

    public String getFourthHeaderTable() {
        return fourthColumnTitle.getText();
    }

    public String getFifthHeaderTable() {
        return fifthColumnTitle.getText();
    }

    public String getSixthHeaderTable() {
        return sixthColumnTitle.getText();
    }
}

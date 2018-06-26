
package org.umssdiplo.automationv01.core.managepage.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AvailableItemsReport extends BasePage {

    @FindBy(id = "first-column-header")
    private WebElement firstColumnTitle;

    @FindBy(id = "second-column-header")
    private WebElement secondColumnTitle;

    @FindBy(id = "third-column-header")
    private WebElement thirdColumnTitle;

    public AvailableItemsReport() {
        CommonEvents.isVisible(thirdColumnTitle);
    }

    public String getFirstHeaderTable() {
        return firstColumnTitle.getText();
    }

    public String getSecondHeaderTable() {
        return secondColumnTitle.getText();
    }

    public String getThirdTable() {
        return thirdColumnTitle.getText();
    }
}

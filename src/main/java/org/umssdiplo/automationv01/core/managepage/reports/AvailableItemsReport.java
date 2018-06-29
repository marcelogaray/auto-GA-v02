
package org.umssdiplo.automationv01.core.managepage.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AvailableItemsReport extends BasePage {

    @FindBy(id = "first-column-header")
    private WebElement codeColumnTitle;

    @FindBy(id = "second-column-header")
    private WebElement materialNameColumnTitle;

    @FindBy(id = "third-column-header")
    private WebElement statusColumnTitle;

    public AvailableItemsReport() {
        CommonEvents.isVisible(statusColumnTitle);
    }

    public String getFirstHeaderTable() {
        return codeColumnTitle.getText();
    }

    public String getSecondHeaderTable() {
        return materialNameColumnTitle.getText();
    }

    public String getThirdTable() {
        return statusColumnTitle.getText();
    }
}

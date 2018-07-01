
package org.umssdiplo.automationv01.core.managepage.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class StorageReport extends BasePage {
    @FindBy(id = "first-column-header-storage")
    private WebElement storageColumnTitle;

    @FindBy(id = "second-column-header-storage")
    private WebElement itemNameColumnTitle;

    @FindBy(id = "thrid-column-header-storage")
    private WebElement brandColumnTitle;

    @FindBy(id = "fourth-column-header-storage")
    private WebElement typeColumnTitle;

    @FindBy(id = "fifth-column-header-storage")
    private WebElement quantityColumnTitle;

    @FindBy(id = "title-storage-reports")
    private WebElement titleStorageReports;

    public StorageReport() {
        CommonEvents.isVisible(quantityColumnTitle);
    }

    public String getFirstHeaderTable() {
        return storageColumnTitle.getText();
    }

    public String getSecondHeaderTable() {
        return itemNameColumnTitle.getText();
    }

    public String getThirdTable() {
        return brandColumnTitle.getText();
    }

    public String getFourthTable() {
        return typeColumnTitle.getText();
    }

    public String getTitle() {
        return titleStorageReports.getText();
    }
}

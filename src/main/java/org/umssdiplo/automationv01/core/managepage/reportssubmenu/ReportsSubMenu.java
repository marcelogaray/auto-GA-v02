
package org.umssdiplo.automationv01.core.managepage.reportssubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.reports.AvailableItemsReport;
import org.umssdiplo.automationv01.core.managepage.reports.RefundedItemsReport;
import org.umssdiplo.automationv01.core.managepage.reports.StorageReport;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ReportsSubMenu extends BasePage {

    @FindBy(id = "sub-menu-available-item")
    private WebElement availableItemsReport;

    @FindBy(id = "sub-menu-refund-item")
    private WebElement refundedItemsReport;

    @FindBy(id = "sub-menu-audit-history")
    private WebElement auditHistoryReport;

    @FindBy(id = "sub-menu-report-storage")
    private WebElement storageReport;

    public ReportsSubMenu() {
        CommonEvents.isVisible(auditHistoryReport);
    }

    public AvailableItemsReport clickAvailableItemsReport() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(availableItemsReport);
        return new AvailableItemsReport();
    }

    public RefundedItemsReport clickRefundedItemsReport() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(refundedItemsReport);
        return new RefundedItemsReport();
    }

    public StorageReport clickStorageReport() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(storageReport);
        return new StorageReport();
    }
}

package org.umssdiplo.automationv01.core.managepage.reportsmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.reportstorage.ReportStorage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ReportsMenu extends BasePage {
    @FindBy(id = "reportsMenu")
    private WebElement reportsMenu;

    @FindBy(id = "report-storage")
    private WebElement reportStorage;

    public ReportsMenu() {
        CommonEvents.isVisible(reportStorage);
    }

    public ReportStorage clickReportStorages() {
        CommonEvents.customWait(5000);
        CommonEvents.clickButton(reportStorage);
        return new ReportStorage();
    }
}

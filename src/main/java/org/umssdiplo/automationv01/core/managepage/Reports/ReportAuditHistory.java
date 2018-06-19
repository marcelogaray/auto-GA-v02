package org.umssdiplo.automationv01.core.managepage.Reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ReportAuditHistory extends BasePage {
    @FindBy(xpath = "//span[text() = 'Reportes']")
    private WebElement activeMenu;

    @FindBy(xpath = "//span[contains(text(), 'Reporte de Modificaciones de Datos')]")
    private WebElement activeSubmenu;

    @FindBy(id = "//mat-card[@class='mat-card']")
    private WebElement table;

    public  void clickOnActiveMenuOption(){
        CommonEvents.clickButton(activeMenu);
    }

    public  void clickOnSubmenuButton(){
        CommonEvents.isVisible(activeSubmenu);
        CommonEvents.clickButton(activeSubmenu);
    }


}

package org.umssdiplo.automationv01.core.managepage.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ReportAuditHistory extends BasePage {
    @FindBy(xpath = "//span[text() = 'Reportes']")
    private WebElement activeMenu;

    @FindBy(xpath = "//span[contains(text(), 'Reporte de Modificaciones de Datos')]")
    private WebElement activeSubmenu;

    @FindBy(tagName = "mat-card")
    private WebElement table;

    public  void clickOnActiveMenuOption(){
        CommonEvents.clickButton(activeMenu);
    }

    public  void clickOnSubmenuButton(){
        CommonEvents.jsScrollDown(activeSubmenu);
        CommonEvents.isVisible(activeSubmenu);
        CommonEvents.jsClickElement(activeSubmenu);
    }

    public String getSalary(String newSalary){
        WebElement sCellValue;
        try {
            sCellValue = table.findElement(By.xpath("//mat-cell[contains(text(),'" + newSalary + "')]"));
        }catch (Exception e){
            return null;
        }
        return sCellValue.getText().toString();
    }
}

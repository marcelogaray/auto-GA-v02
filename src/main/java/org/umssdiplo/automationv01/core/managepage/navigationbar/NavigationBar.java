package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.storage.StorageList;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    @FindBy(id = "menu-organizational")
    private WebElement organizationalMenu;

    @FindBy(id = "storageMenu")
    private WebElement storageMenu;

    @FindBy(xpath = "//mat-row[10]/mat-cell[1]")
    private WebElement nombrealmacen;

    public NavigationBar() {
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        CommonEvents.clickButton(organizationalMenu);
        return new OrganizationalStructureMenu();
    }

    public StorageList clickStorages() {
        CommonEvents.clickButton(storageMenu);
        return new StorageList();
    }
}

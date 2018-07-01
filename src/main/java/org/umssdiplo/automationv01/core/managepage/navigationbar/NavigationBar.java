package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu.AccidentEIncidentMenu;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.managepage.storage.Storage;
import org.umssdiplo.automationv01.core.managepage.storagemenu.StorageMenu;
import org.umssdiplo.automationv01.core.managepage.reportssubmenu.ReportsSubMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    @FindBy(id = "menu-organizational")
    private WebElement organizationalMenu;

    @FindBy(id = "accident-incident-button")
    private WebElement accidentIncidentMenu;

    @FindBy(id = "menu-storage")
    private WebElement storageMenu;

    public NavigationBar() {
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        CommonEvents.clickButton(organizationalMenu);
        return new OrganizationalStructureMenu();
    }

    public ReportsSubMenu clickReports() {
        CommonEvents.clickButton(reportsMenu);
        return new ReportsSubMenu();
    }

    public AccidentEIncidentMenu clickAccidentEIncidentButton() {
        CommonEvents.clickButton(accidentIncidentMenu);
        return new AccidentEIncidentMenu();
    }

    public Storage clickStorageButton() {
        CommonEvents.clickButton(storageMenu);
        return new Storage();
    }
}

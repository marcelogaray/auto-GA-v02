package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu.AccidentEIncidentMenu;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    @FindBy(id = "menu-organizational")
    private WebElement organizationalMenu;

    @FindBy(id = "accident-incident-button")
    private WebElement accidentEIncidentMenu;

    public NavigationBar() {
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        CommonEvents.clickButton(organizationalMenu);
        return new OrganizationalStructureMenu();
    }

    public AccidentEIncidentMenu clickAccidentEIncidentButton() {
        CommonEvents.clickButton(accidentEIncidentMenu);
        return new AccidentEIncidentMenu();
    }
}

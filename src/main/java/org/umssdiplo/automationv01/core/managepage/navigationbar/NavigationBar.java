package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    public NavigationBar() {
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        return new OrganizationalStructureMenu();
    }
}

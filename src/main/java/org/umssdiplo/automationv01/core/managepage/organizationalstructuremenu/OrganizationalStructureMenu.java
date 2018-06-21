package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class OrganizationalStructureMenu extends BasePage {
    @FindBy(id = "sub-menu-list-position")
    private WebElement positionSubMenu;

    @FindBy(id = "sub-menu-employees")
    private WebElement employeeSubMenu;

    public OrganizationalStructureMenu() {
        CommonEvents.isVisible(positionSubMenu);
    }

    public EmployeesSubMenu clickEmployees() {
        CommonEvents.clickButton(employeeSubMenu);
        return new EmployeesSubMenu();
    }
}

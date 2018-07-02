package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.RegisterContract;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.positionssubmenu.PositionsSubMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class OrganizationalStructureMenu extends BasePage {
    @FindBy(id = "sub-menu-positions")
    private WebElement positionSubMenu;

    @FindBy(id = "sub-menu-employees")
    private WebElement employeeSubMenu;

    @FindBy(id = "sub-menu-contracts")
    private WebElement contractButton;

    public OrganizationalStructureMenu() {
        CommonEvents.isVisible(positionSubMenu);
    }

    public EmployeesSubMenu clickEmployees() {
        CommonEvents.clickButton(employeeSubMenu);
        return new EmployeesSubMenu();
    }

    public PositionsSubMenu clickPositions() {
        CommonEvents.clickButton(positionSubMenu);
        return new PositionsSubMenu();
    }

    public RegisterContract clickContracts() {
        CommonEvents.clickButton(contractButton);
        return new RegisterContract();
    }
}

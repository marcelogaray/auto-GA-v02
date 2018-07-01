package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.positionssubmenu.PositionsSubMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class OrganizationalStructureMenu extends BasePage {

    @FindBy(xpath = "//span[text() = 'Estructura Organizacional']")
    private WebElement employeeMenu;

    @FindBy(id = "sub-menu-positions")
    private WebElement positionSubMenu;

    @FindBy(xpath = "//span[text() = 'Empleados']")
    private WebElement employeeSubMenu;

    public OrganizationalStructureMenu() {
        CommonEvents.isVisible(employeeMenu);
    }

    public EmployeeList clickEmployees() {
        CommonEvents.clickButton(employeeMenu);
        CommonEvents.jsClickElement(employeeSubMenu);
        System.out.println("Return employee list");
        return new EmployeeList();
    }

    public PositionsSubMenu clickPositions() {
        CommonEvents.clickButton(positionSubMenu);
        return new PositionsSubMenu();
    }
}

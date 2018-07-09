package org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.RegisterContract;
import org.umssdiplo.automationv01.core.managepage.employee.EmployeeList;
import org.umssdiplo.automationv01.core.managepage.employeessubmenu.EmployeesSubMenu;
import org.umssdiplo.automationv01.core.managepage.listdepartment.ListDepartmentPage;
import org.umssdiplo.automationv01.core.managepage.positionssubmenu.PositionsSubMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;



public class OrganizationalStructureMenu extends BasePage {
    @FindBy(id = "sub-menu-positions")
    private WebElement positionSubMenu;

    @FindBy(id = "sub-menu-employees")
    private WebElement employeeSubMenu;

    @FindBy(id = "sub-menu-contracts")
    private WebElement contractButton;

    @FindBy(id = "sub-menu-departments")
    private WebElement activeSubmenu;

    public OrganizationalStructureMenu() {
        CommonEvents.isVisible(positionSubMenu);
    }

    public EmployeesSubMenu clickEmployees() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(employeeSubMenu);
        return new EmployeesSubMenu();
    }

    public PositionsSubMenu clickPositions() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(positionSubMenu);
        return new PositionsSubMenu();
    }

    public RegisterContract clickContracts() {
        CommonEvents.customWait(2500);
        CommonEvents.clickButton(contractButton);
        return new RegisterContract();
    }

    public ListDepartmentPage clickOnSubmenuButton() {
        CommonEvents.customWait(2500);
        CommonEvents.isVisible(activeSubmenu);
        CommonEvents.clickButton(activeSubmenu);
        return new ListDepartmentPage();
    }

    public EmployeeList clickEmployeesList() {
        CommonEvents.customWait(2500);
        CommonEvents.jsClickElement(employeeSubMenu);
        return new EmployeeList();
    }

}

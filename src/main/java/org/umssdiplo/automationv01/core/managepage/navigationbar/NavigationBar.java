package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.EmployeeList;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.ListDepartmentPage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import javax.smartcardio.CommandAPDU;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    @FindBy(id = "menu-organizational")
    private WebElement activeMenu;

    @FindBy(id = "sub-menu-departments")
    private WebElement activeSubmenu;

    @FindBy(id = "sub-menu-employees")
    private WebElement employeeSubMenu;

    public NavigationBar() {
        CommonEvents.customWait(900);
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        return new OrganizationalStructureMenu();
    }

    public void clickOnActiveMenuOption() {
        CommonEvents.isVisible(activeMenu);
        CommonEvents.jsClickElement(activeMenu);
    }

    public ListDepartmentPage clickOnSubmenuButton() {
        CommonEvents.isVisible(activeSubmenu);
        CommonEvents.clickButton(activeSubmenu);
        return new ListDepartmentPage();
    }
    public EmployeeList clickEmployees() {
        CommonEvents.isVisible(activeMenu);
        CommonEvents.clickButton(activeMenu);

        CommonEvents.jsClickElement(employeeSubMenu);
        System.out.println("Return employee list");
        return new EmployeeList();
    }
}

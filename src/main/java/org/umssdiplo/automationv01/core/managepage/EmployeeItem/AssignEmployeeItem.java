package org.umssdiplo.automationv01.core.managepage.EmployeeItem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AssignEmployeeItem extends BasePage {
    @FindBy(id = "menu-organizational")
    private WebElement menuOrganizationalButton;

    @FindBy(id = "sub-menu-employees")
    private WebElement employeesOption;

    @FindBy(id = "employee-detail")
    private WebElement employeeDetailOption;

    @FindBy(id = "assign-active")
    private WebElement assignActiveButton;

    @FindBy(id = "assign-item-title")
    private WebElement assignItemTitle;

    @FindBy(id = "assign-item-btn")
    private WebElement assignItemButton;

    public void clickOnEstructuraOrganizacionalMenuButton(){
        CommonEvents.clickButton(menuOrganizationalButton);
    }

    public void clickOnEmpleadosOption(){
        CommonEvents.clickButton(employeesOption);
    }

    public void clickOnEmployeeDetailButton(){
        CommonEvents.clickButton(employeeDetailOption);
    }

    public void clickOnAsignarActivoButton(){
        CommonEvents.clickButton(assignActiveButton);
    }

    public String getTitleText(){
        return assignItemTitle.getText();
    }

    public boolean isAssignButtonEnabled(){
        return assignItemButton.isEnabled();
    }

}
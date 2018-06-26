package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeeRegister extends BasePage {
    String NAME = "Juan";
    String LASTNAME = "Luna";
    String ADDRESS = "Av. Ayacucho 1022 entre Heroinas y Bolivar";

    @FindBy(id = "btn-registrar")
    private WebElement addEmployeeBtn;

    @FindBy(id = "emp-name")
    private WebElement employeeName;

    @FindBy(id = "emp-lastname")
    private WebElement employeeLastName;

    @FindBy(id = "emp-address")
    private WebElement employeeAddress;

    public void clickAddEmployeeButton(){
        CommonEvents.clickButton(addEmployeeBtn);
    }

    public void fillForm(){
        employeeName.sendKeys(NAME);
        employeeLastName.sendKeys(LASTNAME);
        employeeAddress.sendKeys(ADDRESS);
    }
}

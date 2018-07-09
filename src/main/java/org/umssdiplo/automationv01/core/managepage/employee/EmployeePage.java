package org.umssdiplo.automationv01.core.managepage.employee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeePage extends BasePage {
    @FindBy(name="salary")
    private WebElement salary;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registryButton;

    public void setSalary(String salary){
        CommonEvents.isVisible(this.salary);
        CommonEvents.setInputField(this.salary,salary);
        CommonEvents.clickButton(registryButton);
    }
}

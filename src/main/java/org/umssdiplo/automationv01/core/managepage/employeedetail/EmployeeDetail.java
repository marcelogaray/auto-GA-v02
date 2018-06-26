package org.umssdiplo.automationv01.core.managepage.employeedetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.assignemployeeitem.AssignEmployeeItemModal;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EmployeeDetail extends BasePage {
    @FindBy(id = "titulo-lista")
    private WebElement asssignedActiveTitle;

    private boolean titulo;

    public EmployeeDetail() {
        titulo = CommonEvents.isVisible(asssignedActiveTitle);
    }

    public boolean isListofEmployeesShowing() {
        return titulo;
    }
}

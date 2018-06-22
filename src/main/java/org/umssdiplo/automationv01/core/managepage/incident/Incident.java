package org.umssdiplo.automationv01.core.managepage.incident;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Incident extends BasePage {
    private static final String DELETE_BUTTON_CLASS = "delete-incident-button";
    @FindBy(id = "create-incident-button")
    private WebElement createIncidentButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> Incidents;

    public Incident() {
        CommonEvents.isVisible(createIncidentButton);
    }

    public int countIncidents() {
        return CommonEvents.countElement(Incidents);
    }

    public void deleteIncident(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(Incidents.get(position), DELETE_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
    }
}

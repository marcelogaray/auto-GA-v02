package org.umssdiplo.automationv01.core.managepage.incident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Incident extends BasePage {
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
        CommonEvents.clickButton(Incidents.get(position).findElement(By.cssSelector(".delete-incident-button")));
    }
}

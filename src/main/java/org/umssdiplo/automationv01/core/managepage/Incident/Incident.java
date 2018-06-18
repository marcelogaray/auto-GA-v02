package org.umssdiplo.automationv01.core.managepage.Incident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Incident extends BasePage {

    @FindBy(id = "createIncident")
    private WebElement createIncidentButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> incidents;

    @FindBy(id = "accidentView")
    private WebElement incidentEIncidentButton;

    @FindBy(id = "incidentLink")
    private WebElement incidentLink;

    public void createIncident() {
        CommonEvents.clickButton(createIncidentButton);
    }

    public int countIncident() {
        return CommonEvents.countElement(incidents);
    }

    public void selectIncidentLink() {
        CommonEvents.clickButton(incidentEIncidentButton);
        CommonEvents.clickButton(incidentLink);
    }

    public void deleteIncident() {
        incidents.get(0).findElement(By.cssSelector(".deleteButton")).click();
    }
}

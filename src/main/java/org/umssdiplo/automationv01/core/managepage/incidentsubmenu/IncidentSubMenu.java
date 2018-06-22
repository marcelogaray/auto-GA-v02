package org.umssdiplo.automationv01.core.managepage.incidentsubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.incident.Incident;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class IncidentSubMenu extends BasePage {
    @FindBy(id = "incident-button")
    private WebElement incidentButton;

    public IncidentSubMenu() {
        CommonEvents.isVisible(incidentButton);
    }

    public Incident clickIncidentButton() {
        CommonEvents.clickButton(incidentButton);
        return new Incident();
    }
}

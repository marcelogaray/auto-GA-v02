package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.incident.Incident;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    @FindBy(id = "accident-incident-button")
    private WebElement accidentEIncidentButton;

    @FindBy(id = "incident-button")
    private WebElement incidentButton;

    public NavigationBar() {
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        return new OrganizationalStructureMenu();
    }

    public void clickAccidentEIncidentButton() {
        CommonEvents.clickButton(accidentEIncidentButton);
    }

    public Incident clickIncidentButton() {
        CommonEvents.clickButton(incidentButton);
        return new Incident();
    }

    public Incident goToIncidentPage() {
        clickAccidentEIncidentButton();
        return clickIncidentButton();
    }
}

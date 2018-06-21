package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.organizationalstructuremenu.OrganizationalStructureMenu;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class NavigationBar extends BasePage {
    @FindBy(id = "menu-reports")
    private WebElement reportsMenu;

    @FindBy(id = "accident-incident-button")
    private WebElement accidentEIncidentButton;

    @FindBy(id = "accident-button")
    private WebElement accidentButton;

    public NavigationBar() {
        CommonEvents.isVisible(reportsMenu);
    }

    public OrganizationalStructureMenu clickOrganizationalStructure() {
        return new OrganizationalStructureMenu();
    }

    public void clickAccidentEIncidentButton() {
        CommonEvents.clickButton(accidentEIncidentButton);
    }

    public Accident clickAccidentButton() {
        CommonEvents.clickButton(accidentButton);
        return new Accident();
    }

    public Accident goToAccidentPage() {
        clickAccidentEIncidentButton();
        return clickAccidentButton();
    }
}

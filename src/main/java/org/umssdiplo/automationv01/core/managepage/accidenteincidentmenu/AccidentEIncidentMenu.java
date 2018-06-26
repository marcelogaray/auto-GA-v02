package org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AccidentEIncidentMenu extends BasePage{
    @FindBy(id = "accident-button")
    private WebElement accidentButton;

    public AccidentEIncidentMenu() {
        CommonEvents.isVisible(accidentButton);
    }

    public Accident clickAccidentButton() {
        CommonEvents.clickButton(accidentButton);
        return new Accident();
    }
}

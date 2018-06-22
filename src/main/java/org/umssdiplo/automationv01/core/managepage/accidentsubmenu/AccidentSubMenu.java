package org.umssdiplo.automationv01.core.managepage.accidentsubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AccidentSubMenu extends BasePage{
    @FindBy(id = "accident-button")
    private WebElement accidentButton;

    public AccidentSubMenu() {
        CommonEvents.isVisible(accidentButton);
    }

    public Accident clickAccidentButton() {
        CommonEvents.clickButton(accidentButton);
        return new Accident();
    }
}

package org.umssdiplo.automationv01.core.managepage.accidenteincidentmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.managepage.contingencyplan.ContingencyPlan;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AccidentEIncidentMenu extends BasePage {
    @FindBy(id = "accident-button")
    private WebElement accidentButton;

    @FindBy(id = "contingency-button")
    private WebElement contingencyButton;

    public AccidentEIncidentMenu() {
        CommonEvents.isVisible(accidentButton);
    }

    public Accident clickAccidentButton() {
        CommonEvents.clickButton(accidentButton);
        return new Accident();
    }

    public ContingencyPlan clickContingencyButton() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(contingencyButton);
        return new ContingencyPlan();
    }
}

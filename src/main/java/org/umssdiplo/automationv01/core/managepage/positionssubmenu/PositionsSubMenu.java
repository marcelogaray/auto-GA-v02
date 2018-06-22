package org.umssdiplo.automationv01.core.managepage.positionssubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.positions.RegisterPosition;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class PositionsSubMenu extends BasePage {
    @FindBy(id = "add-position")
    private WebElement addPositionButton;

    public PositionsSubMenu() {
        CommonEvents.isVisible(addPositionButton);
    }

    public RegisterPosition clickAddPosition() {
        CommonEvents.clickButton(addPositionButton);
        return new RegisterPosition();
    }
}

package org.umssdiplo.automationv01.core.managepage.positions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class RegisterPosition extends BasePage {
    @FindBy(id = "save-position")
    private WebElement savePositionButton;

    @FindBy(id = "register-position-title")
    private WebElement addPositionTitle;

    public RegisterPosition() {
        CommonEvents.isVisible(savePositionButton);
    }

    public String getTitle() {
        return addPositionTitle.getText();
    }

    public void clickSavePosition(){
        CommonEvents.clickButton(savePositionButton);
    }
}

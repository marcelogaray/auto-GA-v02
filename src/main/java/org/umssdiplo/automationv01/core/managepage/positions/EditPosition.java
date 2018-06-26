
package org.umssdiplo.automationv01.core.managepage.positions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EditPosition extends BasePage {
    @FindBy(id = "goback-update-position-button")
    private WebElement backUpdatePositionButton;

    @FindBy(id = "save-update-position-button")
    private WebElement saveUpdatePositionButton;

    @FindBy(id = "save-update-position-title")
    private WebElement saveUpdatePositionTitle;

    public EditPosition() {

        CommonEvents.isVisible(backUpdatePositionButton);
    }

    public String getTitle() {

        return saveUpdatePositionTitle.getText();
    }

    public String getSaveButtonName() {
        return saveUpdatePositionButton.getText();
    }


}

package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AddStorage extends BasePage {
    @FindBy(id = "inputNameStorage")
    private WebElement inputNameStorage;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public AddStorage() {
        CommonEvents.isVisible(inputNameStorage);
    }

    public void inputNameStorage() {
        CommonEvents.setInputField(inputNameStorage, "Name Storage");
    }

    public void clickSave() {
        CommonEvents.clickButton(saveButton);
    }
}

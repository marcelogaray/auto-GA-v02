package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EditStorage extends BasePage {
    @FindBy(id = "editNameStorage")
    private WebElement editNameStorage;

    @FindBy(id = "editSaveButton")
    private WebElement editSaveButton;

    public EditStorage() {
        CommonEvents.isVisible(editSaveButton);
    }

    public void inputNewNameStorage() {
        CommonEvents.setInputField(editNameStorage, "New Name Storage");
    }

    public void clickSave() {
        CommonEvents.clickButton(editSaveButton);
    }
}

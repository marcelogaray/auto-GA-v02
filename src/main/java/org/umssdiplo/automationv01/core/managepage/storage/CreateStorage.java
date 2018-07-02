package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.Map;

public class CreateStorage extends BasePage {
    @FindBy(id = "inputNameStorage")
    private WebElement name;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(id = "cancelButton")
    private WebElement cancelButton;

    public CreateStorage() {
        CommonEvents.isVisible(saveButton);
    }

    public void setName(String value) {
        CommonEvents.setInputField(name, value);
    }

    public Storage clickSaveButton() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(saveButton);
        return new Storage();
    }

    public Storage createStorage(Map<String, String> data) {
        CommonEvents.customWait(3000);
        setName(data.get("name"));
        clickSaveButton();
        return new Storage();
    }

    public void clickCancelButton() {
        CommonEvents.clickButton(cancelButton);
    }

    public boolean isSaveButtonEnabled() {
        return CommonEvents.isPresent(saveButton);
    }
}

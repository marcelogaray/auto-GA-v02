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

    public CreateStorage() {
        CommonEvents.isVisible(saveButton);
    }

    public void setName(String value) {
        CommonEvents.setInputField(name, value);
    }

    public Storage clickSaveButton() {
        CommonEvents.clickButton(saveButton);
        return new Storage();
    }

    public Storage createStorage(Map<String, String> data) {
        setName(data.get("name"));
        clickSaveButton();
        return new Storage();
    }
}

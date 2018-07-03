package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.accident.Accident;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.Map;

public class EditStorage extends BasePage {

    @FindBy(id = "editSaveButton")
    private WebElement editSaveButton;

    @FindBy(id = "editNameStorage")
    private WebElement editNameStorage;

    public Storage clickEditButton() {
        CommonEvents.clickButton(editSaveButton);
        return new Storage();
    }

    public void setName(String value) {
        CommonEvents.setInputField(editNameStorage, value);
    }

    public Storage editStorage(Map<String, String> data) {
        setName(data.get("name"));
        clickEditButton();
        return new Storage();
    }
}

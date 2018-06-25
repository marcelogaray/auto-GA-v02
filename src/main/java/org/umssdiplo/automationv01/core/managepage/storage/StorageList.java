package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class StorageList extends BasePage {
    @FindBy(id = "addStorageButton")
    private WebElement addStorageButton;

    public StorageList() {
        CommonEvents.isVisible(addStorageButton);
    }

    public AddStorage clickAddStorage() {
        CommonEvents.clickButton(addStorageButton);
        return new AddStorage();
    }

    public boolean isStorageVisible() {
        return addStorageButton.isDisplayed();
    }
}

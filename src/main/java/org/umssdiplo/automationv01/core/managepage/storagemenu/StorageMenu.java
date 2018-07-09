package org.umssdiplo.automationv01.core.managepage.storagemenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.storage.CreateStorage;
import org.umssdiplo.automationv01.core.managepage.storage.Storage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class StorageMenu extends BasePage{
    @FindBy(id = "addStorageButton")
    private WebElement addStorageButton;

    public StorageMenu() {
        CommonEvents.isVisible(addStorageButton);
    }

    public CreateStorage clickCreateStorage() {
        CommonEvents.customWait(2500);
        CommonEvents.clickButton(addStorageButton);
        return new CreateStorage();
    }
}

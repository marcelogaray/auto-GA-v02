package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ListItems extends BasePage {
    @FindBy(id = "backStorageButton")
    private WebElement backStorageButton;

    public ListItems() {
        CommonEvents.isVisible(backStorageButton);
    }

    public boolean assetsDisplayed(){
        return CommonEvents.isVisible(backStorageButton);
    }
}

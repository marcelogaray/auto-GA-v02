package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ListAssets extends BasePage {
    @FindBy(id = "backStorageButton")
    private WebElement listStorageButton;

    public ListAssets() {
        CommonEvents.isVisible(listStorageButton);
    }

    public boolean assetsDisplayed(){
        return CommonEvents.isVisible(listStorageButton);
    }
}

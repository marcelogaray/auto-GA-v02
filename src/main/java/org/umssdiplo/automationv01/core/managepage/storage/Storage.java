package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Storage extends BasePage {
    private static final String NAME_COLUMN_CLASS = "name-column";

    @FindBy(id = "addStorageButton")
    private WebElement addStorageButton;

    @FindBy(css = ".mat-row ng-star-inserted")
    private List<WebElement> storages;

    @FindBy(id = "storage-list-title")
    private WebElement storageListTitle;

    public Storage() {
        CommonEvents.isVisible(addStorageButton);
    }

    public CreateStorage createStorage() {
        CommonEvents.clickButton(addStorageButton);
        return new CreateStorage();
    }

    public int countStorages() {
        CommonEvents.customWait(5000);
        return CommonEvents.countElement(storages);
    }

    public String getName(int position) {
        WebElement nameColumn = CommonEvents.getWebElementByClassName(storages.get(position), NAME_COLUMN_CLASS);
        return CommonEvents.getTextContent(nameColumn);
    }

    public String getTitle() {
        System.out.println(storageListTitle.getText());
        return storageListTitle.getText();
    }
}

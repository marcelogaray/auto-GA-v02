package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage extends BasePage {
    private static final String NAME_COLUMN_CLASS = "name-column";
    private static final String DELETE_BUTTON_CLASS = "delete-storage-button";
    private static final String EDIT_BUTTON_CLASS = "edit-storage-button";

    @FindBy(id = "addStorageButton")
    private WebElement addStorageButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> storages;

    @FindBy(id = "storage-list-title")
    private WebElement storageListTitle;

    public Storage() {
        CommonEvents.isVisible(addStorageButton);
    }

    public CreateStorage createStorage() {
        CommonEvents.customWait(3000);
        CommonEvents.clickButton(addStorageButton);
        return new CreateStorage();
    }

    public int countStorages() {
        CommonEvents.customWait(3000);
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

    public void deleteStorage(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(storages.get(position), DELETE_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
    }

    public EditStorage editStorage(int position) {
        CommonEvents.customWait(3000);
        WebElement webElement = CommonEvents.getWebElementByClassName(storages.get(position), EDIT_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
        return new EditStorage();
    }

    public String getNameColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(storages.get(position), NAME_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public Map<String, String> getStorage(int position) {
        Map<String, String> storageMap = new HashMap<String, String>();
        storageMap.put("name", getNameColumnAt(position));
        return storageMap;
    }
}

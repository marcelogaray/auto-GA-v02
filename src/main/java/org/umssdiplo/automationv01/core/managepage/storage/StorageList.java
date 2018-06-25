package org.umssdiplo.automationv01.core.managepage.storage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class StorageList extends BasePage {
    @FindBy(id = "addStorageButton")
    private WebElement addStorageButton;

    @FindBy(id = "editStorage")
    private WebElement editStorageButton;

    @FindBy(id = "deleteStorageButton")
    private WebElement deleteStorageButton;

    @FindBy(xpath = "//*[contains(text(),'Name Storage')]")
    private WebElement storageNew;

    @FindBy(xpath = "//*[contains(text(),'Name Name Storage')]")
    private WebElement storageNewName;

    @FindBy(xpath = "//*[contains(text(),'Name Storage')]")
    private WebElement deleteStorage;

    public StorageList() {
        CommonEvents.isVisible(addStorageButton);
    }

    public AddStorage clickAddStorage() {
        CommonEvents.clickButton(addStorageButton);
        return new AddStorage();
    }

    public boolean isStorageVisible() {
        return storageNew.isDisplayed();
    }

    public EditStorage clickEditStorage() {
        CommonEvents.clickButton(editStorageButton);
        return new EditStorage();
    }

    public boolean isEditStorageVisible() {
        return editStorageButton.isDisplayed();
    }

    public boolean isNewNameStorageVisible() {
        return storageNewName.isDisplayed();
    }

    public boolean isNotExist() {
        return deleteStorage.isDisplayed();
    }

    public DeleteStorage clickDeleteStorage() {
        CommonEvents.clickButton(deleteStorageButton);
        return new DeleteStorage();
    }
}

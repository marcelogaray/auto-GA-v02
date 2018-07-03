package org.umssdiplo.automationv01.core.managepage.addItemType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.listItemType.ListItemType;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class AddItemType extends BasePage {
    private final String CANCEL_BTN_XPATH = "//mat-card/form/mat-card-actions/button[2]";

    @FindBy(id = "save-item-type-button")
    private WebElement saveBtn;

    @FindBy(xpath = "//mat-card/form/mat-card-actions/button[2]")
    private WebElement cancelBtn;

    @FindBy(name = "itemTypeName")
    private WebElement itemTypeName;

    public AddItemType() {
        CommonEvents.waitUntilByXPath(CANCEL_BTN_XPATH);
    }

    public String getSaveBtnStatus() {
        String isBtnEnabledDescr = getBtnStatusDesct(getBtnStatus(this.saveBtn));
        return isBtnEnabledDescr;
    }

    private String getBtnStatusDesct(boolean isEnabled) {
        String statusDescr = "";

        if (isEnabled) {
            statusDescr = "enabled";
        }
        else {
            statusDescr = "disabled";
        }

        return statusDescr;
    }

    private boolean getBtnStatus(WebElement btn) {
        return btn.isEnabled();
    }
    public void enterNewItemTypeName(String newName) {
        CommonEvents.setInputField(itemTypeName, newName);
    }

    public ListItemType clickSaveNewItemTypeBtn() {
        CommonEvents.clickButton(saveBtn);
        return new ListItemType();
    }
}

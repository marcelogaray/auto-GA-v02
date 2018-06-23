package org.umssdiplo.automationv01.core.managepage.editItemType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.listItemType.ListItemType;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EditItemType extends BasePage {

    @FindBy(name = "itemTypeName")
    private WebElement itemTypeNameText;

    @FindBy(id = "save-item-type-button")
    private WebElement saveItemTypeBtn;

    public EditItemType() {
        CommonEvents.waitUntilByXPath("//mat-card/form/mat-card-actions/button[2]");
    }

    public void enterNewItemTypeName(String newName) {
        CommonEvents.setInputField(itemTypeNameText, newName);
    }

    public ListItemType clickSaveItemTypeBtn() {
        CommonEvents.clickButton(saveItemTypeBtn);
        return new ListItemType();
    }
}

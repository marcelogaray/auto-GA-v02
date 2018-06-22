package org.umssdiplo.automationv01.core.managepage.editItemTypePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.listaTipoItemPage.ListItemTypePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class EditItemTypePage extends BasePage {

    @FindBy(name = "itemTypeName")
    private WebElement itemTypeNameText;

    @FindBy(id = "save-item-type-button")
    private WebElement saveItemTypeBtn;

    public void enterNewItemTypeName(String newName) {
        CommonEvents.setInputField(itemTypeNameText, newName);
    }

    public ListItemTypePage clickOnSaveItemTypeBtn() {
        CommonEvents.clickButton(saveItemTypeBtn);
        return new ListItemTypePage();
    }
}

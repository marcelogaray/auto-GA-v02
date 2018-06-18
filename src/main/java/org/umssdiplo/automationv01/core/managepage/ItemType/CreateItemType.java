package org.umssdiplo.automationv01.core.managepage.ItemType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreateItemType extends BasePage {
    @FindBy(id = "menu-active")
    private WebElement activeMenu;

    @FindBy(id = "sub-menu-register-item-type")
    private WebElement registerItemTypeMenu;

    @FindBy(name = "itemTypeName")
    private WebElement itemTypeField;

    @FindBy(id = "save-item-type-button")
    private WebElement saveItemTypeButton;

    public void clickOnActiveMenuOption(){

        CommonEvents.clickButton(activeMenu);
    }

    public void clickOnItemTypeMenuOption(){

        CommonEvents.clickButton(registerItemTypeMenu);
    }

    public void typeOnActiveMenuOption(){

        CommonEvents.setInputField(itemTypeField, "Seguridad de manos");

    }

    public void clickOnSaveButton(){

        CommonEvents.clickButton(saveItemTypeButton);
    }


}

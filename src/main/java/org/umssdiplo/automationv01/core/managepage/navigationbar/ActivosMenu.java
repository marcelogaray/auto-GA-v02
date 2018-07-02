package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.addItem.AddItem;
import org.umssdiplo.automationv01.core.managepage.addItemType.AddItemType;
import org.umssdiplo.automationv01.core.managepage.listItemType.ListItemType;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ActivosMenu extends BasePage {

    @FindBy(id = "sub-menu-list-item-type")
    private WebElement listItemTypeSubMenu;

    @FindBy(id = "sub-menu-list-item")
    private WebElement itemListSubMenu;

    @FindBy(id = "sub-menu-register-item-type")
    private WebElement addItemTypeSubMenu;

    @FindBy(id = "sub-menu-add-item")
    private WebElement addItemSubMenu;

    public ActivosMenu() {
        CommonEvents.customWait(1000);
        CommonEvents.waitUntilById("sub-menu-list-item");
    }

    public ListItemType clickItemTypeListSubMenu() {
        CommonEvents.clickButton(listItemTypeSubMenu);
        return new ListItemType();
    }

    public AddItemType clickAnadirTypeSubmenu() {
        CommonEvents.clickButton(addItemTypeSubMenu);
        return new AddItemType();
    }

    public AddItem clickAnadirItemSubmenu() {
        CommonEvents.clickButton(addItemSubMenu);
        return new AddItem();
    }
}

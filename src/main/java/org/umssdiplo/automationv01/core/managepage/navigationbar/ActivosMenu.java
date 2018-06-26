package org.umssdiplo.automationv01.core.managepage.navigationbar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
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

    public ActivosMenu() {
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
}

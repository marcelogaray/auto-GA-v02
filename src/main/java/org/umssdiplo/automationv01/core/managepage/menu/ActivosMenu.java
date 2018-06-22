package org.umssdiplo.automationv01.core.managepage.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.listaTipoItemPage.ListItemTypePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ActivosMenu extends BasePage {

    @FindBy(id = "sub-menu-list-item-type")
    private WebElement listItemTypeSubMenu;

    @FindBy(id = "sub-menu-list-item")
    private WebElement itemListSubMenu;

    public ActivosMenu() {
        CommonEvents.isPresent(itemListSubMenu);
    }

    public ListItemTypePage clickOnItemTypeListSubMenu() {
        CommonEvents.clickButton(listItemTypeSubMenu);
        return new ListItemTypePage();
    }
}

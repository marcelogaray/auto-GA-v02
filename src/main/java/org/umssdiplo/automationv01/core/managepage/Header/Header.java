package org.umssdiplo.automationv01.core.managepage.Header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Header extends BasePage {
    @FindBy(id = "menu-active")
    private WebElement activeMenu;

    @FindBy(id = "sub-menu-register-item-type")
    private WebElement registerItemTypeMenu;

    public void clickOnActiveMenuOption(){

        CommonEvents.clickButton(activeMenu);
    }

    public void clickOnAddItemTypeMenuOption(){

        CommonEvents.clickButton(registerItemTypeMenu);
    }

}

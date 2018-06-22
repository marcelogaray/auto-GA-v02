package org.umssdiplo.automationv01.core.managepage.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class MainMenu extends BasePage {

    private ActivosMenu activosMenuOption;

    @FindBy(id = "menu-active")
    private WebElement activosMenu;

    public MainMenu() {
        activosMenuOption = new ActivosMenu();
    }

    public ActivosMenu getActivosMenu() {
        return this.activosMenuOption;
    }

    public ActivosMenu clickOnActivosMenu() {
        CommonEvents.clickButton(activosMenu);
        CommonEvents.customWait(1000);
        return activosMenuOption;
    }
}

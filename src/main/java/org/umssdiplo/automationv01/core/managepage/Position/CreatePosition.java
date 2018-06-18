package org.umssdiplo.automationv01.core.managepage.Position;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreatePosition extends BasePage {
    @FindBy(id = "menu-organizational")
    private WebElement oraganizationlMenu;

    @FindBy(id = "sub-menu-list-position")
    private WebElement listPositionOption;

    @FindBy(id = "add-position")
    private WebElement addPositionButton;

    @FindBy(id = "save-position")
    private WebElement savePositionButton;

    @FindBy(id = "register-position-title")
    private WebElement registerPositionTitle;

    public void clickOnOrganizationalMenuOption(){
        CommonEvents.clickButton(oraganizationlMenu);
    }

    public void clickOnListPositionOption(){
        CommonEvents.clickButton(listPositionOption);
    }

    public void clickOnAddNewPosition(){
        CommonEvents.clickButton(addPositionButton);
    }

    public void clickOnSavePosition(){
        CommonEvents.clickButton(savePositionButton);
    }

    public String getTitleText(){
        return registerPositionTitle.getText();
    }
}

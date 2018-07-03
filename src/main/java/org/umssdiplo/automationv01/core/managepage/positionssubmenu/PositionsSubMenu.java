package org.umssdiplo.automationv01.core.managepage.positionssubmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.positions.EditPosition;
import org.umssdiplo.automationv01.core.managepage.positions.RegisterPosition;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class PositionsSubMenu extends BasePage {

    private static final String DELETE_BUTTON_CLASS = "delete-position-button";

    private static final String UPDATE_BUTTON_CLASS = "update-position-button";

    @FindBy(id = "add-position")
    private WebElement addPositionButton;

    @FindBy(id = "edit-position")
    private WebElement editPositionButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> positions;

    @FindBy(id = "list-position-title")
    private WebElement listPositionTitle;

    public PositionsSubMenu() {
        CommonEvents.isVisible(addPositionButton);
    }

    public RegisterPosition clickAddPosition() {
        CommonEvents.clickButton(addPositionButton);
        return new RegisterPosition();
    }

    public int countPositions() {
        CommonEvents.customWait(3000);
        return CommonEvents.countElement(positions);
    }

    public void deletePosition(int element) {
        WebElement webElement = CommonEvents.getWebElementByClassName(positions.get(element), DELETE_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
    }

    public EditPosition editPosition(int element) {
        WebElement webElement = CommonEvents.getWebElementByClassName(positions.get(element), UPDATE_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
        return new EditPosition();
    }

    public String getTitle() {
        return listPositionTitle.getText();
    }
}

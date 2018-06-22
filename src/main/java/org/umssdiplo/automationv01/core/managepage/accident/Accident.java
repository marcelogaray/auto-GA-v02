package org.umssdiplo.automationv01.core.managepage.accident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Accident extends BasePage {
    @FindBy(id = "create-accident-button")
    private WebElement createAccidentButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> accidents;

    public Accident() {
        CommonEvents.isVisible(createAccidentButton);
    }

    public CreateAccident createAccident() {
        CommonEvents.clickButton(createAccidentButton);
        return new CreateAccident();
    }

    public int countAccidents() {
        return CommonEvents.countElement(accidents);
    }

    public String getDescription(int position) {
        return CommonEvents.getTextContent(accidents.get(position).findElement(By.cssSelector(".description-column")));
    }
}

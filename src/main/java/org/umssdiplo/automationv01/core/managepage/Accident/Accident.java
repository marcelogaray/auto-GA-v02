package org.umssdiplo.automationv01.core.managepage.Accident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import java.util.List;

public class Accident extends BasePage {

    @FindBy(id = "createAccident")
    private WebElement createAccidentButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> accidents;

    @FindBy(id = "accidentView")
    private WebElement accidentEIncidentButton;

    @FindBy(id = "accidentLink")
    private WebElement accidentLink;

    public void createAccident() {
        CommonEvents.clickButton(createAccidentButton);
    }

    public int countAccident() {
        return CommonEvents.countElement(accidents);
    }

    public void selectAccidentLink() {
        CommonEvents.clickButton(accidentEIncidentButton);
        CommonEvents.clickButton(accidentLink);
    }

    public void deleteAccident() {
        accidents.get(0).findElement(By.cssSelector(".deleteButton")).click();
    }
}

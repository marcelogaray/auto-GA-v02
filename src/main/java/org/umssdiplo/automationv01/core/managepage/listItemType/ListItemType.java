package org.umssdiplo.automationv01.core.managepage.listItemType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.editItemType.EditItemType;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class ListItemType extends BasePage {

    @FindBy(xpath = "/html/body/app-root/app-itemtype-list/div/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[2]/div/button")
    private WebElement firstItemTypeEditBtn;

    @FindBy(xpath = "/html/body/app-root/app-itemtype-list/div/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]")
    private WebElement firstItemTypeNameCell;

    @FindBy(css = "mat-row.ng-star-inserted")
    private List<WebElement> tableRows;

    public EditItemType clickOnFirstRowEditBtn() {
        CommonEvents.clickButton(firstItemTypeEditBtn);
        return new EditItemType();
    }

    public void checkFirstItemTypeName(String expectedName) {
        String actualName = tableRows.get(0).findElement(By.cssSelector("mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
        Assert.assertEquals(actualName, expectedName);
    }
}

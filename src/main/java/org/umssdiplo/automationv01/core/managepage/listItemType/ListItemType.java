package org.umssdiplo.automationv01.core.managepage.listItemType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.editItemType.EditItemType;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class ListItemType extends BasePage {

    @FindBy(xpath = "//mat-table/mat-row[1]/mat-cell[2]/div/button")
    private WebElement firstItemTypeEditBtn;

    @FindBy(xpath = "//mat-table/mat-row[1]/mat-cell[1]")
    private WebElement firstItemTypeNameCell;

    @FindBy(css = "mat-row.ng-star-inserted")
    private List<WebElement> tableRows;

    /**
     * Waits until button at the botton of the page is loaded
     */
    public ListItemType() {
        CommonEvents.waitUntilByXPath("//mat-card/mat-card-actions/button");
    }

    public EditItemType clickFirstRowEditBtn() {
        CommonEvents.clickButton(firstItemTypeEditBtn);
        return new EditItemType();
    }

    public String getItemTypeNameInTableRow(int index) {
        WebElement firstRow = tableRows.get(index);
        WebElement itemTypeNameCell = CommonEvents.getWebElementInTableRowByCssSelector(firstRow, "mat-cell.cdk-column-name.mat-column-name.ng-star-inserted");
        String itemTypeName = itemTypeNameCell.getText();
        return itemTypeName;
    }

    public EditItemType clickEditBtnInRow(int index) {
        WebElement firstRow = tableRows.get(index);
        WebElement editBtn = CommonEvents.getWebElementInTableRowByXPath(firstRow, String.format("//mat-table/mat-row[%d]/mat-cell[2]/div/button", index + 1));
        CommonEvents.clickButton(editBtn);
        return new EditItemType();
    }
}

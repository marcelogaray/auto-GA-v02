package org.umssdiplo.automationv01.core.managepage.listItemType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.editItemType.EditItemType;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class ListItemType extends BasePage {
    private final String ITEM_TYPE_NAME_CELL_CSS_SELECTOR = "mat-cell.cdk-column-name.mat-column-name.ng-star-inserted";
    private final String EDIT_BTN_XPATH = "//mat-table/mat-row[%d]/mat-cell[2]/div/button";
    private final String DELETE_BTN_XPATH = "//mat-table/mat-row[%d]/mat-cell[2]/div/span/button";

    @FindBy(xpath = "//mat-table/mat-row[1]/mat-cell[2]/div/button")
    private WebElement firstItemTypeEditBtn;

    @FindBy(xpath = "//mat-table/mat-row[1]/mat-cell[1]")
    private WebElement firstItemTypeNameCell;

    @FindBy(css = "mat-row.ng-star-inserted")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//mat-card/mat-card-actions/button")
    private WebElement addItemTypeBtn;

    @FindBy(xpath = "//mat-card/mat-card-title")
    private WebElement pageTitle;

    /**
     * Waits until button at the botton of the page is loaded
     */
    public ListItemType() {
        CommonEvents.waitUntilByXPath("//mat-card/mat-card-actions/button");
        CommonEvents.customWait(1000);
    }

    public EditItemType clickFirstRowEditBtn() {
        CommonEvents.clickButton(firstItemTypeEditBtn);
        return new EditItemType();
    }

    public String getItemTypeNameInTableRow(int index) {
        String itemTypeName = getItemTypeNameText(index);
        return itemTypeName;
    }

    public EditItemType clickEditBtnInRow(int index) {
        WebElement editBtn = getBtnByIndexAndXPath(index, EDIT_BTN_XPATH);
        CommonEvents.clickButton(editBtn);
        return new EditItemType();
    }

    public EditItemType clickAddItemTypeBtn() {
        CommonEvents.clickButton(addItemTypeBtn);
        return new EditItemType();
    }

    public boolean existItemTypeByName(String name) {
        int indexOfName = getIndexOfItemTypeName(name);

        return indexOfName > -1;
    }

    private String getItemTypeNameText(int index) {
        WebElement row = tableRows.get(index);
        WebElement itemTypeNameCell = CommonEvents.getWebElementInTableRowByCssSelector(row, ITEM_TYPE_NAME_CELL_CSS_SELECTOR);
        return itemTypeNameCell.getText();
    }

    public ListItemType clickDeleteBtnByItemTypeName(String name) {
        int index = getIndexOfItemTypeName(name);
        WebElement deleteBtn = getBtnByIndexAndXPath(index, DELETE_BTN_XPATH);
        CommonEvents.clickButton(deleteBtn);
        return new ListItemType();
    }

    private int getIndexOfItemTypeName(String name) {
        int index = -1;
        int counter = 0;
        boolean found = false;

        while(!found && counter < tableRows.size()) {
            String itemTypeName = getItemTypeNameText(counter);

            if (name.compareTo(itemTypeName) == 0) {
                found = true;
                index = counter;
            }

            counter++;
        }

        return index;
    }

    private WebElement getBtnByIndexAndXPath(int index, String xPath) {
        WebElement row = tableRows.get(index);
        return CommonEvents.getWebElementInTableRowByXPath(row, String.format(xPath, index + 1));
    }

    public String getPageTitle() {
        String title = pageTitle.getText();

        return title;
    }

    public EditItemType clickEditBtnByItemTypeName(String name) {
        int index = getIndexOfItemTypeName(name);
        WebElement editBtn = getBtnByIndexAndXPath(index, EDIT_BTN_XPATH);
        CommonEvents.clickButton(editBtn);
        return new EditItemType();
    }
}

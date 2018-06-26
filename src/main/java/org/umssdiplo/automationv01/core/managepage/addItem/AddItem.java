package org.umssdiplo.automationv01.core.managepage.addItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class AddItem extends BasePage {

    private final String CANCEL_BTN_XPATH = "//mat-card/mat-card-actions/button[2]";

    @FindBy(xpath = "//mat-card/mat-card-actions/button[2]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/div/div")
    private WebElement itemTypeDropdown;

    @FindBy(css = "mat-card-title.mat-card-title")
    private WebElement pageTitle;

    public AddItem() {
        CommonEvents.waitUntilByXPath(CANCEL_BTN_XPATH);
    }

    private List<WebElement> getItemTypeOptions(WebElement dropdown) {
        List<WebElement> itemTypeOptions = dropdown.findElements(By.cssSelector("mat-option-text"));
        return itemTypeOptions;
    }
/*
    public boolean isItemTypeInDropdown(String expectedItemType) {
        List<WebElement> itemTypeOptions = getItemTypeOptions(itemTypeDropdown);
        int index = getOptionIndex(itemTypeOptions, expectedItemType);

        return index > -1;
    }
*/
    private int getOptionIndex(List<WebElement> list, String option) {
        boolean found = false;
        int counter = 0;
        int index = -1;

        while (!found && counter < list.size()) {
            if (option.compareTo(list.get(counter).getText()) == 0) {
                index = counter;
                found = true;
            }
            counter++;
        }

        return index;
    }

    public String getPageMainTitle() {
        return this.pageTitle.getText();
    }
}

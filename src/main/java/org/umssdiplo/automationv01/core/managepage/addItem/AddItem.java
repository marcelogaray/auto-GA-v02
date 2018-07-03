package org.umssdiplo.automationv01.core.managepage.addItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class AddItem extends BasePage {

    private final String CANCEL_BTN_XPATH = "//mat-card/mat-card-actions/button[2]";
    private final String SAVE_BTN_XPATH = "//mat-card/mat-card-actions/button[1]";

    @FindBy(xpath = "//mat-card/mat-card-actions/button[2]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/div/div")
    private WebElement itemTypeDropdown;

    @FindBy(css = "mat-card-title.mat-card-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//mat-card/mat-card-actions/button[1]")
    private WebElement saveBtn;

    public AddItem() {
        CommonEvents.waitUntilByXPath(CANCEL_BTN_XPATH);
    }

    private List<WebElement> getItemTypeOptions(WebElement dropdown) {
        List<WebElement> itemTypeOptions = dropdown.findElements(By.cssSelector("mat-option-text"));
        return itemTypeOptions;
    }

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

    public String getSaveBtnStatus() {
        String isBtnEnabledDescr = getBtnStatusDescr(getBtnStatus(this.saveBtn));
        return isBtnEnabledDescr;
    }

    private String getBtnStatusDescr(boolean isEnabled) {
        String statusDescr = "";

        if (isEnabled) {
            statusDescr = "enabled";
        } else {
            statusDescr = "disabled";
        }

        return statusDescr;
    }

    private boolean getBtnStatus(WebElement btn) {
        return btn.isEnabled();
    }
}

package org.umssdiplo.automationv01.core.managepage.contingencyplan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContingencyPlan extends BasePage {
    private static final String ACCIDENT_COLUMN_CLASS = "accident-description-column";
    private static final String STANDARD_NAME_COLUMN_CLASS = "standar-name-column";
    private static final String MATERIAL_COLUMN_CLASS = "safety-material-column";
    private static final String PENALTIES_COLUMN_CLASS = "penalties-column";
    private static final String DESCRIPTION_COLUMN_CLASS = "description-column";
    private static final String DATE_COLUMN_CLASS = "date-column";
    private static final String DELETE_BUTTON_CLASS = "delete-contingency-button";
    private static final String EDIT_BUTTON_CLASS = "edit-contingency-button";

    @FindBy(id = "create-contingency-button")
    private WebElement createContingencyButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> contingencyList;

    @FindBy(id = "search-contingency-menu")
    private WebElement searchContingencyMenu;

    @FindBy(id = "search-input")
    private WebElement searcContingencyInput;

    @FindBy(id = "search-contingency-button")
    private WebElement searchContingencyButton;

    public ContingencyPlan() {
        CommonEvents.isVisible(createContingencyButton);
    }

    public CreateContingencyPlan clickCreateContingencyPlanButton() {
        CommonEvents.clickButton(createContingencyButton);
        return new CreateContingencyPlan();
    }

    public int countContingencies() {
        return CommonEvents.countElement(contingencyList);
    }

    public String getAccidentColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), ACCIDENT_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getStandartNameColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), STANDARD_NAME_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getMaterialColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), MATERIAL_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getPenaltiesColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), PENALTIES_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getDescriptionColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), DESCRIPTION_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getDateColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), DATE_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public Map<String, String> getContingencyPlan(int position) {
        Map<String, String> contingencyMap = new HashMap<String, String>();
        contingencyMap.put("accident", getAccidentColumnAt(position));
        contingencyMap.put("standardName", getStandartNameColumnAt(position));
        contingencyMap.put("material", getMaterialColumnAt(position));
        contingencyMap.put("penalties", getPenaltiesColumnAt(position));
        contingencyMap.put("description", getDescriptionColumnAt(position));
        return contingencyMap;
    }

    public EditContingencyPlan editContingencyPlan(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(contingencyList.get(position), EDIT_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
        return new EditContingencyPlan();
    }

    public void selectSearchContingencyOption(String option) {
        CommonEvents.selectElementByText(searchContingencyMenu, option);
    }

    public void setSearchContingencyInput(String textValue) {
        CommonEvents.setInputField(searcContingencyInput, textValue);
    }

    public void clickSearchContingencyButton() {
        CommonEvents.clickButton(searchContingencyButton);
    }

    public boolean isPenaltyColumnsMatchWithFilter(String penalties) {
        CommonEvents.customWait(3000);
        boolean penaltiesFilter = true;
        int totalContingencyPlans = countContingencies();
        for (int i = 0; i < totalContingencyPlans; i++) {
            if (getPenaltiesColumnAt(i).indexOf(penalties) != 0) {
                penaltiesFilter = false;
                break;
            }
        }
        return penaltiesFilter;
    }

    public boolean isStandardNameShowOnList(String standardName) {
        CommonEvents.customWait(3000);
        boolean isStandardNameDisplayed = true;
        int totalContingencies = countContingencies();
        for (int i = 0; i < totalContingencies; ++i) {
            if (getStandartNameColumnAt(i).indexOf(standardName) != 0) {
                isStandardNameDisplayed = false;
                break;
            }
        }
        return isStandardNameDisplayed;
    }

    public WebElement getRowByStandardName(String standardName) {
        int totalRows = countContingencies();
        WebElement element = null;
        for (int i = 0; i < totalRows; ++i) {
            if (getStandartNameColumnAt(i).equals(standardName)) {
                element = contingencyList.get(i);
                break;
            }
        }
        return element;
    }

    public void deleteContingencyPlan(String standardName) {
        WebElement webElement = CommonEvents.getWebElementByClassName(getRowByStandardName(standardName), DELETE_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
    }
}

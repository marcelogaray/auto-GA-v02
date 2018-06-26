package org.umssdiplo.automationv01.core.managepage.accident;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accident extends BasePage {
    private static final String DESCRIPTION_COLUMN_CLASS = "description-column";
    private static final String SEVERITY_COLUMN_CLASS = "severity-column";
    private static final String EMPLOYEE_COLUMN_CLASS = "employee-column";
    private static final String DEPARTMENT_COLUMN_CLASS = "department-column";
    private static final String STATE_COLUMN_CLASS = "state-column";
    private static final String SENORITY_COLUMN_CLASS = "seniority-column";
    private static final String MATERIAL_COLUMN_CLASS = "material-column";
    private static final String DATE_COLUMN_CLASS = "date-column";
    private static final String OTHER_EMPLOYEE_COLUMN_CLASS = "involved-column";
    private static final String DELETE_BUTTON_CLASS = "delete-accident-button";
    private static final String EDIT_BUTTON_CLASS = "edit-accident-button";

    @FindBy(id = "create-accident-button")
    private WebElement createAccidentButton;

    @FindBy(css = ".mat-row.ng-star-inserted")
    private List<WebElement> accidents;

    @FindBy(id = "search-accident-menu")
    private WebElement searchAccidentOption;

    @FindBy(id = "search-accident-input")
    private WebElement searchAccidentInput;

    @FindBy(id = "search-accident-button")
    private WebElement searchButton;

    public Accident() {
        CommonEvents.isVisible(createAccidentButton);
    }

    public CreateAccident createAccident() {
        CommonEvents.clickButton(createAccidentButton);
        return new CreateAccident();
    }

    public int countAccidents() {
        CommonEvents.customWait(1000);
        return CommonEvents.countElement(accidents);
    }

    public String getDescription(int position) {
        WebElement descriptionColumn = CommonEvents.getWebElementByClassName(accidents.get(position), DESCRIPTION_COLUMN_CLASS);
        return CommonEvents.getTextContent(descriptionColumn);
    }

    public void deleteAccident(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), DELETE_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
    }

    public ModificarAccident editAccident(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), EDIT_BUTTON_CLASS);
        CommonEvents.clickButton(webElement);
        return new ModificarAccident();
    }

    public String getEmployeeNameColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), EMPLOYEE_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getDepartmentNameColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), DEPARTMENT_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getDescriptionColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), DESCRIPTION_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getSeverityColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), SEVERITY_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getStateColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), STATE_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getMaterialColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), MATERIAL_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getSenorityColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), SENORITY_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getDateColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), DATE_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public String getOtherEmployeeColumnAt(int position) {
        WebElement webElement = CommonEvents.getWebElementByClassName(accidents.get(position), OTHER_EMPLOYEE_COLUMN_CLASS);
        return CommonEvents.getTextContent(webElement);
    }

    public Map<String, String> getAccident(int position) {
        Map<String, String> accidentMap = new HashMap<String, String>();
        accidentMap.put("enployee", getEmployeeNameColumnAt(position));
        accidentMap.put("deparment", getDepartmentNameColumnAt(position));
        accidentMap.put("description", getDescriptionColumnAt(position));
        accidentMap.put("severity", getSeverityColumnAt(position));
        accidentMap.put("material", getMaterialColumnAt(position));
        accidentMap.put("state", getStateColumnAt(position));
        accidentMap.put("senority", getSenorityColumnAt(position));
        accidentMap.put("other", getOtherEmployeeColumnAt(position));
        accidentMap.put("date", getDateColumnAt(position));
        return accidentMap;
    }

    public void selectSearchOption(String option) {
        CommonEvents.selectElementByText(searchAccidentOption, option);
    }

    public void setSearchAccidentInput(String textValue) {
        CommonEvents.setInputField(searchAccidentInput, textValue);
    }

    public void clickSearchButton() {
        CommonEvents.clickButton(searchButton);
    }

    public boolean isSevetiryColumnMatchWithFilter(String severity) {
        CommonEvents.customWait(3000);
        boolean severityFilter = true;
        int totalAccidents = countAccidents();
        for (int i = 0; i < totalAccidents; ++i) {
            if (getSeverityColumnAt(i).equals(severity)) {
                severityFilter = true;
            } else {
                severityFilter = false;
            }
        }
        return severityFilter;
    }
}

package org.umssdiplo.automationv01.core.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

import java.util.List;

public class CommonEvents {

    /**
     * This method set text content to web element.
     *
     * @param webElement Is web element.
     * @param content    Is the content that will be set to the web element.
     */
    public static void setInputField(WebElement webElement, String content) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(content);
    }

    /**
     * This method perform a click action in a web element.
     *
     * @param webElement Is the web element that will be pressed.
     */
    public static void clickButton(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method perform a click in a non visible element in the UI.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public static void jsClickElement(WebElement webElement) {
        ((JavascriptExecutor) ManageDriver.getInstance().getWebDriver())
                .executeScript("arguments[0].click();", webElement);
    }

    /**
     * This method perform a scroll down until that an element is visible in the UI.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public static void jsScrollDown(WebElement webElement) {
        ((JavascriptExecutor) ManageDriver.getInstance().getWebDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    /**
     * This method verifies if a web element is visible.
     *
     * @param webElement is the web element.
     * @return true if web element is visible or false if it isn't visible.
     */
    public static boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element do not exits.");
            return false;
        }
    }

    /**
     * This method verifies if a web element is visible.
     *
     * @param webElement is the web element.
     * @return true if web element is visible or false if it isn't visible.
     */
    public static boolean isPresent(WebElement webElement) {
        try {
            return webElement.isEnabled();
        } catch (NoSuchElementException e) {
            System.out.println("Element do not exits.");
            return false;
        }
    }

    /**
     * This method perform a search in a WebElement list based on a content string parameter.
     *
     * @param elements is the WebElements lists.
     * @param content  is the content parameter.
     * @return the WebElement search result.
     */
    public static WebElement findWebElement(List<WebElement> elements, String content) {
        return elements.stream()
                .filter(element -> content.equals(element.getText()))
                .findAny()
                .orElse(null);
    }

    /**
     * This method return the text content of a WebElement.
     *
     * @param webElement is the WebElement to extract the text.
     * @return the text content of the WebElement.
     */
    public static String getTextContent(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method get title of current page.
     *
     * @return title of the current page.
     */
    public static String getPageTitle() {
        return ManageDriver.getInstance().getWebDriver().getTitle();
    }

    /**
     * This method press enter key to web element.
     *
     * @param webElement is the WebElement.
     */
    public static void pressEnterKey(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    public static void customWait(int forceWait) {
        try {
            Thread.sleep(forceWait);
        } catch (Exception e) {
            System.out.printf("" + e);
        }
    }

    /**
     * This method allow to put the mouse over a WebElement.
     *
     * @param webElement where the mouse will be moved.
     */
    public static void mouseOver(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        Actions action = new Actions(ManageDriver.getInstance().getWebDriver());
        action.moveToElement(webElement);
    }

    /**
     * This method allow to search  a WebElement from a Angular Matterial table.
     *
     *
     * @param table Angular Matterial table.
     * @param departmentName WebElement.
     * @return
     */
    public static WebElement findWebElementFromMatTable(WebElement table, String departmentName) {
        WebElement sCellValue = table.findElement(By.xpath("//mat-cell[contains(text(),'" + departmentName + "')]"));
        return sCellValue;
    }

    /**
     * This method return an Angular Matterial actionButton from a table that match with a WebElement in the row.
     *
     * @param table Angular Matterial table
     * @param departmentName WebElement in row
     * @param eliminar Angular Matterial actionButton.
     * @return
     */
    public static WebElement findButtonByCellofMatTable(WebElement table, String departmentName, String eliminar) {
        WebElement aButton = table.findElement(By.xpath("//mat-cell[not(contains(text(),'-')) and contains(text(),'" + departmentName + "')]/..//button//*[contains(text(),'" + eliminar + "')]"));
        return aButton;
    }

    /**
     * This method return an option from a angular matterial drop down.
     *
     * @param matSelect angular matheria  drop down.
     * @param option drop down option.
     * @return
     */
    public static WebElement selectMatOption(WebElement matSelect, String option) {
        CommonEvents.customWait(500);
        WebElement selected = matSelect.findElement(By.xpath("//mat-option//span[contains(text(),'" + option + "')]"));
        return selected;
    }

    /**
     * This method press escape  key in order to close WebElements open.
     */
    public static void escape() {
        CommonEvents.customWait(100);
        Actions action = new Actions(ManageDriver.getInstance().getWebDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    /**
     * This method allow to find a cell that contains a child object and parent object that match with the criteria.
     *
     * @param table list of WebElements
     * @param child child in the same  row
     * @param parent parent in the same  row
     * @return
     */
    public static WebElement findChildFromMatTable(WebElement table, String child, String parent) {
        WebElement cell = table.findElement(By.xpath("//mat-cell[contains(text(),'" + parent + "')]/..//mat-cell[contains(text(),'" + child + "')]"));
        return cell;
    }
    /**
     * This method count all element into the list.
     *
     * @param webElements Is the web element list.
     */
    public static int countElement(List<WebElement> webElements) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElements.get(0)));
        return webElements.size();
    }

    /**
     * This method select an element by value.
     *
     * @param webElement is the WebElement.
     * @param textvalue  is the value.
     */
    public static void selectElementByText(WebElement webElement, String textvalue) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        Select selectElement = new Select(webElement);
        selectElement.selectByVisibleText(textvalue);
    }

    public static WebElement getWebElementByClassName(WebElement element, String className) {
        return element.findElement(By.cssSelector("." + className));
    }

    /**
     * This method clear the set input field
     *
     * @param webElement Is web element.
     */
    public static void clearInputField(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }
}

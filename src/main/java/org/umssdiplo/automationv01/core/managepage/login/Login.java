package org.umssdiplo.automationv01.core.managepage.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.navigationbar.NavigationBar;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class Login extends BasePage {
    @FindBy(name = "username")
    private WebElement usernameInputField;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(css = ".mat-button.ng-star-inserted")
    private WebElement loginButton;

    @FindBy(css = ".background-primary.text-floral-white.mat-button")
    private WebElement acceptButton;

    public void enterUsernameFromSystem() {
        String username = PropertyAccessor.getInstance().getUser();
        CommonEvents.setInputField(usernameInputField, username);
    }

    public void enterPasswordFromSystem() {
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(passwordInputField, password);
    }

    public void clickAcceptButton() {
        CommonEvents.clickButton(acceptButton);
    }

    public NavigationBar setCredentials() {
        CommonEvents.clickButton(loginButton);
        CommonEvents.customWait(2000);
        enterUsernameFromSystem();
        enterPasswordFromSystem();
        clickAcceptButton();
        return new NavigationBar();
    }
}

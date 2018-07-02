package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.utils.RandomContractNameGenerator;

public class RegisterContract extends BasePage {

    @FindBy(id = "cname")
    private WebElement inputName;

    @FindBy(id = "cdesc")
    private WebElement InputDescription;

    @FindBy(id = "add-contract")
    private WebElement addContractButton;

    public void setInputName(){
        String input_name = RandomContractNameGenerator.getRandomContractName();
        inputName.sendKeys(input_name);
    }

    public void setInputDescription(){
        InputDescription.sendKeys("Some Description");
    }



    public boolean contractButtonIsEnabled(){
        return addContractButton.isEnabled();
    }
}

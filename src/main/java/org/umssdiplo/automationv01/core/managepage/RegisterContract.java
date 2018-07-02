package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class RegisterContract extends BasePage {

    @FindBy(id = "cname")
    private WebElement inputName;

    @FindBy(id = "cdesc")
    private WebElement inputDesc;

    @FindBy(id = "add-contract")
    private WebElement addContractBtn;

    public void setInputName(){
        inputName.sendKeys(getRandomContractName());
    }

    public void setInputDesc(){
        inputDesc.sendKeys("Some Description");
    }

    private String getRandomContractName() {
        String res = "Contrato-";
        res += ThreadLocalRandom.current().nextInt(1223, 10000);
        return res;
    }

    public boolean contractButtonIsEnabled(){
        return addContractBtn.isEnabled();
    }
}

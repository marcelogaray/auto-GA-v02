package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractRegister extends BasePage {

    String NAME = "Contrato-001555";
    String DESCRIPTION = "Validez del contrato de 1 año";

    @FindBy(id = "btn-registrar")
    private WebElement addContractBtn;

    @FindBy(id = "cname")
    private WebElement contractName;

    @FindBy(id = "cdesc")
    private WebElement contractDesc;


    public boolean contractButtonIsEnabled(){
        return addContractBtn.isEnabled();
    }

    public void fillForm(){
        contractName.sendKeys(NAME);
        contractDesc.sendKeys(DESCRIPTION);
    }
}

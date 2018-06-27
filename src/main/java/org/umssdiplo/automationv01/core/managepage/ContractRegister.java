package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ContractRegister extends BasePage {

    String NAME = "Contrato-001555";
    String DESCRIPTION = "Validez del contrato de 1 año";

    @FindBy(id = "btn-registrar")
    private WebElement addContractBtn;

    @FindBy(id = "cname")
    private WebElement contractName;

    @FindBy(id = "cdesc")
    private WebElement contractDesc;

    @FindBy(id = "sub-menu-contracts")
    private WebElement btnContracts;

    @FindBy(id = "dateini")
    private WebElement dateini;

    @FindBy(id = "datefin")
    private WebElement datefin;


    public boolean contractButtonIsEnabled(){
        return addContractBtn.isEnabled();
    }

    public void fillForm(){
        contractName.sendKeys(NAME);
        contractDesc.sendKeys(DESCRIPTION);
        //mat-option-0
        CommonEvents.setInputField(dateini, "2018-07-01");
        CommonEvents.setInputField(datefin, "2019-07-01");

    }

    public void clickContracts(){
        addContractBtn.click();
    }

    public void clickContractsMenu(){
        btnContracts.click();
    }

}

package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ContractRegister extends BasePage {

    String NAME = "Contrato-001002";
    String DESCRIPTION = "Validez del contrato de 1 año";
    String INI = "26/06/2018";
    String FIN = "26/06/2019";

    @FindBy(id = "btn-registrar")
    private WebElement addContractBtn;

    @FindBy(id = "cname")
    private WebElement contractName;

    @FindBy(id = "cdesc")
    private WebElement contractDesc;

    @FindBy(id = "dateini")
    private WebElement contractDateIni;

    @FindBy(id = "datefin")
    private WebElement contractDateFin;

    public void clickAddContractButton(){
        CommonEvents.clickButton(addContractBtn);
    }

    public void fillForm(){
        contractName.sendKeys(NAME);
        contractDesc.sendKeys(DESCRIPTION);
        contractDateIni.sendKeys(INI);
        contractDateFin.sendKeys(FIN);
    }
}

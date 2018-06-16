package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class CommonStepdef {
    @Given("^Tesitng path to generate filed$")
    public void tesitngPathToGenerateFiled() throws Throwable {
        System.out.println("=====================");
        System.out.println("new file generated");
        System.out.println("=====================");
    }
}

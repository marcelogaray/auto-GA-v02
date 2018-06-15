package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class GeneralSteps {
    @Given("^hasdfasdfundo$")
    public void holaMundo() throws Throwable {
        System.out.println("hello word!!!");
    }

    @Given("^first introduction to cucumber with java$")
    public void firstIntroductionToCucumberWithJava() throws Throwable {
        System.out.println("=====================");
        System.out.println("Testing cucumber java");
        System.out.println("=====================");
    }
}

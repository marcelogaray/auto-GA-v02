package org.umssdiplo.automationv01.testdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriverChrome {
    public static void main(String[] args) {
        WebDriver testdriverChrome = new ChromeDriver();
        testdriverChrome.get("https://mvnrepository.com/artifact/info.cukes/cucumber-java");
    }
}

package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.core.operations.Browser;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Browser browser;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        browser = new Browser(driver);
    }
}

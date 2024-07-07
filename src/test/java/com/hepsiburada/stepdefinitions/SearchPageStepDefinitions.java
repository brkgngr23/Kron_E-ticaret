package com.hepsiburada.stepdefinitions;


import com.hepsiburada.core.configurations.DriverFactory;
import com.hepsiburada.pageobjects.pages.SearchPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SearchPageStepDefinitions {

    private final SearchPage searchPage;


    public SearchPageStepDefinitions(DriverFactory driverFactory) {
        WebDriver driver = driverFactory.createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchPage = new SearchPage(driver);

    }


    @Then("I choose the product")
    public void urunSec() {
        searchPage.urunSec();
    }
}


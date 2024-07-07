package com.hepsiburada.stepdefinitions;

import com.hepsiburada.core.configurations.DriverFactory;
import com.hepsiburada.pageobjects.pages.MainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPageStepDefinitions {


    private final MainPage mainPage;

    public MainPageStepDefinitions(DriverFactory driverFactory) {
        WebDriver driver = driverFactory.createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);


    }


    @Given("Navigate to dashboard")
    public void navigatePage() {
        mainPage.navigate();
    }

    @Then("I search {string} product")
    public void searchProduct(String productName) {
        mainPage.searchProduct(productName);
    }


}


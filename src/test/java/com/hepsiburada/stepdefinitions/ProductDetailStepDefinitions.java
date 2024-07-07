package com.hepsiburada.stepdefinitions;

import com.hepsiburada.core.configurations.DriverFactory;
import com.hepsiburada.pageobjects.pages.ProductDetailPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductDetailStepDefinitions {

    private final ProductDetailPage productDetailPage;

    public ProductDetailStepDefinitions(DriverFactory driverFactory) {
        WebDriver driver = driverFactory.createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        productDetailPage = new ProductDetailPage(driver);
    }

    @When("I like the comment if has it")
    public void urunYorumuBegen() throws InterruptedException {
        productDetailPage.urunYorumuBegen();
    }

}

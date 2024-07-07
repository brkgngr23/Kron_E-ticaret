package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.core.utils.PropertyUtils;
import com.hepsiburada.pageobjects.locators.MainPageLocators;
import com.hepsiburada.pageobjects.locators.SearchPageLocators;
import org.openqa.selenium.WebDriver;
import com.hepsiburada.core.utils.log;


import java.util.Properties;

public class MainPage extends BasePage {

    private final Properties props = PropertyUtils.getInstance().loadPropertiesFile("auth.properties");
    private final String url = props.getProperty("url");

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage navigate() {
        driver.navigate().to(url);
        browser.isElementExist(MainPageLocators.loginButton);
        log.info("Anasayfa basarili sekilde acildi");
        return this;
    }

    public void searchProduct(String productName) {
        browser.clickByJSExecutor(MainPageLocators.searchInput);
        browser.sendKeys(MainPageLocators.searchInput2, productName);
        browser.click(MainPageLocators.searchButton);
        browser.isElementExist(SearchPageLocators.ilkUrun);
        log.info(productName + " urunu basariyla arandi");
    }

}

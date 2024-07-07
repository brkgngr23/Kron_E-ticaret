package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.pageobjects.locators.ProductDetailLocators;
import com.hepsiburada.pageobjects.locators.SearchPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import com.hepsiburada.core.utils.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public void urunSec() {
        browser.click(SearchPageLocators.ilkUrun);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        browser.isElementExist(ProductDetailLocators.sepeteEkle);
        log.info("Urun detay sayfasina gidildi");

    }

}
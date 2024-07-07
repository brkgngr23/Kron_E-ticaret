package com.hepsiburada.core.synchronizations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {

    private final WebDriverWait wait;

    public WaitFactory(WebDriver driver) {
        wait = new WebDriverWait(driver, 60);
    }

    public WebElement waitForPresenceOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementIsClickable(By locator) throws InterruptedException {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementIsTextTypable(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementContainsText(By locator, String partialText) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.textToBePresentInElement(element, partialText));
    }

    public Select waitForElementToBeSelectable(By locator) {
        WebElement element = waitForElementVisible(locator);
        Select select = new Select(element);
        wait.until(CustomExpectedConditions.optionsToBeSelectable(select));
        return select;
    }
}

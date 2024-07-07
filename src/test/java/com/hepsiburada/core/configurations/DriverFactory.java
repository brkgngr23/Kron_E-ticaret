package com.hepsiburada.core.configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(DriverFactory.class.getName());
    private final BrowserType selectedBrowser;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public DriverFactory() {
        BrowserType currentBrowser = BrowserType.CHROME;
        String browser = System.getProperty("browser", currentBrowser.toString()).toUpperCase();
        try {
            currentBrowser = BrowserType.valueOf(browser);
        } catch (IllegalArgumentException | NullPointerException ignored) {
            LOGGER.warn(String.format("Unknown driver specified, defaulting to '%s'...", currentBrowser));
        }
        selectedBrowser = currentBrowser;
    }

    public WebDriver createInstance() {
        instantiateWebDriver(selectedBrowser);
        return driver.get();
    }

    public WebDriver getWebDriver() {
        return driver.get();
    }

    public void quitWebDriver() {
        if (null != driver) {
            driver.get().quit();
            driver.remove();
        }
    }

    private void instantiateWebDriver(BrowserType selectedBrowser) {
        if (driver.get() == null) {
            WebDriver webDriver = selectedBrowser.createWebDriver();
            driver.set(webDriver);
        }
    }

}


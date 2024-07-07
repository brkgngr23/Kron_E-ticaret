package com.hepsiburada.core.configurations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.hepsiburada.core.utils.log;

public class Hooks {

    private final DriverFactory driverFactory;

    public Hooks(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Before()
    public void beforeScenario() {
        log.info("Driver hazırlanıyor..");
    }

    @After()
    public void afterScenario(Scenario scenario) {
        driverFactory.quitWebDriver();
        log.info(String.format("Scenario finished : %s", scenario.getName()));
    }
}

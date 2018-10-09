package com.test.cucumber.glue;

import com.test.webdriver.ActionsHelper;
import com.test.webdriver.WebDriverFactory;
import com.test.webdriver.WebDriverUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;

@ContextConfiguration(locations = "classpath:cucumber.xml")
public class RunLifeCycle {

    private Scenario scenario;

    @Autowired
    private WebDriverFactory driverFactory;

    @PostConstruct
    public WebDriver getDriver() {
        return driverFactory.getDriver();
    }


    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

}

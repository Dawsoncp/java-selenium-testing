package com.test.cucumber;

import com.test.webdriver.ActionsHelper;
import com.test.webdriver.WebDriverFactory;
import com.test.webdriver.WebDriverUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;

@ContextConfiguration(locations = "classpath:cucumber.xml")
@Component
public class RunLifeCycle {

    private Scenario scenario;

    @Autowired
    private WebDriverFactory webDriverFactory;
    @Autowired
    private WebDriverUtil webBot;

    private ActionsHelper actions;


//    private static final Logger LOGGER = LoggerFactory.getLogger(RunLifeCycle.class);


    @Before
//    @PostConstruct
    public void setUp(Scenario scenario) {
        this.scenario = scenario;

        webDriverFactory.createDriver();
        webBot.setWebDriver(webDriverFactory.getDriver());
        actions = new ActionsHelper(webBot);
        webBot.setActions(actions);
    }

    @After
    public void tearDown() {
        webBot.getDriver().quit();
    }




}

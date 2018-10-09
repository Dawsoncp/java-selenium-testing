package com.test.cucumber.steps;

import com.test.pages.HomePage;
import com.test.session.ScenarioSession;
import com.test.webdriver.WebDriverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class BaseStep {

    @Autowired
    ScenarioSession scenarioSession;


}

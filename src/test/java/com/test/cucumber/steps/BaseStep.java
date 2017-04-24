package com.test.cucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import com.test.pages.ShopYourPointsPage;

@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class BaseStep {

    @Value("${driver}")
    String driver;
    @Autowired
    ShopYourPointsPage shopYourPointsPage;

    @Autowired
    TestPage testPage;


}

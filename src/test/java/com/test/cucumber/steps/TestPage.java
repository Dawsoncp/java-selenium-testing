package com.test.cucumber.steps;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration(locations = "classpath:cucumber.xml")
@Component
public class TestPage {

    @Value("${driver}")
    String driver;
}

package com.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage{

    private static final String PATH = "";
    private static final String PAGE_NAME = "HomePage";

    private static final By FROM_FIELD = By.id("from.text");
    private static final By TO_FIELD = By.id("to.text");
    private static final By GET_TIMES_AND_TICKETS_BUTTON = By.cssSelector("#app > div > div._19gn58z > main > div._5a1kud > div > div > div._mc6f42 > section > form > div._11rhhtw > button");

    HomePage(){
        super(PATH, PAGE_NAME);
    }

    public void enterFromStation(String station){
        webDriverUtil.enterText(FROM_FIELD, station);
    }

    public void enterToStations(String station){
        webDriverUtil.enterText(TO_FIELD, station);
    }

    public void clickGetTimesAndTicketsButton() {
        webDriverUtil.click(GET_TIMES_AND_TICKETS_BUTTON);
    }


}

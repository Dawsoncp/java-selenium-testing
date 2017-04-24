package com.test.pages;


import org.openqa.selenium.By;
import com.test.webdriver.AbstractPage;

public class AmexRewardsBasePage extends AbstractPage{

    private static final String PAGE_NAME = "Amex Rewards Homepage";
    private static final String PATH = "/index.mtw";

    AmexRewardsBasePage(){
        super(PAGE_NAME, PATH);
    }

    public static final By SEARCH_FIELD = By.id("searchLocation");
    public static final By BUY_BUTTON = By.id("buy");
}

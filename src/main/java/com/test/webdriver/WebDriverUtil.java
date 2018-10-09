package com.test.webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class WebDriverUtil {

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private WebDriverFactory webDriverFactory;

    private String driverName;



//  This post construct loads the driver after it being autowired into the RunLifeCycle class
    @PostConstruct
    public void init(){
        getDriver();
    }

    public WebDriver getDriver(){
        return webDriverFactory.getDriver();
    }

    public void quit() {
        webDriverFactory.quitDriver();
    }


//    ++++++++++++++++++++++++++++++++++++++++++++
//    webelement interactions

    public WebElement findElement(By locator) {
//        (new WebDriverWait(getDriver(), SECONDS)).until(ExpectedConditions.presenceOfElementLocated(what));
        return getDriver().findElement(locator);
    }

    public void click(By what) {
        findElement(what).click();
    }

    public void enterText(By locator, String text){
        findElement(locator).clear();
        findElement(locator).click();
        findElement(locator).sendKeys(text);
    }

    public String getText(By what) {
        return findElement(what).getText();
    }

    public String selectRandomOption(By optionElement) {
        List<WebElement> options = getSelectOptions(optionElement);

        List<String> optionsText = new ArrayList<String>();
        for(WebElement option: options){
            if(!option.isSelected()) {
                optionsText.add(option.getText());
            }
        }

        if(optionsText.isEmpty()) {
            throw new RuntimeException("No other options available");
        }

        Collections.shuffle(optionsText);

        return optionsText.get(0);
    }

    public List<WebElement> getSelectOptions(By element) {
        return new Select(findElement(element)).getOptions();
    }

    public void goToPage(String path){

        try {
            URL baseUrl = new URL(this.baseUrl);
            URL url = new URL(baseUrl, path);
            getDriver().navigate().to(url);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

}

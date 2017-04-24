package com.test.webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class WebDriverUtil {

    @Value("${baseUrl}")
    private String baseUrl;

    private WebDriver driver;

//    todo - this ActionsHelper adds an infinte loop as it references WebDriverUtil in it too. Could probably just move all the ActionsHelper methods into this class if need be
    private ActionsHelper actions;
    private static final int SECONDS = 20;



    public WebDriver getDriver(){
        return driver;
    }

    public ActionsHelper getActions() {
        return actions;
    }

    public void setActions(ActionsHelper actions) {
        this.actions = actions;
    }

    public void setWebDriver(WebDriver webDriver){
        this.driver = webDriver;
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

    public WebElement findElement(By what) {

        (new WebDriverWait(getDriver(), SECONDS)).until(ExpectedConditions.presenceOfElementLocated(what));
        return driver.findElement(what);
    }

    public void goToPage(String path){

            try {
                URL baseUrl = new URL(this.baseUrl);
                URL url = new URL(baseUrl, path);
                driver.navigate().to(url);
            } catch (MalformedURLException e){
                e.printStackTrace();
            }
    }

    public WebElement element(By what) {
        return driver.findElement(what);
    }

    public void click(By what) {
        findElement(what).click();
    }

    public void enterText(By what, String text){
        findElement(what).click();
        findElement(what).sendKeys(text);
    }

    public void hover(By what) {


    }
}

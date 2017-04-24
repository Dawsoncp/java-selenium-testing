package com.test.webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ActionsHelper {

    WebDriverUtil webBot;
    public ActionsHelper(WebDriverUtil webBot){
        this.webBot = webBot;
    }

    public void hover(By element){

        Actions action = new Actions(webBot.getDriver());
        WebElement we = webBot.findElement(element);
        action.moveToElement(we).perform();
    }
}

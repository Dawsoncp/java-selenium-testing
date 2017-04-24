package com.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;
import com.test.webdriver.AbstractPage;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopYourPointsPage extends AbstractPage{

    private static final String PAGE_NAME = "Shop Your Points Page";
    private static final String PATH = "/index.mtw?inav=gb_menu_rewards_mr_usepoints";

    ShopYourPointsPage(){
        super(PAGE_NAME, PATH);
    }

    private static final By SEARCH_FIELD = By.id("searchBox");
    private static final By SEARCH_BUTTON = By.id("csBtn");
    private static final By SHOP_HOVER = By.cssSelector(".shop-category");
    private static final By SHOP_DROPDOWN = By.cssSelector(".this");
    private static final By SHOP_DROPDOWN_ELEMENTS = By.className("nav-ellipsis");



    public void enterTextAndClickSearch(String text){
        webBot.enterText(SEARCH_FIELD, text);
        webBot.click(SEARCH_BUTTON);
    }

//    public List<String> getNavBarOptions(String navBarOption){
//
//        List<String> dropDownTitles = new ArrayList<>();
//        if(navBarOption.equalsIgnoreCase("SHOP")){
//
//            Actions action = new Actions(webBot.getDriver());
//            WebElement we = webBot.findElement(SHOP_HOVER);
////        action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("/expression-here"))).click().build().perform();
//            action.moveToElement(we).perform();
//            List<WebElement> dropDownTitleElements = webBot.findElement(SHOP_DROPDOWN).findElements(SHOP_DROPDOWN_ELEMENTS);
//
//
//            dropDownTitleElements.forEach(item->{
//                dropDownTitles.add(item.getAttribute("title"));
//            });
//        }
//        return dropDownTitles;
//    }


    public List<String> getNavBarOptions(String navBarOption){

        List<String> dropDownTitles = new ArrayList<>();
        if(navBarOption.equalsIgnoreCase("SHOP")){

            webBot.getActions().hover(SHOP_HOVER);
            List<WebElement> dropDownTitleElements = webBot.findElement(SHOP_DROPDOWN).findElements(SHOP_DROPDOWN_ELEMENTS);


            dropDownTitleElements.forEach(item->{
                dropDownTitles.add(item.getAttribute("title"));
            });
        }
        return dropDownTitles;
    }
}

package com.test.cucumber.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.List;


public class ShopYourPointsSteps extends BaseStep{

    @Given("^I navigate to the 'Shop Your Points Page'$")
    public void goToPage(){
        shopYourPointsPage.go();
    }

    @And("^I search for the text '(.*)'$")
    public void searchForText(String searchText){
        shopYourPointsPage.enterTextAndClickSearch(searchText);
    }

    @And("^the available items to select in the Shop hover over drop down equal the following$")
    public void searchForText(List<String> items){
        List<String> dropDownTitles = shopYourPointsPage.getNavBarOptions("SHOP");


    }

}

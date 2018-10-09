package com.test.cucumber.steps;

import com.test.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSteps extends BaseStep{

    @Autowired
    HomePage homePage;


    @Given("^I navigate to the Trainline home page$")
    public void goToHomePage(){
        homePage.go();
    }

    @Given("^I enter the from station '(.*)' and to station '(.*)'$")
    public void enterTrainSearchDetails(String fromStation, String toStation){
        homePage.enterFromStation(fromStation);
        homePage.enterToStations(toStation);
    }

    @When("^I click the 'Get Times & Tickets' button$")
    public void clickGetTimesAndTicketsButton() {
        homePage.clickGetTimesAndTicketsButton();
    }
}

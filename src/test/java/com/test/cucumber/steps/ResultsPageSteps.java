package com.test.cucumber.steps;


import com.test.pages.ResultsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResultsPageSteps extends BaseStep{

    @Autowired
    ResultsPage resultsPage;


    @Then("^the From '(.*)' and To '(.*)' stations are shown in the results$")
    public void assertStations(String fromName, String toName) {
        assertThat("The 'From' station name wasn't correct", resultsPage.getFromStationText(), equalTo(fromName));
        assertThat("The 'To' station name wasn't correct", resultsPage.getToStationText(), equalTo(toName));
    }
}

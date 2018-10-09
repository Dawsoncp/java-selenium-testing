package com.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;


@Component
public class ResultsPage extends AbstractPage{


    private static final String PATH = "";
    private static final String PAGE_NAME = "ResultsPage";

    private static final By FROM_TEXT = By.cssSelector("._f8rm39.undefined");
    private static final By TO_TEXT = By.cssSelector("#app > div > div._1k0bsqz > main > div._6ttgia > div._1ktkzxu > div > div > div:nth-child(2) > div:nth-child(1) > div > div._d3s87ey > div._mmfn8m > div > div > header > div > div > div > span > span:nth-child(2) > strong");

    ResultsPage() {
        super(PATH, PAGE_NAME);
    }

    public String getFromStationText() {
        return webDriverUtil.getText(FROM_TEXT);
    }

    public String getToStationText() {
        return webDriverUtil.getText(TO_TEXT);
    }

}

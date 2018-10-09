package com.test.pages;


import com.test.webdriver.WebDriverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AbstractPage implements IPage{

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    WebDriverUtil webDriverUtil;


    private String path;
    private String pageName;

    AbstractPage(String path, String pageName) {
        this.path = path;
        this.pageName = pageName;
    }

    public void go(){
        webDriverUtil.goToPage(baseUrl + path);
    }

    public String getTitle(){
        return webDriverUtil.getDriver().getTitle();
    }

    public String getPath(){
        return path;
    }


}

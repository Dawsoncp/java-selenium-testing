package com.test.webdriver;


import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractPage implements IPage{

    private final String pageName;
    private final String path;



    @Autowired
    protected WebDriverUtil webBot;

    public AbstractPage(String pageName, String path){
        this.pageName = pageName;
        this.path = path;
    }


    public String getPath() {
        return path;
    }

    public String getTitle(){
        return webBot.getDriver().getTitle();
    }

    public String getPageName(){
        return this.pageName;
    }

    public void go() {
        webBot.goToPage(this.path);
    }


}

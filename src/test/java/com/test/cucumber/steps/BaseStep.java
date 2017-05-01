package com.test.cucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import com.test.pages.ShopYourPointsPage;

@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class BaseStep {

    @Value("${driver}")
    String driver;
    @Autowired
    ShopYourPointsPage shopYourPointsPage;

    @Autowired
    TestPage testPage;

//another git test
//this is a comment in a commit to master
    //this is another comment in a commit to master

//    this is a comment in test3 branch

    //this is a comment in test4 branch

//    this is a comment in master branch
}

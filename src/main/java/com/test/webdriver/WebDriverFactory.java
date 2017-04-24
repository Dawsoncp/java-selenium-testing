package com.test.webdriver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebDriverFactory {

    private static final String DRIVER_SAFARI = "safari";
    private static final String DRIVER_CHROME = "chrome";

    @Value("${driver}")
    private String driverName;

    private WebDriver webDriver;


    protected String getDriverName(){
        return driverName;
    }

    public WebDriver getDriver(){
        return webDriver;
    }



    public WebDriver createDriver() {

        if (getDriverName().equalsIgnoreCase(DRIVER_CHROME)) {
             createChromeDriver();
        } else if (getDriverName().equalsIgnoreCase(DRIVER_SAFARI)) {
            createSafariDriver();
        }
        return getDriver();
    }


    private void createSafariDriver(){

        SafariOptions safariOpts = new SafariOptions();
        DesiredCapabilities cap = DesiredCapabilities.safari();
        safariOpts.setUseCleanSession(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
        cap.setCapability(SafariOptions.CAPABILITY, safariOpts);
        cap.setBrowserName("safari");
        cap.setPlatform(Platform.MAC);


        this.webDriver = new SafariDriver(safariOpts);
        webDriver.manage().window().fullscreen();
    }


    private void createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.webDriver = new ChromeDriver(options);
    }
}

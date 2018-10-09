package com.test.webdriver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebDriverFactory {

//    @Value("${driver}")
    private String driverName;

    private WebDriver webDriver;
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static final String DRIVER_SAFARI = "safari";
    private static final String DRIVER_CHROME = "chrome";


    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    private String getDriverName(){

        if(this.driverName != null){
            return this.driverName;
        } else {
            String driver = System.getProperty("driver");
            if(driver == null){
                //default to chrome if driver hasn't been specified
                driver = "chrome";
            }
            setDriverName(driver);
            return driver;
        }
    }

    public WebDriver getDriver(){

        String driver = getDriverName();

        if(webDriver == null){
            switch (driver.toLowerCase()) {
                case DRIVER_CHROME: webDriver = createChromeDriver();
                break;
                case DRIVER_SAFARI: webDriver = createSafariDriver();
                break;
                default: throw new RuntimeException("Valid driver name has not been specified");
            }
        }
        return webDriver;
    }

    private WebDriver createSafariDriver(){

        SafariOptions safariOpts = new SafariOptions();
        DesiredCapabilities cap = DesiredCapabilities.safari();
        safariOpts.setUseCleanSession(true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
        cap.setCapability(SafariOptions.CAPABILITY, safariOpts);
        cap.setBrowserName("safari");
        cap.setPlatform(Platform.MAC);

        SafariDriver driver = new SafariDriver(safariOpts);
        webDriver.manage().window().fullscreen();
        return driver;
    }

    private WebDriver createChromeDriver(){
        ChromeDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        if (OS.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver.exe");
        }
        driver = new ChromeDriver(options);
        return driver;
    }

    public void quitDriver(){
        if (webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }

}

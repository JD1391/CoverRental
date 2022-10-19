package com.rentalcover.driver;

import com.rentalcover.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

public final class Driver {

    private Driver(){}

    private static final String BROWSER = ConfigFactory.getConfig().browser();
    private static final String URL = ConfigFactory.getConfig().url();

    public static void initDriver(){
        if(DriverManager.getDriver() == null) {
            WebDriver driver = LocalDriverFactory.getDriver(BROWSER);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(URL);
        }
    }
    public static void quit(){
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}

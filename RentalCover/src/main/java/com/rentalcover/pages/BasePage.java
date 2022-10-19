package com.rentalcover.pages;

import com.rentalcover.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}

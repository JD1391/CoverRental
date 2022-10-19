package com.rentalcover.pages;

import com.rentalcover.driver.DriverManager;

public class QuotePage extends BasePage {

    public String getQuotePageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}

package com.rentalcover.pages;

import com.rentalcover.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Select or type a country']")
    private WebElement txtBoxCountry;

    @FindBy(xpath = "//a[@href='#QuoteForm-country-field']")
    private WebElement lnkResidentialCountry;

    @FindBy(xpath ="//input[@placeholder='Type a country']")
    private WebElement txtBoxResidentialCountry;

    @FindBy(id = "QuoteForm_FromDate-datepicker")
    private WebElement clkFromDate;

    @FindBy(id ="QuoteForm_ToDate-datepicker")
    private WebElement clkToDate;

    @FindBy(xpath = "//button[@type='submit']//span[@class='btn-text'][normalize-space()='Get Your Instant Quote']")
    private WebElement btnSubmit;

    private static final String DATE = "//td[@data-handler='selectDay']/a[text()='%s']";

    public static HomePage getInstance(){
        return new HomePage();
    }

    public HomePage enterCountryDetailWith(String country){
        txtBoxCountry.sendKeys(country);
        return this;
    }

    public HomePage enterResidentialCountryDetails(String country){
        SeleniumUtils.scrollAndClickTheElement(lnkResidentialCountry);
        this.clearAndEnterCountryName(country);
        return this;
    }

    public void clearAndEnterCountryName(String country){
        SeleniumUtils.clearText(txtBoxResidentialCountry);
        txtBoxResidentialCountry.sendKeys(country);
    }

    public HomePage selectFromDate(String fromDate){
        clkFromDate.click();
        By fromDateXpath = By.xpath(String.format(DATE, fromDate));
        SeleniumUtils.click(fromDateXpath);
        return this;
    }

    public HomePage selectToDate(String toDate){
        clkToDate.click();
        By toDateXpath = By.xpath(String.format(DATE, toDate));
        SeleniumUtils.click(toDateXpath);
        return this;
    }

    public QuotePage getInstantQuoteForEnteredDetail(){
        SeleniumUtils.scrollAndClickTheElement(btnSubmit);
        return new QuotePage();
    }

}

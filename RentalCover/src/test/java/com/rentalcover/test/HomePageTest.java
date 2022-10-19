package com.rentalcover.test;

import com.google.common.base.Predicates;
import com.rentalcover.config.ConfigFactory;
import com.rentalcover.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private static final String RENTAL_COUNTRY = ConfigFactory.getConfig().rentalCountry();
    private static final String FROM_DATE = ConfigFactory.getConfig().fromDate();
    private static final String TO_DATE = ConfigFactory.getConfig().toDate();
    private static final String PARTIAL_TITLE = ConfigFactory.getConfig().actualString();

    @Test
    public void getAnInstantQuote(){
        String quotePageTitle = HomePage.getInstance()
                .enterCountryDetailWith(RENTAL_COUNTRY)
                .selectFromDate(FROM_DATE)
                .selectToDate(TO_DATE)
                .enterResidentialCountryDetails(RENTAL_COUNTRY)
                .getInstantQuoteForEnteredDetail()
                .getQuotePageTitle();

        Assert.assertTrue(quotePageTitle.contains(PARTIAL_TITLE)
                , "Quote Page not loaded or Title does not contain "+ PARTIAL_TITLE);
    }
}

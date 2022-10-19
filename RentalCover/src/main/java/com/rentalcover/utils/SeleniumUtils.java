package com.rentalcover.utils;

import com.rentalcover.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class SeleniumUtils {



     private SeleniumUtils(){}

     public static void click(By by){
          WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
          wait.until(ExpectedConditions.elementToBeClickable(by))
                  .click();
     }

     public static void scrollAndClickTheElement(WebElement element){
          JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
          js.executeScript("arguments[0].scrollIntoView(true);", element);
          DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          js.executeScript("arguments[0].click();", element);
     }

     public static void clearText(WebElement element){
          element.sendKeys(Keys.CONTROL, Keys.chord("a"));
          element.sendKeys(Keys.DELETE);
     }
}

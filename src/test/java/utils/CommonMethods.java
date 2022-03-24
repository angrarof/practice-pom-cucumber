package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import settings.DriverSetup;

import java.time.Duration;

public class CommonMethods extends DriverSetup {
    private final HomePage homePage = new HomePage(driver);

    public void waitForElementAndClick(String element, String page){
        WebElement button = searchElementOnPage(element, page);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    ////////////////////////////////////////////////////////////////////////
    public WebElement searchElementOnPage(String element, String page){
        switch (page){
            case "home":
                switch (element){
                    case "button one":
                        return homePage.getButtonOne();
                }
        }
        return null;
    }

}

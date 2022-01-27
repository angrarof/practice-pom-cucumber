package pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.WaitingTimeSetup;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(WaitingTimeSetup.getWaitForElement()));
        actions = new Actions(this.driver);
    }

    public void waitElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitElementClickable(element);
        element.click();
        Select select = new Select(element);
        //frame index, idname, frameelement
        //select id, value, visibleText
    }

    public void cleanText(WebElement element){
        waitElementClickable(element);
        element.clear();
    }

    public void enterText(WebElement element, String text){
        waitElementToAppear(element);
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element){
        waitElementToAppear(element);
        actions.moveToElement(element).perform();
    }
}

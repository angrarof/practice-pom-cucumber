package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(xpath = "bt1")
    private WebElement button_one;

    @FindBy(xpath = "bt2")
    private WebElement button_two;

    public WebElement getButtonOne(){
        return button_one;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}

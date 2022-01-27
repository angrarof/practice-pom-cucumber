package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavBarPage extends BasePage{

    @FindBy(id = "store_nav_search_term")
    private WebElement searchInput;

    @FindBy(css = ".match_name")
    private List<WebElement> suggestedGames;

    public List<WebElement> getSuggestedGames() {
        return suggestedGames;
    }

    public void writeTextOnSearchInput(String text){
        enterText(searchInput,text);
    }

    public void cleanTextOnSearchInput(){
        cleanText(searchInput);
    }

    public NavBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}

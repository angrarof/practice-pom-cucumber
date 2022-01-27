package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.NavBarPage;
import settings.DriverSetup;

public class NavBarSteps extends DriverSetup {
    NavBarPage navBarPage = new NavBarPage(driver);

    @When("I write {} game for search")
    public void iWriteGameForSearch(String game){
        navBarPage.writeTextOnSearchInput(game);
    }

    @Then("I validate system displays more than {int} games")
    public void iValidateSystemDisplaysGames(int number){
        int foundedGames = navBarPage.getSuggestedGames().size();
        Assert.assertTrue(foundedGames>number,"There number of displayed games is less or equal than 4");
    }

    @And("I validate each result contains the word {}")
    public void iValidateResultsContainsWord(String word){
        for(WebElement e:navBarPage.getSuggestedGames()){
            Assert.assertTrue(e.getText().toLowerCase().contains(word), "Text not presented in element.");
        }
    }
}

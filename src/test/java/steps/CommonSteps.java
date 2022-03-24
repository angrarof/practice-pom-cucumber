package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import settings.DriverSetup;
import settings.PropertiesFile;
import utils.CommonMethods;

public class CommonSteps extends DriverSetup {
    private CommonMethods commonMethods = new CommonMethods();

    @Given("I load home page")
    public void iLoadHomePage(){
        driver.get(new PropertiesFile().getProperty("url"));
    }

    @When("I click on button {string} on page {string}")
    public void iClickOnButton(String button, String page){
        commonMethods.waitForElementAndClick(button, page);
    }
}

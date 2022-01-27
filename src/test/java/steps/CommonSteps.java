package steps;

import io.cucumber.java.en.Given;
import settings.DriverSetup;
import settings.PropertiesFile;

public class CommonSteps extends DriverSetup {

    @Given("I load home page")
    public void iLoadHomePage(){
        driver.get(new PropertiesFile().getProperty("url"));
    }
}

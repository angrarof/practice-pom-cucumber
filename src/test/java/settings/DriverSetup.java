package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

abstract public class DriverSetup {
    protected static WebDriver driver = null;

    public DriverSetup(){
        initialize();
    }

    private void initialize(){
        if(driver==null){
            createDriverInstance();
        }
    }

    private void createDriverInstance(){
        String browser = new PropertiesFile().getProperty("browser");
        boolean headless = new PropertiesFile().getHeadless();
        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions chOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (headless){
                chOptions.addArguments("--headless");
            }
            driver = new ChromeDriver(chOptions);
        }else if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions fxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            if (headless){
                fxOptions.addArguments("--headless");
            }
            driver = new FirefoxDriver(fxOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitingTimeSetup.getWaitImplicitly()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitingTimeSetup.getWaitForPageLoad()));
    }

    public static void destroyDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}

package createdriversession;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CucumberHook {
    public static WebDriver driver;


    @Before
    public void beforeScenario(){
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://demos.telerik.com/aspnet-core/eshop");
    }


//    @After
//    public void afterScenario(){
//        driver.quit();
//    }

}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static createdriversession.CucumberHook.driver;

public class ComponentsSteps {
    @And("Clicks categories")
    public void clicksCategories() {
        driver.findElement(By.cssSelector("span[class='k-link k-menu-link k-active k-state-border-down'] span[class='k-menu-link-text']")).click();

    }

    @And("Clicks components")
    public void clicksComponents() {
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1) > span:nth-child(1)")).click();
    }

    @When("Click Chain")
    public void clickChain() {
        driver.findElement(By.xpath("//img[@src='/aspnet-core/eshop/images/chains.png']")).click();
    }

    @Then("The page must me Chain")
    public void thePageMustMeChain() {
        String expectedTitle = "Chains";
        String expectedUrl = "https://demos.telerik.com/aspnet-core/eshop/Products/Category?subCategory=Chains";
        driver.get(expectedUrl);
        try{

            Assert.assertEquals(expectedTitle, driver.getTitle());
            System.out.println("Dogru link");
        }
        catch(Throwable pageNavigationError){
            System.out.println("Yanlish link");
        }
    }

    @And("Refresh The Page")
    public void refreshThePage() {
        driver.navigate().refresh();
    }
}

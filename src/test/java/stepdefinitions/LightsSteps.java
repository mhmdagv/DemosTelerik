package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LightsSteps extends BaseMethods{
    @When("Click to Lights button")
    public void clickToLightsButton(){
        driver.findElement(By.linkText("Lights")).click();
    }

    @Then("User should not see discounted items on the page")
    public void userShouldNotSeeDiscountedItemsOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement>elements = driver.findElements(By.className("discount-pct"));
        Assert.assertTrue(elements.isEmpty());
    }

    @When("Click Headlights - Dual-Beam checkbox")
    public void clickHeadlightsDualBeamCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[value = 'Headlights - Dual-Beam']")).click();
    }

    @And("Click five star checkbox")
    public void clickFiveStarCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[value = '5']")).click();
    }

    @Then("User should see Headlights - Dual-Beam item on the page")
    public void userShouldSeeHeadlightsDualBeamItemOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = driver.findElement(By.className("card-title")).getText();
        String expectedText = "Headlights - Dual-Beam";
        Assert.assertEquals(actualText,expectedText);
    }
}

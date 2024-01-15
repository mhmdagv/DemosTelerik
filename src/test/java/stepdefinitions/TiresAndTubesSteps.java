package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TiresAndTubesSteps extends BaseMethods{
    @When("Click to Tires and Tubes button")
    public void clickToTiresAndTubesButton() {
        driver.findElement(By.linkText("Tires and Tubes")).click();
    }

    @Then("User should  see discounted items on the page")
    public void userShouldSeeDiscountedItemsOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement>elements = driver.findElements(By.className("discount-pct"));
        for (WebElement element:elements){
            boolean flag = false;
            String actualText = element.getText();
            if (actualText.contains("15% off")||actualText.contains("50% off")){
                flag = true;
            }
            Assert.assertTrue(flag);
        }
    }

    @When("Click HL Mountain Tire checkbox")
    public void clickHLMountainTireCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id = 'modelPicker']/li[1]/input")).click();
    }

    @Then("User should see HL Mountain Tire item on the page")
    public void userShouldSeeHLMountainTireItemOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = driver.findElement(By.className("card-title")).getText();
        String expectedText = "HL Mountain Tire";
        Assert.assertEquals(actualText,expectedText);
    }
}

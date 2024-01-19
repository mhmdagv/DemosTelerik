package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LocksStep extends BaseMethods{
    @When("Click to Locks button")
    public void clickToLocksButton(){
        driver.findElement(By.linkText("Locks")).click();
    }

    @When("Click Cable Lock checkbox")
    public void clickCableLockCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id = 'modelPicker']/li/input")).click();
    }

    @Then("User should see Cable Lock item on the page")
    public void userShouldSeeCableLockItemOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = driver.findElement(By.className("card-title")).getText();
        String expectedText = "Cable Lock";
        Assert.assertEquals(actualText,expectedText);
    }
}

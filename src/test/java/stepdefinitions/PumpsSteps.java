package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PumpsSteps extends BaseMethods{
    @When("Click to Pumps button")
    public void clickToPumpsButton(){
        driver.findElement(By.linkText("Pumps")).click();
    }

    @When("Click Minipump checkbox")
    public void clickMinipumpCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id = 'modelPicker']/li[1]/input")).click();
    }

    @Then("User should see Minipump item on the page")
    public void userShouldSeeMinipumpItemOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = driver.findElement(By.className("card-title")).getText();
        String expectedText = "Minipump";
        Assert.assertEquals(actualText,expectedText);
    }


}

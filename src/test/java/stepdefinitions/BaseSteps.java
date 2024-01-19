package stepdefinitions;


import elements.MountainBike;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BaseSteps extends BaseMethods{

    MountainBike mountainBikePom;
    {
        mountainBikePom = MountainBike.getInstance();
    }
    @Given("User is in {string} page")
    public void userWantTo(String arg0)  {

    }

    @Then("Items should be list according to {string} {string}")
    public void itemsShouldBeListAccordingTo(String from, String to) throws InterruptedException {
        double fromNumber = Double.parseDouble(from.replace("," , ""));
        double toNumber = Double.parseDouble(to.replace("," , ""));

        Thread.sleep(6000);
        List<WebElement> list = getElements(mountainBikePom.getItemsPrice());
        for (WebElement element: list){
            double price = Double.parseDouble(element.getText().replace("," , "").replace("$" , ""));
            System.out.println(price);
            Assert.assertTrue((fromNumber <= price) && (price <= toNumber) , "price: " + price);
        }

    }



}

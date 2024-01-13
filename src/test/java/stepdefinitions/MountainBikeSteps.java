package stepdefinitions;

import elements.MountainBike;
import io.cucumber.java.az.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static enums.ExpectedConditionType.INVISIBLE;
import static enums.ExpectedConditionType.VISIBLE;

public class MountainBikeSteps extends BaseMethods{
    MountainBike mountainBikePom;
    {
        mountainBikePom = MountainBike.getInstance();
    }


    @Then("User should see bikes according to {string} filter")
    public void userShouldSeeBikesAccordingToMountainFilter(String expectedText) throws InterruptedException {
        explicitWait(mountainBikePom.getPageSizeDropdown() , VISIBLE , 20);
        getElement(mountainBikePom.getPageSizeDropdown()).click();
        Thread.sleep(1000);
        getJsExecutor().executeScript("arguments[0].click();", getElement(mountainBikePom.getPageSize48Option()));
        Thread.sleep(2000);
        String[] array = expectedText.split("&");
        List<WebElement> elements = getElements(mountainBikePom.getInventoryElements());
        for(WebElement element: elements){
            boolean flag2 = false;
            for(int i = 0 ; i< array.length; i++){
                if(element.getText().toLowerCase().contains(array[i].toLowerCase())){
                    flag2 =true;
                }
            }
            Assert.assertTrue(flag2);
        }


    }

    @And("Clicks bike category")
    public void clicksBikeCategory() {
        getElement(mountainBikePom.getBikeCategory()).click();

    }

    @And("Clicks mountain bike category")
    public void clicksMountainBikeCategory() {
        getElement(mountainBikePom.getMountainBikeCategory()).click();
    }

    @And("Clicks {string} filter checkbox")
    public void clicksMountainFilterCheckbox(String s) throws InterruptedException {
        String[] array = s.split("&");
        explicitWait(mountainBikePom.getModelCheckboxes() , VISIBLE , 20);
        List<WebElement> list = getElements(mountainBikePom.getModelCheckboxes());
        System.out.println(list.size());//mountain-100
        for(WebElement element: list){
            for(int i = 0; i<array.length; i++){
                if(element.getText().equalsIgnoreCase(array[i])){
                    element.findElement(By.tagName("input")).click();
                }
            }

        }

    }

    @And("Clicks {string} checkbox for rating")
    public void clicksCheckboxForRating(String value) throws InterruptedException {
        Thread.sleep(3000);
        String[] array = value.split("&");
        for(String a : array){
            String locator = mountainBikePom.getRatingCheckbox();
            locator = locator.replace("rate" , a);
            getJsExecutor().executeScript("arguments[0].click();",getElement(By.xpath(locator)));

        }
    }

    @When("User choose price interval from {string} {string}")
    public void userChoosePriceIntervalFrom(String from , String to) throws InterruptedException {
        Thread.sleep(2000);
        String s = mountainBikePom.getPrice();
        String s2 = s;
        s = s.replace("price" , "$" + from);
        getActions().dragAndDrop(getElement(mountainBikePom.getFromCircle()), getElement(By.xpath(s))).perform();

        s2 = s2.replace("price" , "$" + to);
        getActions().dragAndDrop(getElement(mountainBikePom.getToCircle()), getElement(By.xpath(s2))).perform();



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


    @Given("User is in fast fingers page")
    public void userIsInFastFingersPage() {
        driver.get("https://10fastfingers.com/typing-test/english");
    }

    @When("Clicks allow all button")
    public void clicksAllowAllButton() {
        By locator = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
        explicitWait(locator , VISIBLE , 40);
        getElement(locator).click();
    }

    @And("Fill the input field with highlited texts")
    public void fillTheInputFieldWithHighlitedTexts() {
        explicitWait(By.className("highlight") , VISIBLE ,40);
        WebElement input = getElement(By.id("inputfield"));
        String text;
        while(true){
            try{
                text = getElement(By.className("highlight")).getText() + " ";
            }catch(NoSuchElementException e){
                break;
            }
            input.sendKeys(text);
        }
    }
}

package stepdefinitions;

import Pom.BottlesCagesPom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class BottlesCagesSteps extends BaseMethods {
    BottlesCagesPom bottlesCagesPom;

    public BottlesCagesSteps(){
        bottlesCagesPom = BottlesCagesPom.getInstance();
    }



    @When("Click to login button")
    public void clickToLoginButton() {
        getElement(By.className("k-button")).click();
    }

    @And("Move to Categories button")
    public void moveToCategoriesButton() {
        Actions actions = new Actions(driver);
        WebElement element = getElement(By.xpath("//*[@id = 'HeaderMenu']/li[1]/span/span[1]"));
        actions.moveToElement(element);
    }

    @And("Click to Accessories button")
    public void clickToAccessoriesButton() {
        getElement(By.linkText("Accessories")).click();
    }

    @When("Click to BottlesCages button")
    public void clickToBottlesCagesButton() {
        getElement(By.linkText("Bottles & Cages")).click();
    }

    @And("Click to Discounted items only radio button")
    public void clickToDiscountedItemsOnlyRadioButton() {
        getElement(By.xpath("//*[text() = 'Discounted items only']")).click();
    }

    @Then("User should see discounted items on the page")
    public void userShouldSeeDiscountedItemsOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement>elements =getElements(By.className("discount-pct"));
        for (WebElement element:elements){
            String actualText = element.getText();
            String expectedText = "15% off";
            Assert.assertEquals(actualText,expectedText);
        }
    }

    @When("Click to {string} button")
    public void clickToButton(String model) throws InterruptedException {
        Thread.sleep(3000);
         String[] array = model.split("&");
         List<WebElement>elements = getElements(By.xpath("//*[@class = 'k-checkbox-item']"));
         for (WebElement element:elements){
             for (int i = 0;i< array.length;i++){
                 if (element.getText().toLowerCase().contains(array[i].toLowerCase())){
                     element.findElement(By.tagName("input")).click();
                 }
             }
         }
    }


    @Then("User should see {string} on the page")
    public void userShouldSeeOnThePage(String model) throws InterruptedException {
        Thread.sleep(3000);
        String[] array = model.split("&");
        List<WebElement>elements = getElements(By.className("card-title"));
        for (WebElement element:elements){
            boolean flag = false;
            for (int i = 0;i< array.length;i++){
                if (element.getText().toLowerCase().contains(array[i].toLowerCase())){
                    flag = true;
                }
            }
            Assert.assertTrue(flag);
        }
    }

    @When("Click {string} button")
    public void clickButton(String value) throws InterruptedException {
        Thread.sleep(3000);
        String[] array = value.split("&");
        for (int i = 0;i< array.length;i++){
            String locator = "//*[@id = 'ratingPicker']//input[@value = 'rate']";
            locator = locator.replace("rate",array[i]);
           getElement(By.xpath(locator)).click();
        }
    }

    @Then("Users should see {string} on the page")
    public void usersShouldSeeOnThePage(String ratingText) throws InterruptedException {
        Thread.sleep(3000);
        String[] array = ratingText.split("&");
        List<WebElement>elements = getElements(By.className("rating-text"));
        for (WebElement element:elements){
            for (int i = 0;i< array.length;i++){
                boolean flag = false;
                if (element.getText().contains(array[i])){
                    flag = true;
                    Assert.assertTrue(flag);
                }else {
                    Assert.assertTrue(elements.isEmpty());
                }
            }


        }
    }



    @When("Click Mountain Bottle Cage checkbox")
    public void clickMountainBottleCageCheckbox() throws InterruptedException {
        Thread.sleep(5000);
        getElement(By.cssSelector("[value = 'Mountain Bottle Cage']")).click();
    }

    @And("Click three star checkbox")
    public void clickThreeStarCheckbox() throws InterruptedException {
        Thread.sleep(5000);
        getElement(By.cssSelector("[value = '3']")).click();
    }

    @Then("User should see Mountain Bottle Cage item on the page")
    public void userShouldSeeMountainBottleCageItemOnThePage() throws InterruptedException {
        Thread.sleep(5000);
        String actualText = getElement(By.className("card-title")).getText();
        String expectedText = "Mountain Bottle Cage";
        Assert.assertEquals(actualText,expectedText);

    }

    @When("User choose price interval {string} {string}")
    public void userChoosePriceInterval(String from, String to) throws InterruptedException {
        Thread.sleep(3000);
        String locator = "//*[@title = 'price']";
        locator = locator.replace("price","$"+from);
        String locator2 = "//*[@title = 'price']";
        locator2 = locator2.replace("price","$"+to);
        WebElement circle = getElement(By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(circle,driver.findElement(By.xpath(locator))).perform();
        WebElement circle2 = getElement(By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[2]"));
        actions.dragAndDrop(circle2,driver.findElement(By.xpath(locator2))).perform();
    }

    @Then("Items should be list according to {string} {string}")
    public void itemsShouldBeListAccordingTo(String from, String to) throws InterruptedException {
        Thread.sleep(5000);
        double fromNum = Double.parseDouble(from.replace(",",""));
        double toNum = Double.parseDouble(to.replace(",",""));
        List<WebElement>elements = getElements(By.className("card-price"));
        for (WebElement element:elements){
            boolean flag = false;
            String s = element.getText().replace(",","").replace("$","");
            double price = Double.parseDouble(s);
            if (fromNum<=price&&price<=toNum){
                flag = true;
                Assert.assertTrue(flag);
            }else {
                Assert.assertTrue(elements.isEmpty());
            }

        }

    }


}

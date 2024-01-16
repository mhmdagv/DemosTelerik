package stepdefinitions;

import elements.JerseysClothesPom;
import enums.ExpectedConditionType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class JerseysClothesSteps extends BaseMethods {
    JerseysClothesPom jerseysClothesPom;

    {
        jerseysClothesPom = JerseysClothesPom.getInstance();
    }

    @And("Clicks clothes category")
    public void clicksClothesCategory() {
        getElement(JerseysClothesPom.getInstance().getClothesBtn()).click();
    }

    @And("Clicks jerseys clothes category")
    public void clicksJerseysClothesCategory() {
        getElement(JerseysClothesPom.getInstance().getJerseysCgr()).click();
    }

    @Given("User want to {string} filters")
    public void userWantToFilters(String arg0) {
    }

    @When("Clicks {string} filter checkboxes")
    public void clicksFilterCheckboxes(String arg0) {
    }


    @And("User Clicks {string} radio button")
    public void userClicksRadioButton(String rate) throws InterruptedException {
        Thread.sleep(2000);
        String[] s = rate.split("&");
        for (String element : s) {
            Thread.sleep(3000);
            String ratingFilter = "//*[@name='ratingPicker']//input[@value='" + element + "']";
            ratingFilter = ratingFilter.replace("locator", "s");
//            By rateclick = By.xpath(ratingFilter);
            getJsExecutor().executeScript("arguments[0].click();", getElement(By.xpath(ratingFilter)));

        }
    }

    @Then("user should see {string} stars clothes on the page")
    public void userShouldSeeStarsBikesOnThePage(String rate) throws InterruptedException {
        Thread.sleep(3000);
        String[] s = rate.split("&");
        List<WebElement> elements = getElements(jerseysClothesPom.getRateText());
        for (WebElement element : elements) {
            System.out.println(element.getText() + "_______________");
            boolean flag = false;
            for (String a : s) {
                if (element.getText().contains(a)) {
                    flag = true;
                }
            }
            Assert.assertTrue(flag);

        }
    }


    @Then("User should see clothes according to {string} filter")
    public void userShouldSeeClothesAccordingToFilter(String s) throws InterruptedException {
        Thread.sleep(5000);
//        explicitWait(jerseysClothesPom.getPageSizeDropdown(), ExpectedConditionType.VISIBLE, 30);
//        getElement(jerseysClothesPom.getPageSizeDropdown()).click();
//        getJsExecutor().executeScript("arguments[0].click();", getElement(jerseysClothesPom.getPageSize48Option()));
        Thread.sleep(5000);
        List<WebElement> elements = getElements(jerseysClothesPom.getText());
        String[] array = s.split("&");
        for (WebElement element : elements) {
            boolean flag = false;
            for (int i = 0; i < array.length; i++) {
                if (element.getText().toLowerCase().contains(array[i].toLowerCase())) {
                    flag = true;

                }

            }
            Assert.assertTrue(flag);
        }

    }

    @Then("User should see clothes according to {string} {string} filters")
    public void userShouldSeeClothesAccordingToFilters(String color, String text) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = getElements(jerseysClothesPom.getText());
        String[] arr = color.split("&");
        for (WebElement element : elements) {
            for (String a : arr) {
                if (element.isSelected()) {
                    Assert.assertTrue(element.getText().contains(text));
                }
            }
        }
    }
}
package stepdefinitions;

import elements.LoginPom;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;

public class BaseSteps extends BaseMethods{
    LoginPom loginPom;
    {
        loginPom = LoginPom.getInstance();
    }

    @Given("User want to {string}")

    public void userWantTo(String arg0) throws InterruptedException {
    }

    @When("Click to login button")
    public void clickToLoginButton() throws InterruptedException{
        Thread.sleep(2000);
        getElement(loginPom.getLoginBtn()).click();

    }


}

package elements;

import lombok.Data;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

@Data
public final class LoginPom {


    private final By loginBtn = By.cssSelector(".k-form-submit");

    private LoginPom(){

    }

    private static LoginPom INSTANCE; // 1

    public static LoginPom getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new LoginPom();
        }
        return INSTANCE;
    }

}

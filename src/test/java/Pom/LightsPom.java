package Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class LightsPom {
    private final By lightsBtn = By.linkText("Lights");
    private final By discountedItemsText = By.className("discount-pct");
    private final By dualBeamBtn = By.cssSelector("[value = 'Headlights - Dual-Beam']");
    private final By fiveStarBtn = By.cssSelector("[value = '5']");
    private final By itemsText = By.className("card-title");








    private LightsPom(){

    }

    private static LightsPom Instance;

    public static LightsPom getInstance(){
        if (Instance == null){
            Instance = new LightsPom();
            return Instance;
        }
        return Instance;
    }
}

package Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class TiresAndTubesPom {
    private final By tiresAndTubesBtn = By.linkText("Tires and Tubes");
    private final By discountedItemsText = By.className("discount-pct");
    private final By hlMountainTireBtn = By.xpath("//*[@id = 'modelPicker']/li[1]/input");
    private final By itemsText = By.className("card-title");



    private TiresAndTubesPom(){

    }

    private static TiresAndTubesPom Instance;


    public static TiresAndTubesPom getInstance(){
        if (Instance == null){
            Instance = new TiresAndTubesPom();
            return Instance;
        }
        return Instance;
    }
}

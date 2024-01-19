package Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class PumpsPom {
    private final By pumpsBtn = By.linkText("Pumps");
    private final By minipumpBtn = By.xpath("//*[@id = 'modelPicker']/li[1]/input");
    private final By itemsText = By.className("card-title");







    private PumpsPom(){
    }


    private static PumpsPom Instance;

    public static PumpsPom getInstance(){
        if (Instance == null){
            Instance = new PumpsPom();
            return Instance;
        }
        return Instance;
    }
}

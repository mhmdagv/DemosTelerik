package Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class BottlesCagesPom {

    private final By loginBtn = By.className("k-button");
    private final By categoriesBtn = By.xpath("//*[@id = 'HeaderMenu']/li[1]/span/span[1]");
    private final By accessoriesBtn = By.linkText("Accessories");
    private final By bottlesCages = By.linkText("Bottles & Cages");
    private final By discountedItemsBtn = By.xpath("//*[text() = 'Discounted items only']");
    private final By discountedItemsText = By.className("discount-pct");
    private final By modelsItemsCheckbox = By.xpath("//*[@class = 'k-checkbox-item']");
    private final By itemsText = By.className("card-title");
    private final By ratingText = By.className("rating-text");
    private final By MountainBottleCagecheckbox = By.cssSelector("[value = 'Mountain Bottle Cage']");
    private final By ThreeStarCheckbox = By.cssSelector("[value = '3']");
    private final By circle = By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[1]");
    private final By circle2 = By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[2]");
    private final By itemsPrice = By.className("card-price");










    private BottlesCagesPom(){

    }

    private static BottlesCagesPom Instance;

    public static BottlesCagesPom getInstance(){
        if (Instance == null){
            Instance = new BottlesCagesPom();
            return Instance;
        }
        return Instance;
    }
}

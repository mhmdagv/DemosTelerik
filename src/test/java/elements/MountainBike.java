package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class MountainBike {

    private final By bikeCategory = By.xpath("//*[@src = '/aspnet-core/eshop/images/bikes.png']");
    private final By mountainBikeCategory = By.xpath("//*[@src = '/aspnet-core/eshop/images/mountain_bikes.png']");
    private final By modelCheckboxes = By.xpath("//*[@class = 'k-checkbox-item']");
    private final By inventoryElements = By.className("card-title");
    private final By pageSizeDropdown = By.xpath("//*[@id=\"allProductsListView_pager\"]/span[1]/span/span[2]/span");
    private final By pageSize48Option = By.xpath("/html/body/div[4]/div/div/div[2]/ul/li[4]/span");
    private final String ratingCheckbox = "//*[@id = 'ratingPicker']//input[@value='rate']";
    private final String price = "//*[@title = 'price']";
    private final By fromCircle = By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[1]");
    private final By toCircle = By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[2]");
    private final By itemsPrice = By.className("card-price");
    private MountainBike(){

    }

    private static MountainBike INSTANCE; // 1

    public static MountainBike getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new MountainBike();
        }
        return INSTANCE;
    }

}

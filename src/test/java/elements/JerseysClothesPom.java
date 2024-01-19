package elements;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class JerseysClothesPom {

    protected final By clothesBtn = By.linkText("Clothes");
    protected final By jerseysCgr = By.linkText("Jerseys");
    protected final By rateText = By.className("avg-rating");
    private final  By text         = By.className("card-title");
    private final By pageSizeDropdown = By.xpath("//*[@id='allProductsListView_pager']/span[1]/span/span[2]/span");
    private final By pageSize48Option = By.xpath("/html/body/div[4]/div/div/div[2]/ul/li[4]/span");



    private JerseysClothesPom(){
    }
    private static JerseysClothesPom INSTANCE;
     public static JerseysClothesPom getInstance(){
         if(INSTANCE == null){
             INSTANCE=new JerseysClothesPom();
         }
         return INSTANCE;
     }
}

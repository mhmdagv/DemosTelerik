package elements;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class ShortsPom {
    protected final By shortsCtgr = By.linkText("Shorts");


    private ShortsPom(){

    }
    private static ShortsPom INSTANCE;
    public static ShortsPom getInstance(){
        if(INSTANCE ==null){
            return new ShortsPom();
        }
        return INSTANCE;
    }
}

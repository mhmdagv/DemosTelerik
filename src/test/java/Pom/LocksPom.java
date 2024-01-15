package Pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class LocksPom {
    private final By locksBtn = By.linkText("Locks");
    private final By cableLockBtn = By.cssSelector("[value = 'Cable Lock']");
    private final By itemsText = By.className("card-title");




    private LocksPom(){

    }


    private static LocksPom Instance;


    public static LocksPom getInstance(){
        if (Instance == null){
            Instance = new LocksPom();
            return Instance;
        }
        return Instance;
    }
}

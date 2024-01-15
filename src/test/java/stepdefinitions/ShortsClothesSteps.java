package stepdefinitions;

import elements.ShortsPom;
import io.cucumber.java.en.And;

public class ShortsClothesSteps extends BaseMethods {
     ShortsPom shortsPom;
    {
        shortsPom= ShortsPom.getInstance();
    }


    @And("Clicks shorts clothes category")
        public void clicksshortsclothescategory(){
    getElement(shortsPom.getShortsCtgr()).click();
        }
    }


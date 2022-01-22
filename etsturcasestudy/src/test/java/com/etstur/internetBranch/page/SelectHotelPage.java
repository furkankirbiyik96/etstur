package com.etstur.internetBranch.page;

import com.etstur.internetBranch.constants.SelectHotel_Constants;
import org.openqa.selenium.WebDriver;

public class SelectHotelPage extends SelectHotel_Constants {

    public SelectHotelPage(WebDriver driver) {
        super(driver);
    }

    public SelectHotelPage selectHotel(){
        waitForElement(driver,5,SELECTROOM);
        scrollElement(driver.findElement(SELECTROOM));
        clickFirstElementWithJavaScript(SELECTROOM);
        return this;
    }

    public PersonalInformationPage callPersonalInformatıonPage(){
        waitForElement(driver,5,GENDER);
        scrollElement(driver.findElement(GENDER));
        clickFirstElementWithJavaScript(GENDER);
        return new PersonalInformationPage(driver);
    }

}

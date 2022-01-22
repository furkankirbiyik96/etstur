package com.etstur.internetBranch.constants;

import com.etstur.internetBranch.base.BasePageUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectHotel_Constants extends BasePageUtil<T> {
    public SelectHotel_Constants(WebDriver driver) {
        super(driver);
    }
    public By HOTELROOMLIST = By.id("hotelRoomList");
    public By BUYBUTTON = By.linkText("Odayı Seç");
    public By SELECTROOM = By.xpath("//*[@class='room-checkout-link'][1]");
    public By GENDER = By.id("cb-male_0_0");
}

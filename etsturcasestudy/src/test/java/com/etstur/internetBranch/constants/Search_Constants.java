package com.etstur.internetBranch.constants;

import com.etstur.internetBranch.base.BasePageUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search_Constants extends BasePageUtil<T> {
    public Search_Constants(WebDriver driver) {
        super(driver);
    }

    public By SEARCHTEXT = By.id("tb-autocomplete");
    public By CHECKIN = By.id("checkIn");
    public By CHECKOUT = By.id("checkOut");
    public By TODAY = By.cssSelector(".today");
    public By REGION = By.cssSelector(".REGION:nth-of-type(1) b");
    public By REGIONALL = By.xpath("//*[@class='row']//ul/li[1]/span[1]");
    public By SPINNERBUTTON = By.xpath("//div[@id='guestAdultSpinner']/span[1]/button[@type='button']");
    public By GUEST = By.cssSelector(".sf-guests");
    public By SEARCHBUTTON = By.xpath("//button[contains(@class,'btn-search')]");
    public By ARROWBUTTON = By.cssSelector("div#hotelList > div:nth-of-type(1)  .items > .row");
    public By HOTELROOMLIST = By.id("hotelRoomList");
    public By NOTFOUNHOTELS = By.id("notFoundHotels");
    public By BUYBUTTON = By.linkText("Odayı Seç");
    public By SELECTROOM = By.xpath("//*[@class='room-checkout-link'][1]");

}

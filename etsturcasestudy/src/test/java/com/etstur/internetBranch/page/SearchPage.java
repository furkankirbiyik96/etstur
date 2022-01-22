package com.etstur.internetBranch.page;


import com.etstur.internetBranch.constants.Search_Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.Iterator;
import java.util.Set;

public class SearchPage extends Search_Constants {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage selectArea(String areaName){
        closePopUpWizard();
        setObjectBy(SEARCHTEXT,areaName);
        clickObjectBy(REGIONALL);
        clickObjectBy(CHECKIN);
        doubleclickObjectBy(TODAY);
        clickObjectBy(GUEST);
        if (isElementPresentAndDisplay(SPINNERBUTTON)){
            clickObjectBy(SPINNERBUTTON);
        }
        clickObjectBy(SEARCHBUTTON);
        closePopUpWizard();
        waitForElement(driver,5,ARROWBUTTON);
        scrollElement(driver.findElement(ARROWBUTTON));
        clickObjectBy(ARROWBUTTON);
        Set<String> windowhandles=driver.getWindowHandles();
        Iterator<String> iterator = windowhandles.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();
        driver.switchTo().window(childwindow);
        waitForElement(driver,5,HOTELROOMLIST);
        scrollElement(driver.findElement(HOTELROOMLIST));
        return this;
    }

    public SearchPage notFoundHotels(String areaName){
        closePopUpWizard();
        setObjectBy(SEARCHTEXT,areaName);
        clickObjectBy(REGIONALL);
        clickObjectBy(CHECKIN);
        doubleclickObjectBy(TODAY);
        clickObjectBy(GUEST);
        if (isElementPresentAndDisplay(SPINNERBUTTON)){
            clickObjectBy(SPINNERBUTTON);
        }
        clickObjectBy(SEARCHBUTTON);
        if (isElementPresentAndDisplay(NOTFOUNHOTELS)){
            Assert.assertTrue("Arama kriterlerinize uygun bir sonuç bulunamadı. mesajı görülemedi",getElementBy(NOTFOUNHOTELS).getText().contains("Arama kriterlerinize uygun bir sonuç bulunamadı."));
            System.out.println("Search sayfasında "+getElementBy(NOTFOUNHOTELS).getText() +"mesajı görüldü.");
        }
        return this;
    }

    public SelectHotelPage callSelectHotelPage(){
        return new SelectHotelPage(driver);
    }

}

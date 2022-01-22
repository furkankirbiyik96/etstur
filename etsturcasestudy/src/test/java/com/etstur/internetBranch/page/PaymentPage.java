package com.etstur.internetBranch.page;

import com.etstur.internetBranch.constants.Payment_Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends Payment_Constants {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage setPayment(String cardName,String cardNo,String cvvNo,String areaName){
        setObjectBy(CARDNAME,"ETSTUR");
        setObjectBy(CARDNO,"5112352900020320");
        clickObjectBy(CARDVALIDMONTH);
        clickObjectBy(CARDVALIDYEAR);
        setObjectBy(CVC,"233");
        Assert.assertTrue("Rezervasyon Özetinde Hatalı Lokasyon!!!",getElementBy(MAPLOCATION).getText().contains(areaName));
        scrollElement(driver.findElement(SERVISAGGREMENTCHECHBOX));
        clickFirstElementWithJavaScript(SERVISAGGREMENTCHECHBOX);
        clickFirstElementWithJavaScript(KVKKCHECHBOX);
        clickFirstElementWithJavaScript(BOOKBUTTON);
        if (isElementPresentAndDisplay(ERRORRESERVATIONMESSAGE)){
            closePopUpWizard();
            System.out.println("Ödeme sayfasında "+getElementBy(ERRORRESERVATIONMESSAGE).getText() +" mesajı görüldü...");
            screenShot();
            //Assert.assertEquals("Rezervasyonunuz tamamlanamadı mesajı görülemedi",getElementBy(ERRORRESERVATIONMESSAGE).getText(),"Rezervasyonunuz tamamlanamadı!");
        }
        if (isElementPresentAndDisplay(ERRORMESSAGE)){
            Assert.assertTrue("paymentStatus: undefined mesajı görülemedi",getElementBy(ERRORMESSAGE).getText().contains("payment"));
        }
        return this;
    }

    public PaymentPage controlFailMessage(){
        clickFirstElementWithJavaScript(BOOKBUTTON);
        Assert.assertTrue("İsim soyisim hanesini doldurunuz mesajı görülemedi",getElementBy(NAMEANDSURNAMEMESSAGE).getText().contains("İsim soyisim hanesini doldurunuz"));
        Assert.assertTrue("Kredi kartı numarasını giriniz. mesajı görülemedi",getElementBy(CREDITCARDFAILMESSAGE).getText().contains("Kredi kartı numarasını giriniz."));
        Assert.assertTrue("Ay Seçiniz mesajı görülemedi",getElementBy(SETMONTHFAILMESSAGE).getText().contains("Ay Seçiniz"));
        Assert.assertTrue("Yıl Seçiniz mesajı görülemedi",getElementBy(SETYEARFAILMESSAGE).getText().contains("Yıl Seçiniz"));
        Assert.assertTrue("CVC giriniz mesajı görülemedi",getElementBy(SETCVVFAILMESSAGE).getText().contains("CVC giriniz"));
        return this;
    }


}

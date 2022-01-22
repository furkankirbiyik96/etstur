package com.etstur.internetBranch.page;

import com.etstur.internetBranch.constants.PersonalInformation_Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PersonalInformationPage extends PersonalInformation_Constants {

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public PersonalInformationPage setPersonalInformation(String name,String surName,String birthdate,String email,String phonenumber,String tckn){
        setObjectBy(NAME,name);
        setObjectBy(SURNAME,surName);
        setObjectBy(BIRTHDATE,birthdate);
        setObjectBy(EMAIL,email);
        setObjectBy(PHONENUMBER,phonenumber);
        setObjectBy(TCKN,tckn);
        scrollElement(driver.findElement(CALLMEFAILBOOKINGCHECHBOX));
        clickFirstElementWithJavaScript(CALLMEFAILBOOKINGCHECHBOX);
        clickFirstElementWithJavaScript(PERMITNOTIFICATIONCHECHBOX);
        clickFirstElementWithJavaScript(PREBOOKBUTTON);
        return this;
    }

    public PersonalInformationPage controlFailMessage(){
        clickFirstElementWithJavaScript(PREBOOKBUTTON);
        Assert.assertTrue("Lütfen isim bilgisi giriniz. mesajı görülemedi",getElementBy(NAMEFAILMESSAGE).getText().contains("Lütfen isim bilgisi giriniz."));
        Assert.assertTrue("Lütfen soyisim bilgisi giriniz. mesajı görülemedi",getElementBy(SURNAMEFAILMESSAGE).getText().contains("Lütfen soyisim bilgisi giriniz."));
        Assert.assertTrue("Doğum tarihi giriniz mesajı görülemedi",getElementBy(BIRTHDATEFAILMESSAGE).getText().contains("Doğum tarihi giriniz"));
        Assert.assertTrue("Lütfen email giriniz. mesajı görülemedi",getElementBy(EMAILFAILMESSAGE).getText().contains("Lütfen email giriniz."));
        return this;
    }

    public PaymentPage callPaymentPage(){
        waitForElement(driver,5,CARDNAME);
        scrollElement(driver.findElement(CARDNAME));
        return new PaymentPage(driver);
    }

}

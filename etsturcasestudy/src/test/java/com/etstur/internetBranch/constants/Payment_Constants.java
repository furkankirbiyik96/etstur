package com.etstur.internetBranch.constants;

import com.etstur.internetBranch.base.BasePageUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment_Constants extends BasePageUtil<T> {

    public Payment_Constants(WebDriver driver) {
        super(driver);
    }

    //Payment Information
    public By CARDNAME = By.id("creditCardOwnerName");
    public By CARDNO = By.id("tb-creditCardNumber");
    public By CARDVALIDMONTH = By.xpath("//select[@name='creditCardValidMonth']/option[@value='01']");
    public By CARDVALIDYEAR = By.xpath("//select[@name='creditCardValidYear']/option[@value='23']");
    public By CVC = By.xpath("//*[@name='creditCardCVC']");
    public By SERVISAGGREMENTCHECHBOX = By.id("serviceAggrement");
    public By KVKKCHECHBOX = By.id("kvkApproval");
    public By BOOKBUTTON = By.id("btn-book");
    public By ERRORMESSAGE = By.xpath("//*[@class='alert alert-danger mt-4']");
    public By MAPLOCATION = By.xpath("//*[@class='card-body res-info']/ul//span[1]");
    public By ERRORBUTTON = By.linkText("BAŞKA KART İLE ÖDE");
    public By ERRORRESERVATIONMESSAGE = By.cssSelector(".error-reservation");

    //Error Message Payment Information
    public By CREDITCARDFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Kredi kartı numarasını giriniz.'])[1]");
    public By NAMEANDSURNAMEMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='İsim soyisim hanesini doldurunuz'])[1]");
    public By SETMONTHFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ay Seçiniz'])[1]");
    public By SETYEARFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yıl Seçiniz'])[1]");
    public By SETCVVFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CVC giriniz'])[1]");



}

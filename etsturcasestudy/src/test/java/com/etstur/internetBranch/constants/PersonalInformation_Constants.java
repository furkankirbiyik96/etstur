package com.etstur.internetBranch.constants;

import com.etstur.internetBranch.base.BasePageUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInformation_Constants extends BasePageUtil<T> {

    public PersonalInformation_Constants(WebDriver driver) {
        super(driver);
    }

    //PERSONAL INFORMATION
    public By GENDER = By.id("cb-male_0_0");
    public By NAME = By.id("tb-name_0_0");
    public By SURNAME = By.id("tb-surname_0_0");
    public By BIRTHDATE = By.id("tb-birthdate_0_0");
    public By EMAIL = By.id("tb-email_0_0");
    public By PHONENUMBER = By.id("contactFormPhoneNumber-g1");
    public By TCKN = By.id("tckn_0_0");
    public By CALLMEFAILBOOKINGCHECHBOX = By.id("callMeOnFailBooking");
    public By PERMITNOTIFICATIONCHECHBOX = By.id("cb-permitNotification");
    public By PREBOOKBUTTON = By.id("btn-preBook");
    public By CARDNAME = By.id("creditCardOwnerName");

    //FAILED MESSAGES PERSONAL INFORMATION
    public By BIRTHDATEFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Doğum Tarihi'])[1]/following::div[1]");
    public By EMAILFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::div[1]");
    public By SURNAMEFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Soyisim'])[1]/following::div[1]");
    public By NAMEFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='İsim'])[1]/following::div[1]");
    public By GENDERFAILMESSAGE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cinsiyet seçiniz'])[1]");

}

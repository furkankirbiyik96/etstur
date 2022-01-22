package com.etstur.internetBranch.page;

import com.etstur.internetBranch.constants.Main_Constants;
import com.etstur.internetBranch.util.WaitTool;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MainPage extends Main_Constants {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String customerNo, String password){
        Assert.assertTrue("Ana sayfa açılamadı", WaitTool.waitElementDisplay(driver, MYACCOUNT, 10));//Ana sayfanın açıldığının kontrolü
        HoverElement(MYACCOUNT, true);
        clickObjectBy(LOGIN);
        Assert.assertTrue("Login sayfası açılamadı", WaitTool.waitElementDisplay(driver, USERNAME, 10));//Login sayfasının açıldığının kontrolü
        setObjectBy(USERNAME, customerNo);
        setObjectBy(PASSWORD, password);
        clickObjectBy(BTNLOGIN);
        closePopUpWizard();
        Assert.assertTrue("Ana sayfada hesap adı görüntülenemedi",getElementBy(ACCOUNTNAME).getText().contains("ETSTUR CASESTUDY"));
        return this;
    }

    public MainPage unSuccessLoginWithWrongPassword(String customerNo, String password){
        Assert.assertTrue("Ana sayfa açılamadı", WaitTool.waitElementDisplay(driver, MYACCOUNT, 10));//Ana sayfanın açıldığının kontrolü
        HoverElement(MYACCOUNT, true);
        clickObjectBy(LOGIN);
        Assert.assertTrue("Login sayfası açılamadı", WaitTool.waitElementDisplay(driver, USERNAME, 10));//Login sayfasının açıldığının kontrolü
        setObjectBy(USERNAME, customerNo);
        setObjectBy(PASSWORD, password);
        clickObjectBy(BTNLOGIN);
        if (isElementPresentAndDisplay(LOGINALERT)){
        Assert.assertTrue("Girdiğiniz şifre yanlış. Lütfen tekrar deneyin. mesajı görülemedi",getElementBy(LOGINALERT).getText().contains("Girdiğiniz şifre yanlış."));
        System.out.println(getElementBy(LOGINALERT).getText());
        }
        return this;
    }

    public MainPage unSuccessLoginWithWrongUserName(String customerNo, String password){
        Assert.assertTrue("Ana sayfa açılamadı", WaitTool.waitElementDisplay(driver, MYACCOUNT, 10));//Ana sayfanın açıldığının kontrolü
        HoverElement(MYACCOUNT, true);
        clickObjectBy(LOGIN);
        Assert.assertTrue("Login sayfası açılamadı", WaitTool.waitElementDisplay(driver, USERNAME, 10));//Login sayfasının açıldığının kontrolü
        setObjectBy(USERNAME, customerNo);
        setObjectBy(PASSWORD, password);
        clickObjectBy(BTNLOGIN);
        if (isElementPresentAndDisplay(LOGINALERT)){
            Assert.assertTrue("E-posta adresiniz sistemimizde kayıtlı değildir. Lütfen üyelik oluşturunuz. mesajı görülemedi", getElementBy(LOGINALERT).getText().contains("E-posta adresiniz sistemimizde kayıtlı değildir."));
            System.out.println(getElementBy(LOGINALERT).getText());
        }
        return this;
    }


    public SearchPage callSearchPage(){
        Assert.assertTrue("Ana sayfada hesap adı görüntülenemedi",getElementBy(ACCOUNTNAME).getText().contains("ETSTUR CASESTUDY"));
        return new SearchPage(driver);
    }

}

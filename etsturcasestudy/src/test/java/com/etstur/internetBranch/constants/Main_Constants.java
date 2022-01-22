package com.etstur.internetBranch.constants;

import com.etstur.internetBranch.base.BasePageUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main_Constants extends BasePageUtil<T> {
    public Main_Constants(WebDriver driver) {
        super(driver);
    }

    public By MYACCOUNT = By.cssSelector(".dropbtn.nothidden");
    public By LOGIN = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Giriş Yap'])[2]/following::span[1]");
    public By USERNAME = By.id("tb-contactEmailSignIn");
    public By PASSWORD = By.id("showPass_2");
    public By BTNLOGIN = By.id("btn-signin");
    public By ACCOUNTNAME = By.cssSelector("b.username");
    public By LOGINALERT = By.id("loginAlert");
}

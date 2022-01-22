package com.etstur.internetBranch.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    protected WebDriver driver;
    public static String browserName = "chrome";
    public static String baseUrl = "https://www.etstur.com/";
    public static String areaName = "Samsun";

    @BeforeClass
    public static void setupClass(){
        switch(browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
        }
    }

    @Before
    public void setUp() throws Exception {
        //Browser ayarları
        Locale.setDefault(new Locale("en", "EN"));
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("test-type");
                chromeOptions.addArguments("--ignore-certifcate-errors");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-gpu");  //
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-plugins");
                chromeOptions.addArguments("--disable-plugins-discovery");
                chromeOptions.addArguments("--disable-preconnect");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("'--dns-prefetch-disable'");
                chromeOptions.addArguments("--disable-gtesteolocation");
                chromeOptions.addArguments("--disable-save-password-bubble");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("dom.webnotifications.enabled", false);
                driver = new FirefoxDriver(options);
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println(baseUrl);
        driver.get(baseUrl);
        System.out.println("Browser Name = " + browserName);
    }

    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
            Date now1 = new Date();
            String strDate1 = sdfDate1.format(now1);
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//dd/MM/yyyy
            Date now = new Date();
            String strDate = sdfDate.format(now);
            String filefolder = "./FailScreenshots/" + strDate1 + "/";
            File f = new File(filefolder + strDate + ".jpeg");
            try {
                FileUtils.copyFile(scrFile, new File(f.getPath()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        @Override
        protected void finished(Description description) {
            if (driver != null)
                driver.quit();
            System.out.println("Test is done");
        }

    };
/*
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
*/
}

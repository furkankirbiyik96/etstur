package com.etstur.internetBranch.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.etstur.internetBranch.util.WaitTool;

public class BasePageUtil <T> {

    protected WebDriver driver;

    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
    }



    protected WebElement setObjectBy(By by, String value) {
        WebElement element = getElementBy(by);
        HighlightElement(element);
        element.clear();
        element.sendKeys(value);
        return element;
    }


    protected void HighlightElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }

    protected WebElement clickObjectBy(By by) {
        WaitTool.waitForElementClickable(driver, by, 10);
        WebElement element = driver.findElement(by);
        HighlightElement(element);
        element.click();
        return element;
    }

    protected WebElement doubleclickObjectBy(By by) {
        Actions act = new Actions(driver);
        WaitTool.waitForElementClickable(driver, by, 10);
        WebElement element = driver.findElement(by);
        act.doubleClick(element).perform();
        return element;
    }

    public WebElement getElementBy(By by) {
        return driver.findElement(by);
    }


    protected WebElement clickElementByText(By by, String text) {
        WaitTool.waitForElementClickable(driver, by, 10);
        WebElement element = driver.findElement(by);
        if( element.getText().contains(text)){
            HighlightElement(element);
            element.click();
        }
        sleep(1000);
        return element;
    }


    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void closePopUpWizard(){
        sleep(500);
        if (isElementPresentAndDisplay(By.xpath("//button[@type='button']"))) {
            clickObjectBy(By.xpath("//button[@type='button']"));
        }
    }



    public boolean isElementPresentAndDisplay(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void waitForElement(WebDriver driver, int seconds, By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, seconds, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    protected void HoverElement(By by, boolean click) {

        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.moveToElement(element).build().perform();
        if (click) {
            clickObjectBy(by);
        }

    }


    public WebElement scrollElement (WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        sleep(1000);
        return element;
    }

    public void clickFirstElementWithJavaScript (By elementBy){
        WebElement ele = driver.findElement(elementBy);
        HighlightElement(ele);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",ele);
    }


    public void screenShot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now1 = new Date();
        String strDate1 = sdfDate1.format(now1);
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        String filefolder = "./Screenshots/" + strDate1 + "/";

        File f = new File(filefolder + strDate + ".jpeg");
        try {
            FileUtils.copyFile(scrFile, new File(f.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

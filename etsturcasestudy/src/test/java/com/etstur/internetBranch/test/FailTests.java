package com.etstur.internetBranch.test;

import com.etstur.internetBranch.base.BaseTest;
import com.etstur.internetBranch.page.MainPage;
import com.etstur.internetBranch.util.ReadProperties;
import org.junit.Test;

public class FailTests extends BaseTest {

    @Test

    public void unSuccessLoginWithWrongPassword(){
        new MainPage(driver)
                .unSuccessLoginWithWrongPassword(ReadProperties.getCustomerNo(),"wrongpassword");
    }

    @Test

    public void unSuccessLoginWithWrongUserName(){
        new MainPage(driver)
                .unSuccessLoginWithWrongUserName(ReadProperties.getCustomerNo(),"wrongusername@gmail.com");
    }

    @Test

    public void notFoundHotels(){
        new MainPage(driver)
                .login(ReadProperties.getCustomerNo(),ReadProperties.getPassword())
                .callSearchPage()
                .notFoundHotels("Rotterdam");
    }

    @Test

    public void controlFailMessageWithPersonalInformationPage(){
        new MainPage(driver)
                .login(ReadProperties.getCustomerNo(),ReadProperties.getPassword())
                .callSearchPage()
                .selectArea(areaName)
                .callSelectHotelPage()
                .selectHotel()
                .callPersonalInformatıonPage()
                .controlFailMessage();

    }

    @Test

    public void controlFailMessageWithPaymentInformationPage(){
        new MainPage(driver)
                .login(ReadProperties.getCustomerNo(),ReadProperties.getPassword())
                .callSearchPage()
                .selectArea(areaName)
                .callSelectHotelPage()
                .selectHotel()
                .callPersonalInformatıonPage()
                .setPersonalInformation(ReadProperties.getCustomerName(),ReadProperties.getCustomerSurName(),ReadProperties.getBirthdate(),ReadProperties.getCustomerNo(),ReadProperties.getPhoneNumber(),ReadProperties.getTCKN())
                .callPaymentPage()
                .controlFailMessage();

    }

}

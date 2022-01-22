package com.etstur.internetBranch.test;

import com.etstur.internetBranch.base.BaseTest;
import com.etstur.internetBranch.page.MainPage;
import com.etstur.internetBranch.util.ReadProperties;
import org.junit.Test;

public class HotelReservationCheckTests extends BaseTest {

@Test

    public void hotelReservationAndPaymentControl(){
    new MainPage(driver)
            .login(ReadProperties.getCustomerNo(),ReadProperties.getPassword())
            .callSearchPage()
            .selectArea(areaName)
            .callSelectHotelPage()
            .selectHotel()
            .callPersonalInformatıonPage()
            .setPersonalInformation(ReadProperties.getCustomerName(),ReadProperties.getCustomerSurName(),ReadProperties.getBirthdate(),ReadProperties.getCustomerNo(),ReadProperties.getPhoneNumber(),ReadProperties.getTCKN())
            .callPaymentPage()
            .setPayment(ReadProperties.getCustomerName()+ReadProperties.getCustomerSurName(),ReadProperties.getCardNo(),ReadProperties.getCVVNo(),areaName);
}

}

package com.etstur.internetBranch.util;

import com.etstur.internetBranch.base.BaseTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    static Properties userProperties;
    static {
        userProperties = new Properties();
        try {
            InputStream propertiesStream = BaseTest.class.getClassLoader().getResourceAsStream("user.properties");
            userProperties.load(propertiesStream);
            propertiesStream.close();
            propertiesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCustomerNo(){
        return userProperties.getProperty("_CUSTOMERNO");
    }

    public static String getPassword() {
        String password = userProperties.getProperty("_PASSWORD");
        System.out.println("Password at properties file: " + password);
        return password;
    }
    public static String getCardNo(){
        return userProperties.getProperty("_CARDNO");
    }
    public static String getCustomerName(){
        return userProperties.getProperty("_CUSTOMERNAME");
    }
    public static String getCustomerSurName(){
        return userProperties.getProperty("_CUSTOMERSURNAME");
    }
    public static String getCVVNo(){
        return userProperties.getProperty("_CVV");
    }
    public static String getBirthdate(){
        return userProperties.getProperty("_BIRTHDATE");
    }
    public static String getPhoneNumber(){
        return userProperties.getProperty("_PHONENUMBER");
    }
    public static String getTCKN(){
        return userProperties.getProperty("_TCKN");
    }
}

package tests;

import myproject.com.MainPage;
import myproject.com.RegistrationPage;
import myproject.com.utils.Property;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @DataProvider
    public Object[][] validDataRegistration(){
        String email = java.util.UUID.randomUUID().toString() + "@gmail.com";
        return new Object[][] {new Object[] {"test", "test", email
                                            , "Ukraine", "1234567", "test"
                                            , "test", "test", "test"
                                            , "test", "test", "UA"
                                            , "Google", "test", "test123!"
                                            , "test123!", true}};
    }

    @Test(dataProvider = "validDataRegistration")
    public void registation(String firstname, String lastname, String email
            , String phonecode, String phonenumber, String companyname
            , String firstaddress, String secondaddress, String city
            , String state, String postcode, String country
            , String findus,  String mobileNumber, String firstpassword
            , String secondpassword, Boolean subcsribe) throws InterruptedException {
        driver.navigate().to(Property.getData("registration.url"));
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = registrationPage.validRegistration(firstname, lastname, email
                ,phonecode, phonenumber, companyname
                ,firstaddress, secondaddress, city
                , state, postcode, country
                , findus, mobileNumber, firstpassword
                , secondpassword, subcsribe);
        Assert.assertTrue(mainPage.waitForPageLoad());
        mainPage.logOut();
    }
}

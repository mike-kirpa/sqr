package tests;

import myproject.com.LoginPage;
import myproject.com.MainPage;
import myproject.com.utils.Property;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends BaseTest {

    @Test(description = "Логин", enabled = true)
    public void loginTest(){
        driver.navigate().to(Property.getData("base.url"));
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.login(Property.getData("user.email"), Property.getData("user.password"), "test", false);
        Assert.assertTrue(mainPage.waitForPageLoad());
        mainPage.logOut();
    }

    @DataProvider
    public Object[] wrongEmails() {
        return new Object[] {".m@gmail.com", "m.@gmail.com", "m..1@gmail.com", "m@gmail"};

    }
    @Test(dataProvider = "wrongEmails")
    public void wrongLogin(String email){
        driver.navigate().to(Property.getData("base.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.wrongLogin(email, Property.getData("user.password"));
        Assert.assertTrue(loginPage.isWrongLogin());
    }


}

package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage{

    private By emailField = By.id("inputEmail");
    private By passwordField = By.id("inputPassword");
    private By rememberMe =  By.name("rememberme");
    private By submitButton = By.id("login");
    private By forgotPassword = By.className("btn btn-default");
    private String titleText = "Login This page is restricted";
    private By loginPageTitle = By.className("header-lined");
    private By wrongLoginElement = By.className("alert-danger");
    private String wrongLoginText = "Login Details Incorrect. Please try again.";

    public LoginPage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
    }

    public boolean isWrongLogin(){
        System.out.println(driver.findElement(wrongLoginElement).getText());
        if(driver.findElement(wrongLoginElement).getText() != wrongLoginText) {return true;}
        else {return false;}
    }


    public MainPage login(String email, String password, Boolean remember) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        if(remember == true) driver.findElement(rememberMe).click();
        driver.findElement(submitButton).click();
        return new MainPage(driver);
    }

    public void wrongLogin(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.textToBe(loginPageTitle, titleText));
    }

}

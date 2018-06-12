package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class RegistrationPage extends AbstractPage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
    }

    private By firstNameField = By.id("inputFirstName");
    private By lastNameField = By.id("inputLastName");
    private By emailField = By.id("inputEmail");
    private By phoneCodeList = By.className("selected-flag");
    private By phoneNumberField = By.id("inputPhone");
    private By companyNameField = By.id("inputCompanyName");
    private By firstAddressField = By.id("inputAddress1");
    private By seconfAddressField = By.id("inputAddress2");
    private By cityField = By.id("inputCity");
    private By stateField = By.id("stateinput");
    private By postCodeField = By.id("inputPostcode");
    private By countryList = By.id("inputCountry");
    private By findUsList = By.id("customfield1");
    private By mobileNumberField = By.id("customfield2");
    private By firstPasswordFiled = By.id("inputNewPassword1");
    private By secondPasswordField = By.id("inputNewPassword2");
    private By mailSubscribeCheckbox = By.className("bootstrap-switch-wrapper");
    private By captchaFieild = By.id("inputCaptcha");
    private By submitFormButton = By.className("btn-large");
    private By registrationPageTitle = By.className("header-lined");
    private String registrationPageTitleText = "Register";

    public MainPage validRegistration(String firstname, String lastname, String email
                                        , String phonecode, String phonenumber, String companyname
                                        , String firstaddress, String secondaddress, String city
                                        , String state, String postcode, String country
                                        , String findus,  String mobileNumber, String firstpassword
                                        , String secondpassword, Boolean subcsribe) throws InterruptedException {
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        //driver.findElement(emailField).sendKeys(java.util.UUID.randomUUID().toString() + "@gmail.com");
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneCodeList).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + phonecode + "')]")).click();
        driver.findElement(phoneNumberField).sendKeys(phonenumber);
        driver.findElement(companyNameField).sendKeys(companyname);
        driver.findElement(firstAddressField).sendKeys(firstaddress);
        driver.findElement(seconfAddressField).sendKeys(secondaddress);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(postCodeField).sendKeys(postcode);
        driver.findElement(countryList).click();
        new Select(driver.findElement(countryList)).selectByValue(country);
        new Select(driver.findElement(findUsList)).selectByValue(findus);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
        driver.findElement(firstPasswordFiled).sendKeys(firstpassword);
        driver.findElement(secondPasswordField).sendKeys(secondpassword);
        if(!subcsribe) driver.findElement(mailSubscribeCheckbox).click();
        infoBox("Введите капчу", "Alert");
        while (driver.findElement(captchaFieild).getAttribute("value").length() != 5){
            Thread.sleep(5000);
        }
        driver.findElement(submitFormButton).click();
        return new MainPage(driver, firstname);
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    private void waitForPageLoad() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.textMatches(registrationPageTitle, Pattern.compile(registrationPageTitleText)));
    }
}

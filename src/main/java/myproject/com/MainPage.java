package myproject.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{

    private By welcomeTitle = By.id("Secondary_Navbar-Account");
    private String welcomeText = "Hello, test!  ";
    private By logOutButton = By.className("primary-action");
    private String firstname;


    public MainPage(WebDriver driver, String firstname) {
        super(driver);
        this.firstname = firstname;
        waitForPageLoad();
    }

    public String getWelcomeTitleText(){
        return driver.findElement(welcomeTitle).getText();
    }

    public void logOut(){
        driver.findElement(logOutButton).click();
    }

    public CharSequence getSuccessLoginText() {
        return welcomeText;
    }

    public boolean waitForPageLoad() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try{
            webDriverWait.until(ExpectedConditions.textToBe(welcomeTitle, "Hello, " + firstname + "!  "));
            return true;
        } catch (Exception e){
            return false;
        }

    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By logingButtonBy = By.id("login-button");
    By lockedUsermessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");



    String baseURL = "https://www.saucedemo.com/";

    public LoginPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(logingButtonBy);
        return this;
    }

    public LoginPage verifyUnsucessfullLogin(String expectedText){
        String actualTitle = readText(lockedUsermessage);
        assertTextEquals(expectedText, actualTitle);
        return this;
    }
    
    public LoginPage verifySucessfullLogout(){
        assertElementVisible(logingButtonBy);
        return this;
    }
}

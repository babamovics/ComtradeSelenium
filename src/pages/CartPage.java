package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    
    By shoopingCartConfirmation = By.xpath("//*[@id='header_container']/div[2]/span");

    public CartPage verifyCartEntry(String expectedText){
        String actualTitle = readText(shoopingCartConfirmation);
        assertTextEquals(expectedText, actualTitle);

        return this;
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    By menuButton = By.xpath("//*[@id='react-burger-menu-btn']");
    By logoutButton = By.xpath("//*[@id='logout_sidebar_link']");
    By homePageTittleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By logoutVerificationField = By.xpath("//*[@id='login_credentials']/h4");
    By shoopingCart = By.xpath("//*[@id='shopping_cart_container']/a");
    By verifyHomePageTittle = By.xpath("//*[@id='header_container']/div[2]/span");
    By AllItemsButton = By.xpath("//*[@id='inventory_sidebar_link']");
    String expectedHref = "https://saucelabs.com/";
    By AboutButton = By.xpath("//*[@id='about_sidebar_link']");
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");
    By sortDropdownBy=By.xpath("//select[@class='product_sort_container']");
    By productTitlesBy=By.xpath("//*[@class='inventory_item_name']/div");
    By productPriceBy=By.xpath("//*[@class='inventory_item_price']");
    
    public HomePage verifyAllItemsPage(String expectedText){
        String actualTitle = readText(homePageTittleBy);
        assertTextEquals(expectedText, actualTitle);

        return this;
    }

    public HomePage clickOnHamburgerMenu(){
        click(menuButton);
        return this;
        
    }

    public HomePage clickOnLogoutButton(){
        click(logoutButton);
        return this;
    }

    public HomePage clickOnShoopingCartButton(){
        click(shoopingCart);
        return this;
    }

    public HomePage clickOnAllItemsButton(){
    click(AllItemsButton);
    return this;
    }

    public HomePage verifyAboutLink(){
        String actualHref = readHref(AboutButton);
        assertTextEquals(expectedHref, actualHref);
        return this;
    }
    public HomePage selectSortOptionsByValue(String value){
        selectDropdownOptionsByValue(sortDropdownBy,value);
        return this;
    }
    public HomePage validateFirstProductName(String expectedName){
        String firstProductTitle=readTextFromIndexElement(productTitlesBy,0);
        assertTextEquals(firstProductTitle,expectedName);
        return this;

    }
    public HomePage validateFirstProductPrice(String expectedPrice){
        String firstProductPrice=readTextFromIndexElement(productPriceBy,0);
        assertTextEquals(firstProductPrice,expectedPrice);
        return this;
    }
    
    public HomePage validateNumberOfProducts(int expectedNumberOfProducts){
        int actualNumberOFProducts = locateElements(numberOfItemsBy).size();
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOFProducts);
        return this;
    } 
    
    
}

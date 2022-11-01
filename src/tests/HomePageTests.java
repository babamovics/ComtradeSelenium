package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String cartVerification = "YOUR CART";
    String AllItemsVerification = "PRODUCTS";
    int numberOfAllItems = 6;
    String expectedProductNameZASort="Test.allTheThings() T-Shirt(RED)";
    String expectedProductNameLOHISort="Sauce Labs Onesie";
    @Test
    public void VerifyCartEntry(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    cartPage = new CartPage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnShoopingCartButton();
    cartPage.verifyCartEntry(cartVerification);
    }

    @Test
    public void VerifyCartToAllItems(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnShoopingCartButton();
    homePage.clickOnHamburgerMenu();
    homePage.clickOnAllItemsButton();
    homePage.verifyAllItemsPage(AllItemsVerification);

    }
    @Test
    public void VerifyAboutLink(){
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnHamburgerMenu();
    homePage.verifyAboutLink();

    }

    @Test
    public void checkNumberOfItemsOnHomePage(){

    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.validateNumberOfProducts(numberOfAllItems);
    }

    @Test
    public void checkSortFromZtoA(){
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername,password);
        homePage.selectSortOptionsByValue("za");
    }
    @Test
    public void checkSortLowToHigh(){
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage= new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername,password);
        homePage.selectSortOptionsByValue("lohi");
    }
}


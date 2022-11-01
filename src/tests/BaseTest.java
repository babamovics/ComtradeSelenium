package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\QA28\\Desktop\\seleniumFolder\\Seleniumexample\\lib\\geckodriver.exe");
               
        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        driver = new FirefoxDriver(options);
        
        //driver = new FirefoxDriver();

        //driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }
    
}

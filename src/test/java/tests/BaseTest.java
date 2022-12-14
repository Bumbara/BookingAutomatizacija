package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {

protected WebDriver driver;

    @BeforeTest
    public void setup(){
    driver = DriverManager.getInstance().setDriver("chrome");
    driver.get("https://www.booking.com/");
    }
}

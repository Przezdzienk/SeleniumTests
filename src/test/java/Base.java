import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    WebDriver driver;

    @BeforeEach
    public void driverSet(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.navigate().to("https://www.saucedemo.com/index.html");
    }
    @AfterEach
    public void stopDriver(){
        driver.quit();
    }

}

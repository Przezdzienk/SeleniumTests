import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    WebDriver driver;
    String WebSite="https://www.saucedemo.com/index.html";

    @BeforeEach
    public void driverSet(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.navigate().to(WebSite);
    }
    @AfterEach
    public void stopDriver(){
        driver.quit();
    }

}

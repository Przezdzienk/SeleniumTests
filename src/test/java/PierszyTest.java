import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PierszyTest {

    WebDriver driver;

    @BeforeEach
    public void driverSet(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver= new FirefoxDriver();
    }
    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
    @Test
    public void firstTest(){
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        driver.navigate().to("https://manganelo.com/");
        driver.navigate().back();

        Assert.assertEquals("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna",driver.getCurrentUrl());

        driver.navigate().forward();

        Assert.assertEquals("https://manganelo.com/",driver.getCurrentUrl());

    }
}

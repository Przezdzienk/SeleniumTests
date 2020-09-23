import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PierszyTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        WebDriver driver= new FirefoxDriver();
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.quit();

    }
}
